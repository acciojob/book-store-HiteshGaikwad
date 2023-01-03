package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

     List<Book> bookList;
    private int id;


    public BookRepository() {
        this.bookList = new ArrayList<Book>();
        this.id=1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }

    // save book to the database
    public Book save(Book book){
        book.setId(getId());
        bookList.add(book);
        setId(getId()+1);
        return book;
    }

    public Book findBookById(int id){
        //check if index is valid or not
//        if(bookList.size()>id) {
//            return bookList.get(id);
//        }else {
//            return null;
//        }
        for(Book num: bookList){
            if(num.getId()==id){
                return num;
            }
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
//        if(bookList.size()>id) {
//            bookList.remove(id);
//        }
        for(Book num : bookList){
            if(num.getId()==id){
                bookList.remove(num);
                return;
            }
        }
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor(String author){
       List<Book> list=new ArrayList<>();
       for(Book book: bookList){
           if(book.getAuthor().equals(author)){
               list.add(book);
           }
       }
       return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list=new ArrayList<>();
        for(Book book: bookList){
            if(book.getGenre().equals(genre)){
                list.add(book);
            }
        }
        return list;
    }
}
