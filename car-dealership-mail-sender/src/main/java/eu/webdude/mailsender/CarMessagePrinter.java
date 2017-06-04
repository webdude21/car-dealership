package eu.webdude.mailsender;

import eu.webdude.CarMessageDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class CarMessagePrinter {

	@JmsListener(destination = "car-queue")
	public void messageListener(Message<CarMessageDto> message) {
		System.out.println(message.getPayload().toString());
	}
}
