package comp31.cruddemo.model.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;

    //One to many relationship with Author and their books.
    //One Author may have many books or a "list" of books.
    //Author references book
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author()
    {
        authorId = 0;
        firstName = "";
        lastName = "";
        books = null;
        
    }

}
