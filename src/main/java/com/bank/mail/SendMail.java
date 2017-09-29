package com.bank.mail;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

public class SendMail {
	public static void sendMail(final String username, final String password,
			String htmlBody, Map<String, String> mapInlineImages) {
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
	        message.setSentDate(new Date());

	        // creates message part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent(htmlBody, "text/html");
	 
	        // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        
	        // adds inline image attachments
	        if (mapInlineImages != null && mapInlineImages.size() > 0) {
	            Set<String> setImageID = mapInlineImages.keySet();
	             
	            for (String contentId : setImageID) {
	                MimeBodyPart imagePart = new MimeBodyPart();
	                imagePart.setHeader("Content-ID", "<" + contentId + ">");
	                imagePart.setDisposition(MimeBodyPart.INLINE);
	                 
	                String imageFilePath = mapInlineImages.get(contentId);
	                try {
	                    imagePart.attachFile(imageFilePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(imagePart);
	            }
	        }
			
			// TODO: Change body of message to link that contains a form
			//message.setText("Please follow this link: " + "http://wikipedia.org");
	        
	        message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
