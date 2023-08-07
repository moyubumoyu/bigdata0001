package kaoshi.service;

import kaoshi.entity.Book;

public interface BookService {
    void addBook(Book book);
    void selectBook(int id);
    void deleteBook(int id);
    void modifyBook(int id);
    void selectAll();
}
