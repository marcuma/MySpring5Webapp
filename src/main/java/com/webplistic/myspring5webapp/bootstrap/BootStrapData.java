package com.webplistic.myspring5webapp.bootstrap;

import com.webplistic.myspring5webapp.model.Author;
import com.webplistic.myspring5webapp.model.Book;
import com.webplistic.myspring5webapp.model.Publisher;
import com.webplistic.myspring5webapp.repositories.AuthorRepository;
import com.webplistic.myspring5webapp.repositories.BookRepository;
import com.webplistic.myspring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher me = new Publisher("Marcum Publishing", "9032 Polaris Lakes Dr",
                "Columbus", "Ohio", 43240);

        publisherRepository.save(me);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        ddd.setPublisher(me);
        me.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        authorRepository.save(eric);

        ddd.getAuthors().add(eric);
        bookRepository.save(ddd);

        publisherRepository.save(me);





        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        noEJB.setPublisher(me);
        me.getBooks().add(noEJB);

        rod.getBooks().add(noEJB);
        authorRepository.save(rod);

        noEJB.getAuthors().add(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(me);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of books: " + me.getBooks().size());


    }
}
