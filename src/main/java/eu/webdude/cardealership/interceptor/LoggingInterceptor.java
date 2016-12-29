package eu.webdude.cardealership.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
class LoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
		log.info(String.format("Resource at %s%s requested by %s", req.getServletPath(), getOptionalParams(req), req.getRemoteHost()));
	}

	private String getOptionalParams(HttpServletRequest req) {
		String queryParams = req.getQueryString();
		return queryParams != null ? "?" + queryParams : "";
	}
}
