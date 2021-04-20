package petfind.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("petfind")
public class PetFindApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetFindApplication.class, args);
    }

}
