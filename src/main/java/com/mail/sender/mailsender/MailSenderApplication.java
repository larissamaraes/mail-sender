package com.mail.sender.mailsender;

import com.mail.sender.mailsender.message.MailMessage;
import com.mail.sender.mailsender.message.Mailer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MailSenderApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MailSenderApplication.class.getPackage().getName());
		Mailer mailer = applicationContext.getBean(Mailer.class);
		mailer.send(new MailMessage("Mail Sender <sendermail55@gmail.com>",
				Arrays.asList("Larissa Marães <larissa.maraes@gmail.com>", "Larissa Marães <larissa.maraes@outlook.com>",
						"Larissa Fernandes <larissa.maraes@aluno.ufms.br>"),
				"Mail Sender Test", "Hello!\nThe send has been completed successfully.\nBest regards :)"));

		applicationContext.close();
	}
}

