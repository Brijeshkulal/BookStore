package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService{

    @Autowired
    BookRepository bookStoreRepository;

    @Autowired
    UserRegistrationRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        BookModel addDetails = modelMapper.map(bookDTO, BookModel.class);
        bookStoreRepository.save(addDetails);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getBook() {
        return bookStoreRepository.findAll().stream().map(book -> {
            return new BookDTO(book.getBookId(), book.getBookDetails(), book.getAuthorName(), book.getBookName(),
                    book.getPrice(), book.getNoOfBooks() ,book.getImage(),book.getBookQuantity(),book.getBookRating() );
        }).collect(Collectors.toList());
    }
}
