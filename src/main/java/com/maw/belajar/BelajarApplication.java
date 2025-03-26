package com.maw.belajar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BelajarApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(BelajarApplication.class, args);
                System.out.println("Server is running");
	}
        
        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
}
