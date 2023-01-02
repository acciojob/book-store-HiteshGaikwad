package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> bookList;
    private int id;


    public BookRepository() {
        this.bookList = new ArrayList<Book>();
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    // save book to the database
    public Book save(Book book){
        book.setId(id);
        getBookList().add(id,book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        //check if index is valid or not
        if(getBookList().size()>id) {
            return getBookList().get(id);
        }
        return null;
    }

    public List<Book> findAll(){
        return getBookList();
    }

    public void deleteBookById(int id){
        getBookList().remove(id);
    }

    public void deleteAll(){
        getBookList().clear();
    }

    public List<Book> findBooksByAuthor(String author){
       List<Book> list=new ArrayList<>();
       for(Book book: getBookList()){
           if(book.getAuthor().equals(author)){
               list.add(book);
           }
       }
       return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list=new ArrayList<>();
        for(Book book: getBookList()){
            if(book.getGenre().equals(genre)){
                list.add(book);
            }
        }
        return list;
    }
}
