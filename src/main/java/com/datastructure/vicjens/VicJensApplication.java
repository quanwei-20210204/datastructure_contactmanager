package com.datastructure.vicjens;

import com.datastructure.vicjens.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

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

		Scanner scanner = new Scanner(System.in);
		String input;



		while (true) {
			System.out.print("> ");
			input = scanner.nextLine();

			if (input.equals("QUIT")) {
				break;
			}

			evaluate(input);
		}

		scanner.close();



	}

	public static void evaluate(String input) {
		// 在这里执行输入命令的逻辑
		System.out.println("执行命令: " + input);
	}
}
