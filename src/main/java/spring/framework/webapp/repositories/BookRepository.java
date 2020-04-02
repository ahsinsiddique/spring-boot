package spring.framework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
