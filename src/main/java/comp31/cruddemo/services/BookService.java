package comp31.cruddemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;
import comp31.cruddemo.model.repositories.AuthorRepo;
import comp31.cruddemo.model.repositories.BookRepo;

@Service
public class BookService {
    
    // New objects for the bookrepo and authorrepo
    BookRepo bookRepo;
    AuthorRepo authorRepo;
    
    //Constructor for BookService populating the new object at index position
    @Autowired
    public BookService (BookRepo bookRepo, AuthorRepo authorRepo) {
        super();
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    /*
    * public Iterable<Author> findAuthors()
    * This funtion is using the Author list
    * It is returning the list of all authors in reference to the repo
    */
    public Iterable<Author> findAuthors()
    {
        return authorRepo.findAll();
    }



    /*
    * public Iterable<Book> findBooks()
    * This funtion is using the Book list
    * It is returning the list of all books in reference to the repo
    */
    public Iterable<Book> findBooks()
    {
        return bookRepo.findAll();
    }

    /*
    * public Iterable<Book> findBooksByAuthor(String firstName, String lastName)
    * Creates a new object of type array list called bookList
    * Then creates an object of list of authors, it uses the author repo to 
    * call the entity function findByFirstAndLastName
    * If the arraylist of author is empty populate author object with an array at index 0
    * then populate the book list with the author.getbooks function pulling the books at 
    * author index 0
    * then return the booklist
    */
    public Iterable<Book> findBooksByAuthor(String firstName, String lastName)
    {        
        List <Book> bookList = new ArrayList<>();
        List<Author> authorList = authorRepo.findByFirstNameAndLastName(firstName,lastName);
        if (!authorList.isEmpty())
        {
            Author author = authorList.get(0);
            bookList = author.getBooks();            
        }
        return bookList;
    }

}
