package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "springboot" }) // same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class N26Application {

	public static void main(String[] args) {
		SpringApplication.run(N26Application.class, args);
	}
}
