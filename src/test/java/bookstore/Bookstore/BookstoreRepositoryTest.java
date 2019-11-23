package bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstore.Bookstore.domain.Book;
import bookstore.Bookstore.domain.BookRepository;
import bookstore.Bookstore.domain.Category;
import bookstore.Bookstore.domain.CategoryRepository;
import bookstore.Bookstore.domain.User;
import bookstore.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Autowired
	private UserRepository urepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Harry Potter ja viisasten kivi");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Harry Potter ja Feeniksin kilta", "J.K. Rowling", 1998, "9789513131280", 20,
				new Category("Rikoskirjallisuus"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();

	}

	@Test
	public void deleteBook() {
		Book book = new Book("Harry Potter ja Feeniksin kilta", "J.K. Rowling", 1998, "9789513131280", 20,
				new Category("Rikoskirjallisuus"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		Long bookId = book.getId();
		repository.deleteById(bookId);

	}

	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Romaani");

		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Dekkari");
		crepository.save(category);
	}

	@Test
	public void deleteCategory() {
		Category category = new Category("Dekkari");
		crepository.save(category);
		crepository.delete(category);

	}

	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepository.findByUsername("admin");

	}

	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$10$nuHc9JW7ceOOOcR/b9i/hu/5ZHteDAS13pDb.j.7EIIPCrpjRB1P2", "user@gmail.com",
				"USER");
		urepository.save(user);
	}

	@Test
	public void deleteUser() {
		User user2 = new User("user3", "$2a$10$nuHc9JW7ceOOOcR/b9i/hu/5ZHteDAS13pDb.j.7EIIPCrpjRB1P2", "user@gmail.com",
				"USER");
		urepository.save(user2);
		assertThat(user2.getId()).isNotNull();
		Long userId = user2.getId();
		urepository.deleteById(userId);

	}
}