package com.duoc.totem_food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Codigo en la cmd para encontrar el puerto ocupado
// netstat -ano | findstr :8080
// taskkill /PID 12345 /F
@SpringBootApplication
public class TotemfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotemfoodApplication.class, args);
	}

}
