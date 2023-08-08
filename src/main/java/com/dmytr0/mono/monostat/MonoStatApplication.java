package com.dmytr0.mono.monostat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MonoStatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonoStatApplication.class, args);
	}

}
