package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {return (args) -> {
		
		log.info("save a couple of books");
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("History"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Horror"));
		
		brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "345634-9", 20, crepository.findByName("History").get(0)));
		
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		
		log.info("fetch all books");
		for (Book book : brepository.findAll()) {
			log.info(book.toString());
		}
		
	};
	}

}
