package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself

    //Create book
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody() Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    //Get book by Id
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
        Book book=bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    //Get all Books
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> list=bookService.findAllBooks();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //Delete Book by Id
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Successfully deleted.",HttpStatus.OK);
    }

    //Delete all books
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }

    //Find Books by Author name
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam("author") String author){
        List<Book> list=new ArrayList<>();
        list=bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //Find Books by Genre
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam("genre") String genre){
        List<Book> list=new ArrayList<>();
        list=bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }



}
