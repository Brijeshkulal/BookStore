package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.exception.UserRegistrationException;
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
        List<BookDTO> bookDetails = bookStoreRepository.findAll().stream().map
                        (book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
        if(bookDetails.isEmpty()){
            throw new UserRegistrationException(400,"Book list data is empty");
        }
        return bookDetails;
    }


    @Override
    public BookDTO getBookByID(int id) {

        BookModel book = bookStoreRepository.findById(id).
                orElseThrow(() -> new UserRegistrationException(400,"Unable to find any Book detail!"));
        BookDTO bookDetails = modelMapper.map(book, BookDTO.class);
        return bookDetails;
    }
}
