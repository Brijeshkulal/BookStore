package com.bookstore.bookstore.service;

import com.bookstore.bookstore.exception.UserRegistrationException;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.CartItem;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import com.bookstore.bookstore.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private UserRegistrationRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<CartItem> addBooktoCart(String token, int bookId) {
        //decode the token to get userId
        int userId = TokenUtil.decodeToken(token);
        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        BookModel book = bookRepository.findById(bookId).get();
        //checking book is present or not in the repo
        if (book != null) {
            int noOfBooks = book.getNoOfBooks();
            if (noOfBooks > 0) {
                List<BookModel> books = null;
                //Adding the already present books in the cart to the bookmodel list
                for (CartItem cart : user.getCartBooks()) {
                    books = cart.getBooksList();
                }
                // if booklist is null we are storing the book details in repo
                if (books == null) {
                    UserRegistrationModel userdetails = this.cartbooks(book, user);
                    return userRepository.save(userdetails).getCartBooks();
                }

                Optional<BookModel> cartbook = books.stream().filter(t -> t.getBookId() == bookId).findFirst();
                if (cartbook.isPresent()) {
                    throw null;
                } else {
                    UserRegistrationModel userdetails = this.cartbooks(book, user);
                    return userRepository.save(userdetails).getCartBooks();
                }

            }
            throw new UserRegistrationException(400, "Out of stock you cannot add to cart");
        }
        return null;
    }


    public UserRegistrationModel cartbooks(BookModel book, UserRegistrationModel user) {
        CartItem cart = new CartItem();
        ArrayList<BookModel> booklist = new ArrayList<>();
        booklist.add(book);
        cart.setCreatedTime(LocalDateTime.now());
        cart.setBooksList(booklist);
        user.getCartBooks().add(cart);
        return user;
    }

}
