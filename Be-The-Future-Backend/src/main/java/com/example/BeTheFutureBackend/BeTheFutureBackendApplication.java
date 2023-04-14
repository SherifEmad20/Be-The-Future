package com.example.BeTheFutureBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BeTheFutureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeTheFutureBackendApplication.class, args);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveRole(new Role(null, "ROLE_EMPLOYEE"));
//            userService.saveRole(new Role(null, "ROLE_CUSTOMER"));
//            userService.saveRole(new Role(null, "ROLE_MANAGER"));
//
//            userService.saveUser(new User("sherif", "1234", "s@gmail.com", "sherif emad"
//                    , "011", "123 maadi", "giza", null, new ArrayList<>()));
//
//            userService.saveUser(new User("reda", "1234", "s@gmail.com", "sherif emad"
//                    , "011", "123 maadi", "giza", null, new ArrayList<>()));
//
//            userService.saveUser(new User("ebed", "1234", "s@gmail.com", "sherif emad"
//                    , "011", "123 maadi", "giza", null, new ArrayList<>()));
//
//            userService.saveUser(new User("hamdi", "1234", "s@gmail.com", "sherif emad"
//                    , "011", "123 maadi", "giza", null, new ArrayList<>()));
//
//
//            userService.addRoleToUser("sherif", "ROLE_ADMIN");
//            userService.addRoleToUser("reda", "ROLE_EMPLOYEE");
//            userService.addRoleToUser("ebed", "ROLE_CUSTOMER");
//            userService.addRoleToUser("hamdi", "ROLE_MANAGER");
//
//
//
//
//        };
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
