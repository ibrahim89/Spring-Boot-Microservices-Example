package com.myhome.user.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myhome.user.userservice.entity.User;
import com.myhome.user.userservice.repository.UserRepository;
import com.myhome.user.userservice.vo.Department;
import com.myhome.user.userservice.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	
	private RestTemplate restTemplate;
	
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	public User getUserById(Long userId) {
		return userRepository.findByUserId(userId);
	}
	
	public ResponseTemplateVO getDepartmentByUserId(Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
}
