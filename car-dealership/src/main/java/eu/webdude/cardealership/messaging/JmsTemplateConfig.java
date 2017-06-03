package eu.webdude.cardealership.messaging;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.inject.Inject;

@Configuration
public class JmsTemplateConfig {

	public static final String QUEUE = "message-queue";

	@Inject
	private ActiveMQConnectionFactory connectionFactory;

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory);
		connectionFactory.setTrustAllPackages(true);
		template.setDefaultDestinationName(QUEUE);
		return template;
	}
}
