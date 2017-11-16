import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Sender {

	private String message_recip, stmp_host, message_from;
	private String[] cc;
	public String message_subject, message_body;
	protected Session session;
	protected Message mesg;

	public Sender() {
		fill();
	}

	private void fill(){

		Properties properties = new Properties();
		try {
			properties.load(new FileReader("mail.properties"));

			message_recip = properties.getProperty("recip");
			String tmp = properties.getProperty("cc");
			cc = tmp.split(",");
			stmp_host = properties.getProperty("stmp_host");
			message_from = properties.getProperty("from");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doSend() {
		Properties props = new Properties();
		props.put("mail.smtp.host", stmp_host);


		session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		try {
			mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(message_from));
			InternetAddress toAddress = new InternetAddress(message_recip);
			mesg.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);

			for (int i = 0; i < cc.length; i++) {
				InternetAddress address = new InternetAddress(cc[i]);
				mesg.addRecipient(javax.mail.Message.RecipientType.CC, address);
			}

			mesg.setSubject(message_subject);
			mesg.setText(message_body);


			Transport.send(mesg);
		}
		catch(MessagingException ex) {
			while((ex = (MessagingException)ex.getNextException()) != null)  {
				ex.printStackTrace();
			}
		}

	}
}
