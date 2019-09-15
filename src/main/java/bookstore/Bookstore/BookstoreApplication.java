package bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {

			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 1998, "9789513111465", 13));
			repository.save(new Book("Harry Potter ja Feeniksin kilta", "J.K. Rowling", 2003, "9788498383621", 14));

		};

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
