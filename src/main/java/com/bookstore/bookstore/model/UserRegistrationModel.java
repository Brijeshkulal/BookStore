package com.bookstore.bookstore.model;

import com.bookstore.bookstore.dto.UserRegistrationDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="UserRegistration")
@Data
public class UserRegistrationModel 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String fullName;
	private LocalDate registeredDate;
	private LocalDate updatedDate;
	@Column(name = "email")
	private String emailId;
	private String password;
	private String mobileNo;
	private boolean verify;
	private String address;
	private String state;
	private String city;
	private String type;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = CartItem.class)
	@JoinColumn(name = "Id")
	private List<CartItem> cartBooks;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Wishlist.class)
	@JoinColumn(name = "Id")
	private List<Wishlist> wishlistBook;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Order.class)
	@JoinColumn(name = "Id")
	private List<Order> orderBookDetails;


	public UserRegistrationModel() {
		
	}

	public UserRegistrationModel(int Id, UserRegistrationDTO userRegistrationDTO)
	{
		this.mobileNo=userRegistrationDTO.getMobileNo();
		this.fullName = userRegistrationDTO.getFullName();
		this.emailId = userRegistrationDTO.getEmailId();
		this.password = userRegistrationDTO.getPassword();
	}



}
