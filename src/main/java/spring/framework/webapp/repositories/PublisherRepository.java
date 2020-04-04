package spring.framework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
