package com.fastcampus.controller;



import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;
import com.fastcampus.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동
	@GetMapping("/auth/login") 
	public String login() {
		return "system/login";
		}
	
	// 회원가입 화면으로 이동
	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
	// 회원 가입 처리
	@PostMapping("/auth/insertUser")
	public @ResponseBody String insertUser(@RequestBody User user) {
		//username으로 등록된 회원이 있나 검색한다
		User findUser = userService.getUser(user.getUsername());
		
		if(findUser.getUsername() == null) {
			user.setRole("USER");
			userService.insertUser(user);
			return user.getUsername() + "회원 가입 성공";
		}else {
			return user.getUsername() + "아이디는 이미 존재합니다";
		}
	}
}
