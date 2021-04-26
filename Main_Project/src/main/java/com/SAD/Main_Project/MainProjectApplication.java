package com.SAD.Main_Project;

import java.util.Arrays;

import com.SAD.Main_Project.model.Role;
import com.SAD.Main_Project.repo.RoleRepo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainProjectApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(RoleRepo roleRepo) {
		return args -> roleRepo.saveAll(
				Arrays.asList(
						Role.builder().id(1).name("ROLE_ADMIN").build(),
						Role.builder().id(2).name("ROLE_USER").build()
				)
		);
	}



}
