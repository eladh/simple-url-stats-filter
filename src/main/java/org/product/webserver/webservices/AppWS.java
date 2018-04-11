package org.product.webserver.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/app")
public class AppWS {

	@GetMapping("/")
	public String root(){
		return "ok";
	}
}