package com.maz.eventpp.eventapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maz.eventpp.eventapp.domain.User;
import com.maz.eventpp.eventapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class EventappApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventappApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
            // read JSON and load json
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
            try {
                List<User> users = mapper.readValue(inputStream,typeReference);
                userService.save(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

}
