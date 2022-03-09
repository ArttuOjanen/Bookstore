package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {return (args) -> {
		
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("History"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Horror"));
		
		brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "345634-9", 20, crepository.findByName("History").get(0)));
		
		
	};
	}

}
