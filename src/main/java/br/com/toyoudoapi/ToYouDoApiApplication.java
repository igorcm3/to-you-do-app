package br.com.toyoudoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ToYouDoApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ToYouDoApiApplication.class, args);
    }
}
