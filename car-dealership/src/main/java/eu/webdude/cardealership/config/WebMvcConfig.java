package eu.webdude.cardealership.config;

import eu.webdude.cardealership.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private final LoggingInterceptor yourInjectedInterceptor;

	@Autowired
	public WebMvcConfig (LoggingInterceptor yourInjectedInterceptor){
		this.yourInjectedInterceptor = yourInjectedInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(yourInjectedInterceptor);
	}
}