
INSERT INTO AUTHOR(AUTHOR_ID, FIRST_NAME, LAST_NAME)
    VALUES
    (     NULL, 'Craig','Wells'    ),
    (     NULL, 'Joshua','Bloch'   ),
    (     NULL, 'Alex','Antonov'   ),
    (     NULL, 'Joyce','Farrell'  ),
    (     NULL, 'Cay','Horstmann'  ), 
    (     NULL, 'Janet','Gregory'  ), 
    (     NULL, 'Greg','Turnquist' ),
    (     NULL, 'Walter','Savich'  ),
    (     NULL, 'John','Carnell'   );

INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_YEAR, AUTHOR_ID, BOOK_PRICE)
VALUES 
    (NULL, 'Spring Boot in Action', 2018, (SELECT Author_ID from author where last_name = 'Wells'), 10.99),
    (NULL, 'Core Java for the Impatient', 2018, (SELECT Author_ID from author where last_name = 'Horstmann'), 11.99),
    (NULL, 'Spring Microservices in Action', 2016, (SELECT Author_ID from author where last_name = 'Carnell'), 10.99),
    (NULL, 'Java Programming', 2018, (SELECT Author_ID from author where last_name = 'Farrell'), 11.99),
    (NULL, 'Beginning Java Databases', 2001, (SELECT Author_ID from author where last_name = 'Carnell'), 10.99),
    (NULL, 'Effective Java', 2017, (SELECT Author_ID from author where last_name = 'Bloch'), 11.99),
    (NULL, 'Spring Boot 2.0', 2017, (SELECT Author_ID from author where last_name = 'Antonov'), 10.99),
    (NULL, 'Spring Boot Cookbook', 2015, (SELECT Author_ID from author where last_name = 'Antonov'), 11.99),
    (NULL, 'Learning spring Boot 2.0', '2017', (SELECT Author_ID from author where last_name = 'Turnquist'), 10.99),
    (NULL, 'Absolute Java', '2015', (SELECT Author_ID from author where last_name = 'Savich'), 11.99),
    (NULL, 'Agile Testing', '2015', (SELECT Author_ID from author where last_name = 'Gregory'), 10.99),
    (NULL, 'Java: An Introduction to Problem Solving', '2017', (SELECT Author_ID from author where last_name = 'Savich'), 11.99);
