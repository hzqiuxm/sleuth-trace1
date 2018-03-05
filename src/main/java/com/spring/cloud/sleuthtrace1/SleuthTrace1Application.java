package com.spring.cloud.sleuthtrace1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthTrace1Application {

	private Logger logger = LoggerFactory.getLogger(SleuthTrace1Application.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){

		return new RestTemplate();
	}

	@GetMapping("/trace1")
	public String trace(){

		logger.info("========= call trace1 =========");

		return restTemplate().getForEntity("http://service-trace2/trace2",String.class).getBody();
	}

	public static void main(String[] args) {
		SpringApplication.run(SleuthTrace1Application.class, args);
	}


}
