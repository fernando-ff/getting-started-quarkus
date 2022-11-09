package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, "IT"),
                new Book(2, "Understanding Quarkus 2", "Antonio", 2020, "IT")
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }


    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream()
                .filter(book -> book.id == id).findFirst();
    }
}
