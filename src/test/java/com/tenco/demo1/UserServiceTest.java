package com.tenco.demo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tenco.demo1.model.User;
import com.tenco.demo1.repository.UserRepository;
import com.tenco.demo1.service.UserService;

// UserService 단위 테스트 
// Given-When-Then(GWT) 구조로 테스트 (행동 기반 개발 패턴)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	public UserServiceTest() {
		MockitoAnnotations.openMocks(this); // Mockito 초기화
	}

	//@Test
	public void testCreateUser() {
		// Given: 사용자 객체가 주어졌을 때
		User user = new User(null, "둘리2", "a@example.com");
		
			
		// UserRepository가 사용자를 저장하면 ID가 1인 사용자가 반환된다고 가정합니다.
		when(userRepository.save(user)).thenReturn(new User(1L, "둘리2", "a@example.com"));

		// When: createUser 메서드를 호출했을 때
		User createdUser = userService.createUser(user);

		// Then: 반환된 사용자가 기대한 값과 일치하는지 확인합니다.
		assertEquals(1L, createdUser.getId());
		assertEquals("둘리2", createdUser.getName());
		assertEquals("a@example.com", createdUser.getEmail());
	}

	@Test
	public void testGetUserById() {
		// Given: 특정 ID를 가진 사용자가 없을 때
		Long userId = 1L;
		// UserRepository가 이 ID로 조회했을 때, 빈 Optional을 반환한다고 가정합니다.
		// Optional.of(user), Optional.empty()
		when(userRepository.findById(userId)).thenReturn(Optional.empty());
		//모킹된 메서드의 실제 반환 타입과 일치해야 합니다	
		
		
		// When & Then: getUserById 메서드가 호출되면 예외가 발생하는지 확인합니다.
		assertThrows(IllegalArgumentException.class, () -> userService.getUserById(userId));
	}

}
