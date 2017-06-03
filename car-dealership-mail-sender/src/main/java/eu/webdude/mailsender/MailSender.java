package eu.webdude.mailsender;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

	@JmsListener(destination = "message-queue")
	public void messageListener(Message<String> message) {
		System.out.printf("Message was sent with the following content: %n %s%n", message.getPayload());
	}
}
