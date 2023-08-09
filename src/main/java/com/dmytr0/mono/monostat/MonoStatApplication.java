package com.dmytr0.mono.monostat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.dmytr0.mono.monostat.repository")
public class MonoStatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonoStatApplication.class, args);
	}

}
