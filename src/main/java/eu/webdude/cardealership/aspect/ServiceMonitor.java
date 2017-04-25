package eu.webdude.cardealership.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class ServiceMonitor {

	private static final Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

	@AfterReturning("execution(* eu.webdude.cardealership.service..*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		log.info(String.format("Service method: %s called.", joinPoint.getSignature().toShortString()));
	}
}