package CarSubscription;

import java.util.Scanner;


import java.util.Properties;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.text.ParseException;
import java.util.ArrayList;

import mailservice.Email.*;

public class CarDeriverClass {
	
	public static final String ACCOUNT_SID = "AC4830c1e51c9e8f32c58af62e6c140230";
	  public static final String AUTH_TOKEN = "c9a657862b0818093ac4f0f115c541b1";
	  public static void smsService(String mobile) {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	      Message sms = Message.creator(
	    		  new com.twilio.type.PhoneNumber("+91" + mobile ),
	              new com.twilio.type.PhoneNumber("+19896013579"),
	              "Happy Booking!Your car is ready for Journey")
	          .create();

	      //System.out.println(message.getSid());
	  }
	  
	  
	
	public static void main(String[] args) throws ParseException {
		
			ArrayList<Car> cars = new ArrayList<Car>();
			cars.add(new Car("TN111234", 2));
			cars.add(new Car("TN122222", 1));
			cars.add(new Car("TN163333", 4));
			cars.add(new Car("TN104444", 3));
			
			ArrayList<CarBooking> reservations = new ArrayList<CarBooking>();
			
			
			System.out.println(">>>>>>>......Welcome to Car Subscription Service......<<<<<<<<<");
			
			int startingValue = 1;
			Scanner obj = new Scanner(System.in);
			
			for(Car carObj : cars) {
				carObj.displayCarInfo();
			}
			
			while(startingValue == 1) {
				System.out.println("Please Enter 1 to book your Car , Press 2 to exit");
				startingValue = obj.nextInt();
				if(startingValue == 1) {
					CarBooking reservation = new CarBooking();
					if(reservation.isAvailable(reservations,cars)) {
						reservations.add(reservation);
						smsService(reservation.mobile);
						Pdf pdfobj = new Pdf();
						try {
							pdfobj.pdfGenerator();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						EmailService mailObj = new EmailService();
						mailObj.triggerEmail(reservation.mailId);
						System.out.println("Your car is ready to travel, Thanks for choosing us.");
					} else {
						System.out.println("Sorry for the inconvience...! Cars not available ");
					}
				}
			}
			
			
	}

}
