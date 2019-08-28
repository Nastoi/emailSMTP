package emailSMTP;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SuccessEmail {


	    public static void main(String[] args) {

	    	public void send(String emailFrom, String password, String emailToSendTo) {   

	            Properties prop = new Properties();
	    		prop.put("mail.smtp.host", "smtp.gmail.com");
	            prop.put("mail.smtp.port", "587");
	            prop.put("mail.smtp.auth", "true");
	            prop.put("mail.smtp.starttls.enable", "true"); //TLS
	            
	            Session session = Session.getInstance(prop,
	                    new javax.mail.Authenticator() {
	                        protected PasswordAuthentication getPasswordAuthentication() {
	                            return new PasswordAuthentication(a, b);//your email, password
	                        }
	                    });

	            try {

	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress(emailFrom));//email to send from
	                message.setRecipients(
	                        Message.RecipientType.TO,
	                        InternetAddress.parse(emailToSendTo)//email to send to
	                );
	                message.setSubject("Testing Gmail TLS");
	                message.setText("Dear" + c
	                        + "\n\n Thank you for registering with ABC job portal.!"
	                		+ "\n We are delighted to have you with us and hope to provide the services"
	                        + "\n needed in the website."
	                		+ "\n\n Regards"
	                        + "\n ABC job portal team");

	                Transport.send(message);

	                System.out.println("Done");

	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	        }

	}

}
