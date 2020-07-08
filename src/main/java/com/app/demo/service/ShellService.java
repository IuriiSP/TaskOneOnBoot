package com.app.demo.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellService {
    private final UserService userService;

    public ShellService(UserService userService) {
        this.userService = userService;
    }

    @ShellMethod(key = "start", value = "начать тестирование")
    public void start(){
        userService.startTest();
    }
}
