package com.devsuperior.uri2609;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n\n------ SQL NATIVE  -----------");
		List<CategorySumDTO> resultSQL = repository.search1()
				.stream().map(x -> new CategorySumDTO(x)).toList();
		
		for (CategorySumDTO dtoSQL : resultSQL) {
			System.out.println(dtoSQL);
		}
		
		System.out.println("\n--------------------------------------\n");
		
		System.out.println("\n\n------ JPQL  -----------");
		List<CategorySumDTO> resultJPQL = repository.search2();
		
		for (CategorySumDTO dtoJPQL : resultJPQL) {
			System.out.println(dtoJPQL);
		}
		
		System.out.println("\n--------------------------------------\n");
		
	}
}
