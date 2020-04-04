package spring.framework.webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.framework.webapp.model.Author;
import spring.framework.webapp.model.Book;
import spring.framework.webapp.repositories.AuthorRepository;
import spring.framework.webapp.repositories.BookRepository;

@Component  // for java bean
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public  void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    this.initData();
    }

    private void initData() {
        Author ahsan = new Author("Ahsan");
        Book book = new Book("Spring boot", "isbn324243", "Saddique");

        ahsan.getBooks().add(book);
        book.getAuthors().add(ahsan);

        authorRepository.save(ahsan);
        bookRepository.save(book);

        ///////////////

        Author atif = new Author("Atif");
        Book book2 = new Book("Grails", "isbn09999", "Napo");

        atif.getBooks().add(book2);
        book2.getAuthors().add(atif);

        authorRepository.save(atif);
        bookRepository.save(book2);
    }
}
