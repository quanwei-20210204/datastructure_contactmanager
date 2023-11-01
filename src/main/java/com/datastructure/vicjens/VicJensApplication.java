package com.datastructure.vicjens;

import com.datastructure.vicjens.command.Commands;
import com.datastructure.vicjens.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;
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


		Instant starts = Instant.now();
		boolean quitSeen = false;
		String say = contactService.say();
		System.out.println(say);

		Scanner scanner = new Scanner(System.in);
		String input;


		while (!quitSeen) {
			System.out.print("> ");
			input = scanner.nextLine();

			Commands command = Commands.valueOf(input.toUpperCase());

			switch (command){
				case QUIT:
					quitSeen = true;
					evaluate(input);
					break;
				default:
					evaluate(input);
			}
		}

		scanner.close();
//
		Instant ends = Instant.now();

		System.out.println("cmpleted after: "+Duration.between(starts, ends));
	}

	public static void evaluate(String input) {
		// 在这里执行输入命令的逻辑
		System.out.println("run the command: " + input);
	}

}
