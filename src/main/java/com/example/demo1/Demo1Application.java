package com.example.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo1Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext context){
        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Bean 详细情况--------------------");
                var beanNames = context.getBeanDefinitionNames();
                Arrays.sort(beanNames);

                Arrays.stream(beanNames).peek( x -> System.out.println(x));
            }
        };
    }
}
