package com.EMPLOYEEAUTH.Implimantation;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EMPLOYEEAUTH.Repository.AUTH_REPO;

@Component
public class Email_Implimentation {
	
	@Autowired
	private AUTH_REPO crepo;
	
	public Boolean sendEmail(String message, String subject, String to) throws MessagingException {
		
		
		Boolean flag = false;
		//Variable for gmail
		String host="smtp.gmail.com";
		String from = "dhaval.ajmera123456@gmail.com";
		
//		to =to.trim();
		
		
		//get the system properties
		Properties properties = System.getProperties();
		System.err.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		System.err.println("2222222222222");
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		System.err.println("3333333333");
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("dhaval.ajmera123456@gmail.com", "duke dhjn xeqr hztb");
			}
			
			
			
		});
		System.err.println("44444444444");
		session.setDebug(true);
		System.err.println("session---------->" + session);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
	
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		System.err.println("FLAG------>" + flag);
		return flag;
	}
/**************************************************************************************************************************/
	
	public Boolean sendPassword(String message, String subject, String to) throws MessagingException {
		
		
		Boolean flag = false;
		//Variable for gmail
		String host="smtp.gmail.com";
		String from = "dhaval.ajmera123456@gmail.com";
		
//		to =to.trim();
		
		
		//get the system properties
		Properties properties = System.getProperties();
		System.err.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		System.err.println("2222222222222");
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		System.err.println("3333333333");
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("dhaval.ajmera123456@gmail.com", "duke dhjn xeqr hztb");
			}
			
			
			
		});
		System.err.println("44444444444");
		session.setDebug(true);
		System.err.println("session---------->" + session);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
	
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		System.err.println("FLAG------>" + flag);
		return flag;
	}

}
