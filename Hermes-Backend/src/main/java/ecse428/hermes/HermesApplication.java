package ecse428.hermes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HermesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HermesApplication.class, args);
	}
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}

}
