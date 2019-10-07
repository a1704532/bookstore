package bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;
import bookstore.Bookstore.domain.Category;
import bookstore.Bookstore.domain.CategoryRepository;
import bookstore.Bookstore.domain.User;
import bookstore.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {

			crepository.save(new Category("Romaani"));
			crepository.save(new Category("Elämänkerrat"));

			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 1998, "9789513111465", 13,
					crepository.findByName("Romaani").get(0)));
			repository.save(new Book("Harry Potter ja Feeniksin kilta", "J.K. Rowling", 2003, "9788498383621", 14,
					crepository.findByName("Romaani").get(0)));

			User user1 = new User("user", "$2a$10$nuHc9JW7ceOOOcR/b9i/hu/5ZHteDAS13pDb.j.7EIIPCrpjRB1P2",
					"user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$gmmjZHOL8X.0kCnpq/5sj.J0jLPo0SLoDAfFkwVClNmyCBGY6sWZ2",
					"admin@wippies.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}
}
