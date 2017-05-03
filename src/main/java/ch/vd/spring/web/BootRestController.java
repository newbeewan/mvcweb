package ch.vd.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class BootRestController {

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String[] sayHello(){
        return new String[]{"Hello Spring Boot !"};
    }

    public static void main(String[] args){
        SpringApplication.run(BootRestController.class, args);
    }
}
