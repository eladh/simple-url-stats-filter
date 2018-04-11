package org.product.webserver.config;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MetricServices {

	private Map<String,AtomicInteger> stats = new ConcurrentHashMap<>(1000);


	void uriHit(String uri) {
		AtomicInteger uriHits = stats.get(uri);
		if (uriHits != null) {
			uriHits.incrementAndGet();
			return;
		}
		AtomicInteger newUriRecord = stats.putIfAbsent(uri , new AtomicInteger(1));
		if (newUriRecord != null) {
			stats.get(uri).incrementAndGet();
		}
	}

	public Integer getUriStat(String uri) {
		AtomicInteger uriHits = stats.get(uri);
		return uriHits != null ? uriHits.get() : 0;
	}


}