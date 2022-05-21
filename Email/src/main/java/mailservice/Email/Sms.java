package mailservice.Email;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Sms {
  String mobile;
 
  public Sms(String mobile) {
	this.mobile = mobile;
  }
  public static final String ACCOUNT_SID = "AC4830c1e51c9e8f32c58af62e6c140230";
  public static final String AUTH_TOKEN = "c9a657862b0818093ac4f0f115c541b1";
  public void smsService() {
	  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      Message message = Message.creator(
    		  new com.twilio.type.PhoneNumber("+91" + this.mobile ),
              new com.twilio.type.PhoneNumber("+19896013579"),
              "Hi there...!")
          .create();

      System.out.println(message.getSid());
  }
}