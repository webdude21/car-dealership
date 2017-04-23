package eu.webdude.cardealership.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter implements AsyncHandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("preHandleTime", System.currentTimeMillis());
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		request.setAttribute("postHandleTime", System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		log.info(String.format("Action %s took %s", handlerMethod.getMethod().getName(), this.calculateTimeForCompletion(req)));
	}

	private String calculateTimeForCompletion(HttpServletRequest req) {
		if (req.getAttribute("preHandleTime") == null || req.getAttribute("postHandleTime") == null) {
			return "didn't complete!";
		}

		long timeToHandle = (long) req.getAttribute("postHandleTime") - (long) req.getAttribute("preHandleTime");

		return String.format("%d ms to complete!", timeToHandle);
	}

	private String getOptionalParams(HttpServletRequest req) {
		String queryParams = req.getQueryString();
		return queryParams != null ? "?" + queryParams : "";
	}
}
