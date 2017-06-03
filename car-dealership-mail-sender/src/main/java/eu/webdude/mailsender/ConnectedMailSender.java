package eu.webdude.mailsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class ConnectedMailSender {
	private JavaMailSender javaMailSender;

	private static final Logger log = LoggerFactory.getLogger(ConnectedMailSender.class);

	@Value("${email.destination}")
	private String destination;

	@Value("${email.sender}")
	private String sender;

	@Autowired
	public ConnectedMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@JmsListener(destination = "message-queue")
	public void messageListener(org.springframework.messaging.Message<String> message) {
		try {
			sendEmail(message.getPayload());
			log.debug(String.format("Message was sent with the following content: %n %s%n", message.getPayload()));
		} catch (MessagingException e) {
			log.warn("Sending email failed");
			e.printStackTrace();
		}
	}

	private void sendEmail(String messageBody) throws MessagingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(destination);
		helper.setReplyTo(sender);
		helper.setFrom(sender);
		helper.setSubject("A car has been deleted");
		helper.setText(messageBody);
		javaMailSender.send(mail);
	}
}
