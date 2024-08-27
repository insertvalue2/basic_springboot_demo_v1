package com.tenco.demo1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {

	private String name;
	private Integer age;
	// 요청시에는 phone_number로 받고
	// 자바에서는 phoneNumber로 유지
	// @JsonProperty("phone_number")
	private String phoneNumber;
	private List<CarDTO> carList; 
	
	// 코드 수정 
	// 내부 클래스까지 전역 설정 안됨 
	// @JsonProperty("car_number") 지정 및 전역 설정해야 함
	@Getter
	@ToString
	public static class CarDTO {
		private String name;
		@JsonProperty("car_number") 
		private String carNumber;
	}
	
	
}
