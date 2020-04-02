package spring.framework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
