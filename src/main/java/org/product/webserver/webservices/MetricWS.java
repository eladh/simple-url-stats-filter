package org.product.webserver.webservices;

import org.product.webserver.config.MetricServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 */

@RestController
@RequestMapping("/metric/")
public class MetricWS {

	private final MetricServices metricServices;

	@Autowired
	public MetricWS(MetricServices metricServices) {
		this.metricServices = metricServices;
	}

	@RequestMapping(value = "/stats/{url}", method = GET)
	public Integer getUrlData(@PathVariable("url") String url){
		return metricServices.getUriStat(url);
	}

}