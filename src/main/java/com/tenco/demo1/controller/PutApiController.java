package com.tenco.demo1.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
	 * [PUT 요청에서 본문이 있다. RequestBody - DTO ]
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
	
	/**
	 * PathVariable 사용 시 경로(PATH)에서 변수를 추출하여 
	 * 메서드 파라미터로 전달한다. 
	 * - path: URL 경로에서 데이터를 추출하는 방식으로, 
	 * 		   경로에 포함된 변수 값을 가져옵니다. 
	 * 		   "/demo2/{userId}"에서 "userId" 값을 추출합니다.
	 * - data: HTTP 요청 본문에서 데이터를 추출하는 방식으로,
	 *         JSON이나 XML 데이터를 자바 객체로 변환하여
	 *         메서드 파라미터로 전달합니다.
	 *
	 * @param dto: HTTP 요청 본문에서 추출된 UserDTO 객체입니다. @RequestBody를 통해 JSON 데이터를 자바 객체로 변환한다.
	 * @param userId: 경로 변수로, URL 경로에서 추출된 사용자 ID입니다. @PathVariable을 통해 추출된다.
	 * @return UserDTO: 처리된 사용자 정보를 반환합니다.
	 */
	@PutMapping("/demo2/{userId}")
	public UserDTO demo2(@RequestBody UserDTO dto, @PathVariable(name = "userId") Long id) {
	    System.out.println(id);
	    return new UserDTO();
	}

}
