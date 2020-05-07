package com.yltech.SABlog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yltech.SABlog.dto.LoginRequest;
import com.yltech.SABlog.dto.RegistrationRequest;
import com.yltech.SABlog.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity signup(@RequestBody RegistrationRequest registrationRequest) {
		authService.signup(registrationRequest);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
}
