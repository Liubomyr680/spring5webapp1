package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BootStrapData implements CommandLineRunner {                       //this tell Spring to look for instances of this type, and run them.

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher brad = new Publisher("Brad","Ukraine");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);                                              //here we save our book, and author into H2 database.
        bookRepository.save(ddd);
        publisherRepository.save(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development","234234");
        Publisher john = new Publisher("John","USA");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);                                              //here we save our book, and author into H2 database.
        bookRepository.save(noEJB);
        publisherRepository.save(rod);

        System.out.println("Started in Bootstrap");
        System.out.println("Publisher: "+ john.getName() +" "+"Publisher: "+brad.getName());
        System.out.println("Number of books: "+ bookRepository.count());
    }
}
