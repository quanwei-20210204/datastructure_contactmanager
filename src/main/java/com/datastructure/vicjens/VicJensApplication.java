package com.datastructure.vicjens;

import com.datastructure.vicjens.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VicJensApplication implements CommandLineRunner {

	@Autowired
	private ContactService contactService;

	public static void main(String[] args) {
		SpringApplication.run(VicJensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		String say = contactService.say();
		System.out.println(say);
	}
}
