package com.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.app.demo.service.IUserService;
import com.app.demo.service.UserService;

@SpringBootApplication

public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
    }
}
