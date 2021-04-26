package com.SAD.Main_Project;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.SAD.Main_Project.model.Gender;
import com.SAD.Main_Project.model.Role;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.repo.ProductRepo;
import com.SAD.Main_Project.repo.RoleRepo;
import com.SAD.Main_Project.model.User;
import com.SAD.Main_Project.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MainProjectApplication {

	@Autowired
	public RoleRepo roleRepo;
	
	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(MainProjectApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(RoleRepo roleRepo) {
		return args -> roleRepo.saveAll(Arrays.asList(Role.builder().id(1).name("ROLE_USER").build(),
				Role.builder().id(2).name("ROLE_ADMIN").build()));
	}
	
	@Component
	public class DbInit{
		@PostConstruct
	    private void postConstruct() {
			Role role = new Role(1,"ROLE_USER",null);
			roleRepo.save(role);
			byte[] pic = new byte[10];
			User user = new User(1,"Default User",Gender.Male,"defaultUser@mailinator.com","$2y$12$2LA4/IzwsfoF.SFtdxwJIus48N6JwFzTdMwlrc9lXRHnA9EOBU7AS",null, true, role, null, null, null);
			Product product  =new Product(1, "iPhone 11 pro", 12000, "This is an apple product", pic,LocalDateTime.now(), null, LocalDateTime.now(), null, user, null);
			try {
			userRepo.save(user);
			productRepo.save(product);
			}
			catch(Exception e) {
				System.out.print("Already initialized");
			}			
	    }
	}
}
