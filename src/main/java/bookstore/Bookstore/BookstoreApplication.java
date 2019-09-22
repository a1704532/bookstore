package bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;
import bookstore.Bookstore.domain.Category;
import bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Romaani"));
			crepository.save(new Category("Elämänkerrat"));
			
			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 1998, "9789513111465", 13, crepository.findByName("Romaani").get(0)));
			repository.save(new Book("Harry Potter ja Feeniksin kilta", "J.K. Rowling", 2003, "9788498383621", 14, crepository.findByName("Romaani").get(0)));

			
			
			
			
			/*
			 @Bean
	public CommandLineRunner studentDemo(StudentRepository srepository, DepartmentRepository drepository) {
		return (args) -> {
			log.info("save a couple of students");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Business"));
			drepository.save(new Department("Law"));
			
			srepository.save(new Student("John", "Johnson", "john@john.com", drepository.findByName("IT").get(0)));
			srepository.save(new Student("Katy", "Kateson", "kate@kate.com", drepository.findByName("Business").get(0)));	
			
			log.info("fetch all students");
			for (Student student : srepository.findAll()) {
				log.info(student.toString());
			}
			 */
		};

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
