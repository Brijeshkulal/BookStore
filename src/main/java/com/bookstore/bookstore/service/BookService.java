package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.exception.UserRegistrationException;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
                    book.getPrice(), book.getNoOfBooks() ,book.getImage() );
        }).collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(int id, BookDTO bookDTO) {
        BookDTO bookResponse = null;
        if (id > 0) {
            BookModel bookDetails = findBookById(id);
            String[] ignoreFields = {"id"};
            BeanUtils.copyProperties(bookDTO, bookDetails, ignoreFields);
            bookStoreRepository.save(bookDetails);
            bookResponse = modelMapper.map(bookDetails, BookDTO.class);
        }
        return bookResponse;
    }

    public BookModel findBookById(int id) {
        return bookStoreRepository.findById(id)
                .orElseThrow(() -> new UserRegistrationException(400,"Unable to find any Book detail!"));
    }


    @Override
    public void deleteBook(int id) {
        if (id > 0) {
            BookModel contact = findBookById(id);
            bookStoreRepository.delete(contact);
        }
    }

    @Override
    public BookDTO getBookByID(int id) {
        BookModel book = findBookById(id);
        BookDTO contactResponse = modelMapper.map(book, BookDTO.class);
        return contactResponse;
    }
}
