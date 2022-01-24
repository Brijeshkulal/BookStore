package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.dto.CartDTO;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.exception.UserRegistrationException;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.CartModel;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.CartRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRegistrationRepository userRepository;
    @Autowired
    BookRepository bookStoreRepository;

    @Autowired
    BookService  bookService;

    @Override
    public CartModel addToCart(CartDTO cartDTO) {
        Optional<UserRegistrationModel> user = userRepository.findById(cartDTO.getId());
        if(user.isPresent()) {
//            BookDTO book = bookService.getBookByID(cartDTO.getBookId());
            UserRegistrationModel user1 = userRepository.getById(cartDTO.getId());
            BookModel book = bookStoreRepository.getById(cartDTO.bookId);
            CartModel cart = new CartModel(user1,book,cartDTO.quantity);
            return cartRepository.save(cart);
        }
        return null;
    }



//    @Override
//    public CartDTO addBookToCart(CartDTO cartDTO)  {
//        CartModel cart = modelMapper.map(cartDTO, CartModel.class);
//        if (cartRepository.findByBookAndUser(cartDTO.getBook(), cartDTO.getUser()).isPresent())
//            throw new UserRegistrationException(400,"Book Already Present in cart");
//        cartRepository.save(cart);
//        return cartDTO;
//    }



}
