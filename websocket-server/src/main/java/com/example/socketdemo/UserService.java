package com.example.socketdemo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

	
	//public SocialLoginResponseDTO createGlobalUser(GlobalUserRequestDTO globalUserRequestDTO);



	public UserDetails getUserByUserName(String username);
	public User findById(Long id);
	public User findByUsername(String username);



















//	User findTestUser(String username);

}
