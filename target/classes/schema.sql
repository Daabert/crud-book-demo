DROP TABLE IF EXISTS BOOK;

DROP TABLE IF EXISTS AUTHOR;


CREATE TABLE AUTHOR
(
  AUTHOR_ID INT PRIMARY KEY AUTO_INCREMENT,
  FIRST_NAME VARCHAR(32),
  LAST_NAME  VARCHAR(64)

);


CREATE TABLE BOOK(
  BOOK_ID  BIGINT PRIMARY KEY AUTO_INCREMENT,
  BOOK_TITLE VARCHAR(256),
  BOOK_YEAR VARCHAR(4), 
  AUTHOR_ID INT,
  BOOK_PRICE VARCHAR(20),
  FOREIGN KEY(AUTHOR_ID) REFERENCES AUTHOR(AUTHOR_ID)
);


