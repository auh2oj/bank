package com.bank.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void sendMail(final String username, final String password) {
//		final String username = "synergisticitsessionusc6@gmail.com";
//		final String password = "session6";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("synergisticitsessionusc6@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("synergisticitsessionusc6@gmail.com"));
			message.setSubject("Testing Subject");
			// TODO: Change body of message to link that contains a form
			message.setText("Please follow this link: " + "http://wikipedia.org");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
