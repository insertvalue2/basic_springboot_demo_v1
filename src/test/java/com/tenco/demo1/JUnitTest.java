package com.tenco.demo1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Junit으로 단위 테스트 만들기 
 */
public class JUnitTest {
	
	// 1. 기본 테스트 코드 작성해보기 
	/** 
	 * JUnit은 테스트별 영향을 주지 않도록 각 테스트 실행마다 
	 * 테스트를 위한 실행 객체를 만들고 테스트가 종료되면 실행
	 * 객체를 삭제합니다. 
	 */
	@DisplayName("산술 계산 테스트") // 테스트 이름 
	@Test // 테스트 메서드
	public void junitTest() {
		int a = 10; 
		int b = 20; 
		int sum  = 30;
		// Junit 에서 제공하는 검증 메서드 
		Assertions.assertEquals(sum, a + b); // 값이 같은지 확인 
	}
	
	// 2. 자주 사용하는 어노테이션 알아 보기
	
	// 전체 테스트를 시작하기 전에 1회 실행하므로 [[메서드를 static 으로 선언]] 
	@BeforeAll 
	static void beforeAll() {
		System.out.println("@BeforeAll");
	}
	
	@BeforeEach // 각각의 테스트 메서드마다 시작하기 전에 수행 
	public void beforeEach() {
		System.out.println("@BeforeEach");
	}
	
	@Test
	public void test1() {
		System.out.println("TEST 1 수행");
	}
	
	@Test
	public void test2() {
		System.out.println("TEST 2 수행");
	}
	
	@Test
	public void test3() {
		System.out.println("TEST 3 수행");
	}
		
	@AfterAll  // 전체 테스트틀 마치고 종료하기 전에 1회 실행하므로 [[static 으로 선언 ]]
	static void afterAll() {
		System.out.println("@AfterAll");
	}
	
	@AfterEach // 각각 테스트 케이스를 종료하기 전마다 실행 
	public void afterEach() {
		System.out.println("@AfterEach");
	}
	
}
