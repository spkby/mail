

/*
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Sender {

	private String message_recip, message_cc1, message_cc2, message_cc3, stmp_host, message_from;
	public String message_subject, message_body;
//	protected Session session;
//	protected Message mesg;

	public Sender() {
		fill();
	}

	private void fill(){

		Properties properties = new Properties();
		try {
			properties.load(new FileReader("mail.properties"));

			message_recip = properties.getProperty("recip");
			message_subject = "";
			message_cc1 = properties.getProperty("cc1");
			message_cc2 = properties.getProperty("cc2");
			message_cc3 = properties.getProperty("cc3");
			message_body = "";

			stmp_host = properties.getProperty("stmp_host");
			message_from = properties.getProperty("from");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doSend() {
		Properties props = new Properties();
		props.put("mail.smtp.host", stmp_host);

		/*
		session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		try {
			mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(message_from));
			InternetAddress toAddress = new InternetAddress(message_recip);
			mesg.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);
			InternetAddress ccAddress1 = new InternetAddress(message_cc1);
			mesg.addRecipient(javax.mail.Message.RecipientType.CC, ccAddress1);
			InternetAddress ccAddress2 = new InternetAddress(message_cc2);
			mesg.addRecipient(javax.mail.Message.RecipientType.CC, ccAddress2);
			InternetAddress ccAddress3 = new InternetAddress(message_cc3);
			mesg.addRecipient(javax.mail.Message.RecipientType.CC, ccAddress3);
			mesg.setSubject(message_subject);
			mesg.setText(message_body);
			Transport.send(mesg);
		}
		catch(MessagingException ex) {
			while((ex = (MessagingException)ex.getNextException()) != null)  {
				ex.printStackTrace();
			}
		}
		*/
	}
}
