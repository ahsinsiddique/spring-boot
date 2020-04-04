package spring.framework.webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.framework.webapp.model.Author;
import spring.framework.webapp.model.Book;
import spring.framework.webapp.model.Publisher;
import spring.framework.webapp.repositories.AuthorRepository;
import spring.framework.webapp.repositories.BookRepository;
import spring.framework.webapp.repositories.PublisherRepository;

@Component  // for java bean
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("Napo");
        publisherRepository.save(publisher);

        Author ahsan = new Author("Ahsan");
        Book book = new Book("Spring boot", "isbn324243", publisher);

        ahsan.getBooks().add(book);
        book.getAuthors().add(ahsan);

        authorRepository.save(ahsan);
        bookRepository.save(book);

        ///////////////

        Author atif = new Author("Atif");
        Book book2 = new Book("Grails", "isbn09999", publisher);

        atif.getBooks().add(book2);
        book2.getAuthors().add(atif);

        authorRepository.save(atif);
        bookRepository.save(book2);
    }
}
