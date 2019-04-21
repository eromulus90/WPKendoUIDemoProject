package gov.wapa.kdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"gov.wapa"})
public class WpKendouiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WpKendouiDemoApplication.class, args);
	}

}
