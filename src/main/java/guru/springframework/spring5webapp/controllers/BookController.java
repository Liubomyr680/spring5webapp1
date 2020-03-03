package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")                                   // It's going to execute the getBooks method,
    public String getBooks(Model model){                        // and we are using the repository to get a list of books out of the database.

        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }
}
