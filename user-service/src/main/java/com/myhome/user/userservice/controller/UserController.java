package com.myhome.user.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.user.userservice.entity.User;
import com.myhome.user.userservice.service.UserService;
import com.myhome.user.userservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
    @Autowired
	private UserService userService;
	
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
    	//log.infor("saveUser method of UserController");
    	return userService.saveUser(user);
    }
    
    @GetMapping("/{id}")
    public ResponseTemplateVO getDepartmentByUserId(@PathVariable("id") Long userId) {
    	return userService.getDepartmentByUserId(userId);
    }
	
}
