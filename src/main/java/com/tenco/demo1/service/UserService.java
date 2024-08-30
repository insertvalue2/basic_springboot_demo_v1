package com.tenco.demo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tenco.demo1.model.User;
import com.tenco.demo1.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

    public User createUser(User user) {
    	// save()는 JpaRepository에서 제공하는 메서드로,
    	// 엔티티 객체를 데이터베이스에 저장하거나, 
    	// 이미 존재하는 엔티티일 경우 업데이트합니다    	
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
    	// findById JpaRepository에서 제공하는 메서드
    	// orElseThrow()는 Optional 객체가 값을 포함하고 있으면 그 값을 반환하고, 
    	// 값이 없을 경우 지정된 예외를 던집니다.
    	// 즉, User 반환 하거나 예외를 던지거나 !! 
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
    
    public List<User> getAllUsers() {
    	List<User> users = userRepository.findAll();
    	return users;
    }
}
