package CarSubscription;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CarBooking {
	
	String customerName;
	String mailId;
	String carNo;	
	Date date;
	String mobile;
	
	public CarBooking() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println(">>>>>> Please enter your name <<<<<< \n");
		customerName = scan.next();
		System.out.println(">>>>>> Please enter your mail <<<<<< \n");
		mailId = scan.next();
		System.out.println(">>>>>> Please enter your mobile number <<<<<< \n");
		mobile = scan.next();
		System.out.println(">>>>>> Please enter Car Number <<<<<<");
		carNo = scan.next();
		System.out.println(">>>>>> Please enter date in format (dd-mm-yyyy) <<<<<< \n");
		String providedDate = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = dateFormat.parse(providedDate);
	}
	
	public boolean isAvailable(ArrayList<CarBooking> reservations , ArrayList<Car> cars) {
		int availableSeat = 0 ;
		for(Car car : cars) {
			if(car.getCarNo().equals(carNo)) {
				availableSeat = car.getSeat();
			}
		}
		int booked = 0;
		for(CarBooking res : reservations) {
			if(res.carNo.equals(carNo) && res.date.equals(date)) {
				booked ++;
			}
		}
		
		return booked < availableSeat ? true : false;
	}
	

}
