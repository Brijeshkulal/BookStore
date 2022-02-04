package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.Order;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.CartRepository;
import com.bookstore.bookstore.repository.OrderRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import com.bookstore.bookstore.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private UserRegistrationRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<BookModel> placeOrder(String token,  List<BookModel> orderBookList) {
        int userId = TokenUtil.decodeToken(token);

        UserRegistrationModel user = userRepository.findById(userId).orElse(null);

        addOrderedBookToRepo(user, orderBookList);

        cartRepository.deleteById(userId);

        return orderBookList;
    }


    public String addOrderedBookToRepo(UserRegistrationModel user, List<BookModel> orderBookList){

        for (int i=0; i<orderBookList.size();i++) {
            Order order = new Order();
            order.setBookModel(orderBookList.get(i));
            order.setOrderStatus("Confirmed");
            order.setUserRegistrationModel(user);
            order.setOrderPlacedTime(LocalDateTime.now());
            orderRepository.save(order);
        }
        return "Item added successfully";
    }

    @Override
    public List<Order> orderList(String token){
        int userId = TokenUtil.decodeToken(token);
        return orderRepository.findOrdersById(userId);

    }
}


