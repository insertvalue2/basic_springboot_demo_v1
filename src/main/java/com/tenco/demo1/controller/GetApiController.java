package com.tenco.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController // @Controller + @ResponseBody, IoC
//@RequestMapping("/xxx")
public class GetApiController {
	
	@GetMapping("/hello")
	public String hello() {
		// 메시지 컨버터가 동작 (단순 문자열 반환)
		// StringHttpMessageConverter 동작 함 
		return "say hello";
	}
	
	/**
	 * 쿼리스트링 방식(@RequestParam)
	 * 주소 설계 
	 * http://localhost:80/qs1?name=둘리
	 * @param name=value
	 * @return String 
	 *
	 */
	@GetMapping("/qs1")
	public String qs1(@RequestParam(name = "name") String name) {
		return "name="+name;
	}
	
	/**
	 * 쿼리스트링 방식(@RequestParam)
	 * required, defaultValue 사용  
	 * 주소 설계 
	 * http://localhost:80/qs2?name=둘리&age=10
	 * @param [name, age]
	 * @return String 
	 *
	 */
	@GetMapping("/qs2")
	public String qs2(@RequestParam(name = "name") String name, 
			@RequestParam(name = "age", required = false, defaultValue = "0") Integer age) {
		return "name="+name+"&age="+age;
	}
	
	
	/**
	 * 쿼리스트링 방식(@RequestParam)
	 * 주소 설계 
	 * http://localhost:80/qs3?name=둘리&age=10&groupId=com.tenco
	 * @param [name, age, groupId]
	 * @return String 
	 * [Get 요청에서 본문이 없다 RequestParam - Map ]
	 */
	@GetMapping("/qs3")
	public String qs3(@RequestParam Map<String, String> data) {
		// Map 방식으로 동적 파싱해보기 
		StringBuffer sb = new StringBuffer();
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey()+"="+entry.getValue());
		});
		return sb.toString();
	}
	
	
	/**
	 * 쿼리스트링 방식(@RequestParam)
	 * 주소 설계 
	 * http://localhost:80/qs4
	 * @param 
	 * @return User  
	 *
	 */
	@GetMapping("/qs4")
	public User helloObject() {
		// 응답시에 Object 로 내려 보자.  
		// MappingJackson2HttpMessageConverter 동작 함 
		return new User("둘리", 10);
	}
	
	@AllArgsConstructor
	@Getter
	// @Setter (get, set 유무 반드시 확인) 
	class User {
		private String name; 
		private Integer age;
	}	
}




