package com.tenco.demo1.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo1.dto.UserDTO;

@RestController
@RequestMapping("/put")
public class PutApiController {
	
	/**
	 * 주소 설계 
	 * http://localhost:80/put/demo1 PUT
	 * @param 본문 - { ... }
	 * @return JSON 
	 * [Post 요청에서 본문이 있다. RequestBody - Map ]
	 * 테스트 - post man 활용
	 * 단순 문자열 데이터로 내려 보기  
	 */
	@PutMapping("/demo1")
	public UserDTO put(@RequestBody UserDTO dto) {
		System.out.println(dto.toString());
		// 응답시에 Object 로 내려 보자.  
		// MappingJackson2HttpMessageConverter 동작 (JSON 변환 됨) 
		return dto;
	}

}
