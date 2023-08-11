package com.sim.javamodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JavaModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaModuleApplication.class, args);
    }

}
