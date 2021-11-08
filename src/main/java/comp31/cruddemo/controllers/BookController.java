package comp31.cruddemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.cruddemo.services.BookService;


@Controller
public class BookController {
    
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    Logger logger = LoggerFactory.getLogger(BookController.class);
    
    //Creates get mapping for index.html for localhost:8080/index
    @GetMapping("/")
    public String getIndex()
    {
            return "index";
    }

    //Creates get mapping for books.html for localhost:8080/books
    @GetMapping("/books")
    public String getBooks(
        //Requesting a matching parameter for the html matching firstName and lastName to the column
        @RequestParam(required=false) String firstName, 
        @RequestParam(required=false) String lastName, 
        Model model)
    {
        //Boolean that checks if author name is invalid 
        //if the first name is null or empty or the last name is null or empty
        //has to be null OR empty, because as long as it's not null you can test to see if it's empty
        //otherwise isEmpty can throw errors
        //If the authorname is invalid add a list of books
        //otherwise log the valid author name and list their respective books
        boolean authorNameInvalid = 
            firstName == null || firstName.isEmpty() || 
            lastName  == null || lastName.isEmpty();
        
        if (authorNameInvalid)
        {   model.addAttribute("books", bookService.findBooks());
        }
        else
        {   logger.info("Author Name: ", firstName + " " + lastName);
            model.addAttribute("books", bookService.findBooksByAuthor(firstName,lastName));
        }
        return "books";
    }
    //GetMapping function to navigate to the authors.html it gets the author model and populates the page data with a list of authors
    @GetMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors" , bookService.findAuthors());
        return "authors";
    }

}
