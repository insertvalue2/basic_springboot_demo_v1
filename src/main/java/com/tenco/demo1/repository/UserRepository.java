package com.tenco.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenco.demo1.model.User;

// @Repository 
// 데이터베이스와 상호작용하는 JPA 레포지토리
public interface UserRepository extends JpaRepository<User, Long> {
	// 기본 CRUD 메서드 외에도, 커스텀 쿼리 메서드를 추가할 수 있습니다.
    // List<User> findByName(String name);
}
