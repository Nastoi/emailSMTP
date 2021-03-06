package emailSMTP;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SuccessEmail {


	    public static void main(String[] args) {

	    	public void send(String a, String b, String c) {   

	            Properties prop = new Properties();
	    		prop.put("mail.smtp.host", "smtp.gmail.com");
	            prop.put("mail.smtp.port", "587");
	            prop.put("mail.smtp.auth", "true");
	            prop.put("mail.smtp.starttls.enable", "true"); //TLS
	            
	            Session session = Session.getInstance(prop,
	                    new javax.mail.Authenticator() {
	                        protected PasswordAuthentication getPasswordAuthentication() {
	                            return new PasswordAuthentication(a, b);//username, password
	                        }
	                    });

	            try {

	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress(a));//my email
	                message.setRecipients(
	                        Message.RecipientType.TO,
	                        InternetAddress.parse(c)//your email
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
