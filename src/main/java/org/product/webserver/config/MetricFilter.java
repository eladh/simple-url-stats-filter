package org.product.webserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(1)
public class MetricFilter implements Filter {


	private final MetricServices metricServices;

	private static final Logger LOGGER = LoggerFactory.getLogger(MetricFilter.class);

	@Autowired
	public MetricFilter(MetricServices metricServices) {
		this.metricServices = metricServices;
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			metricServices.uriHit(((HttpServletRequest) servletRequest).getRequestURI());
		}catch (Exception e) {
			LOGGER.error("unable to process metric information");
		} finally {
			filterChain.doFilter(servletRequest ,servletResponse);
		}
	}

	@Override
	public void destroy() {

	}
}