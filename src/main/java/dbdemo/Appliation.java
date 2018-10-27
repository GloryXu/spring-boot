package dbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Appliation {
    @RequestMapping("/")
    String home() {
        return "Hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Appliation.class, args);
    }
}
