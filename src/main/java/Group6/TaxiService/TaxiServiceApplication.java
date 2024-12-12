package Group6.TaxiService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = { "Group6.TaxiService.*" })
public class TaxiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiServiceApplication.class, args);
	}

}
