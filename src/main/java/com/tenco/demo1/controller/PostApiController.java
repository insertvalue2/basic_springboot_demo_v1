package com.tenco.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo1.dto.UserDTO;

@RestController
@RequestMapping("/post")
public class PostApiController {
	
	/**
	 * 주소 설계 
	 * http://localhost:80/post/demo1 POST
	 * @param 본문 - {"name" : "둘리", "age": 11}
	 * @return String
	 * [Post 요청에서 본문이 있다. RequestBody - Map ]
	 * 테스트 - post man 활용
	 * 단순 문자열 데이터로 내려 보기  
	 */
	@PostMapping("/demo1")
	public String demo1(@RequestBody Map<String, Object> reqData) {		
		StringBuffer sb = new StringBuffer();
		reqData.entrySet().forEach(entry  -> {
			System.out.print("key : " + entry.getKey());
			System.out.print("value : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		// 메시지 컨버터가 동작 (단순 문자열 반환)
		// StringHttpMessageConverter 동작 함 
		return sb.toString();
	}
	
	/**
	 * 주소 설계 
	 * http://localhost:80/post/demo2 POST
	 * @param 본문 - {"name" : "둘리", "age": 11, "phone_number" : "010-1234-1234"}
	 * @return JSON
	 * [Post 요청에서 본문이 있다. RequestBody - Object 로 파싱 ]
	 * 테스트 - post man 활용
	 * DTO 방식으로 데이터 내려 보기 
	 * @RequestBody 생략 가능   
	 */
	@PostMapping("/demo2")
	public UserDTO demo2(@RequestBody UserDTO userDTO) {		
		// 응답시에 Object 로 내려 보자.  
		// MappingJackson2HttpMessageConverter 동작 함
		System.out.println(userDTO.toString());
		UserDTO userDto2 = userDTO;
		return userDto2;
	}	
	
}
