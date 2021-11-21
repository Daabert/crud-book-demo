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
    public Iterable<Book> findBooksByYear(String year)
    {
        List <Book> bookList = bookRepo.findByYear(year);
        return bookList;
    }

    //Author Queries
    public Iterable<Author> findAuthorByInitial(String lastName)
    {
        List <Author> authorList = authorRepo.findByLastNameStartingWith(lastName);
        return authorList;
    }
    public Iterable<Author> findAuthorBySequence(String lastName, String keyword)
    {
        List <Author> authorList = authorRepo.findByLastNameStartingWithAndLastNameContaining(lastName, keyword);
        return authorList;
    }
    
    //Book Queries
    public Iterable<Book> findBookByPriceAndOrder(String year)
    {
        List <Book> bookList = bookRepo.findByYearOrderByPriceAsc(year);
        return bookList;
    }

    public Iterable<Book> findBookByTwoTitleWords(String title, String keyword)
    {
        List <Book> bookList = bookRepo.findByTitleContainingAndTitleContaining(title, keyword);
        return bookList;
    }

    public Iterable<Book> findBookByTitleNot(String title)
    {
        List <Book> bookList = bookRepo.findByTitleNotContaining(title);
        return bookList;
    }
   
    public Iterable<Book> findBookByTitleContainAndNot(String title, String keyword)
    {
        List <Book> bookList = bookRepo.findByTitleContainingAndTitleNotContaining(title, keyword);
        return bookList;
    }
    

}
