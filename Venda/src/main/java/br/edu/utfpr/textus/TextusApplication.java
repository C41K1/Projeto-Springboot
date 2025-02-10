package br.edu.utfpr.textus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.edu.utfpr.textus.services")
public class TextusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextusApplication.class, args);
	}

}
