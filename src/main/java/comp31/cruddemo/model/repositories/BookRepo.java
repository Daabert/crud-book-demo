package comp31.cruddemo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long>{
    //Query findByAuthor searches for author 
    List<Book> findByAuthor(Author author);
    //Query findByYear Searches for the year of the book
    List<Book> findByYear(String year);
    //Query findByTitle searches the book by title
    List<Book> findByTitle(String title);
}
