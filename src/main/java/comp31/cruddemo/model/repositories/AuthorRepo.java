package comp31.cruddemo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Long> {
    //Query findByLastName searches the database for author by their name
    List<Author> findByLastName(String lastName);
    //Query findByFirstNameAndLastName combines both first and lastname objects to search
    //the db by the authors first name and last name
    List<Author> findByFirstNameAndLastName(String firstName,String lastName);
    //Query findByAuthorId searches the db based on author id 
    List<Author> findByAuthorId(Integer authorId);
}
