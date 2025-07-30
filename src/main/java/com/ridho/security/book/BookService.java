package com.ridho.security.book;
import java.util.List;

import org.springframework.stereotype.Service;

@Service

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookRequest bookRequest) {
        // Konversi BookRequest ke entitas Book
        Book book = new Book();
        book.setId(bookRequest.getId());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        
        // Simpan ke repository
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // public void save() {
    //     var book = Book.builder()
    //             .id(request.getId())
    //             .author(request.getAuthor())
    //             .isbn(request.getIsbn())
    //             .build();
    //     repository.save(book);
    // }

    // public List<Book> findAll() {
    //     return repository.findAll();
    // }
}
