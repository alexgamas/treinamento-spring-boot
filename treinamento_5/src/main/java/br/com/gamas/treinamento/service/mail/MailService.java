package br.com.gamas.treinamento.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	//@Async
	public void sendMail(String to, String subject, String msg){
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setText(msg);
		javaMailSender.send(smm);
	}
}
