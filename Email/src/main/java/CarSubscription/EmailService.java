package CarSubscription;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService{
	
	public static void triggerEmail(String mailId) {
		String to= mailId;
		
		String from="sarobioinfo@gmail.com";
		
		String host="8080";
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.transport.protocol", "smtp");
		final String username = "sarobioinfo@gmail.com";
		final String password = "qvbkhxmtlbxhheyk";
	    
	    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username,password);

            }

        });
		
		try {
			 MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(from));
			 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			 message.setSubject("Car Booked successfully!");
			// message.setText("This is actual message");
			 
			 // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("Car Booking Details");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "C:/sample/addingParagraph.pdf";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);
			 
			 
			 Transport.send(message);
	         System.out.println("Happy and Safe Journey");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
