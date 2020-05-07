package com.yltech.SABlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yltech.SABlog.dto.LoginRequest;
import com.yltech.SABlog.dto.RegistrationRequest;
import com.yltech.SABlog.entities.User;
import com.yltech.SABlog.repositories.UserRepository;
import com.yltech.SABlog.security.JwtProvider;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	
	public void signup(RegistrationRequest registrationRequest) {
		User user = new User();
		user.setUsername(registrationRequest.getUsername());
		user.setPassword(registrationRequest.getPassword());
		user.setEmail(encodePassword(registrationRequest.getEmail()));
		userRepository.save(user);
	}
	 public String encodePassword(String password) {
		 return passwordEncoder.encode(password);
	 }
	public String login(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtProvider.generateToken(authentication);
	}
	
}
