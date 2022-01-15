package com.example.java_thymeleaf.controller;

import com.example.java_thymeleaf.dto.User;
import com.example.java_thymeleaf.dto.UserStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
public class IndexController {

    private final Random random = new Random();
    //http:localhost:8080/
    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("myTestKey", "Hello world");
        model.addAttribute("myTestInt", 937);
        model.addAttribute("myTestBool", random.nextBoolean());
        model.addAttribute("myTestObject", new User("Vasya", 30, UserStatus.DEAD));
        model.addAttribute("currentTime", System.currentTimeMillis());

        List<User> users = new ArrayList<>();
        users.add(new User("Oleg", 54, UserStatus.OFFLINE));
        users.add(new User("Vanya", 23, UserStatus.DEAD));
        users.add(new User("Nikitus", 41, UserStatus.ONLINE));
        users.add(new User("Nazariy", 12, UserStatus.OFFLINE));
        model.addAttribute("users", users);



        return "index";
    }

    //http:localhost:8080/data
    @GetMapping("/data")
    public String dataPage() {
        return "data/data";
    }
}
