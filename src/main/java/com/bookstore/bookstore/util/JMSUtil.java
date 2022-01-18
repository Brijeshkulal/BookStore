package com.bookstore.bookstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class JMSUtil {

	@Autowired
	private static JavaMailSender javaMailSender;


//	public static void sendEmail(String toEmail, String subject, String body) {
//
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//		mailMessage.setFrom("kumarbalingallogin@gmail.com");
//		mailMessage.setTo(toEmail);
//		mailMessage.setText(body);
//		mailMessage.setSubject(subject);
//
//		javaMailSender.send(mailMessage);
//		System.out.println("Mail Sent...");
//	}

	public static void sendEmail(String toEmail, String subject, String body) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    String emailid = System.getenv("kumarbalingallogin@gmail.com");
	    mailSender.setUsername(emailid);

	    String password = System.getenv("sxblxtxonciqgsof");
	    mailSender.setPassword(password);


		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("kumarbalingallogin@gmail.com");
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		System.out.println(mailMessage);
		javaMailSender.send(mailMessage);

//		Properties props = mailSender.getJavaMailProperties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//
//		Authenticator auth = new Authenticator()
//		{
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(emailid,password);
//			}
//		};
//		Session session = Session.getInstance(props,auth);
//		try
//		{
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(emailid);
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			message.setSubject(subject);
//			message.setText(body);
//			Transport.send(message);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("exception occured when sending the mail");
//		}
	}
}
