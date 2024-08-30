package com.tenco.demo1;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tenco.demo1.model.User;
import com.tenco.demo1.repository.UserRepository;

 
@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성(IoC 동작 해라. 테스트를 위해 빈 생성해줘)  
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성 
public class UserControllerTest {
	
	@Autowired
	protected MockMvc mockMvc;
	// MockMvc: 스프링 MVC의 동작을 모킹하여 웹 애플리케이션을 테스트할 수 있는 클래스.
    // 실제 서버를 시작하지 않고도 컨트롤러의 HTTP 요청/응답을 테스트할 수 있습니다.
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private UserRepository userRepository; // 실제 빈 대신 모킹된 객체로 변경
	
	@BeforeEach // 테스트 실행 전 실행하는 메서드
	public void mockMvcSetUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@AfterEach
	public void cleanUp() {
		// 목 객체는 실제 데이터베이스와 상호작용하지 않으므로 데이터베이스 정리 코드가 필요 없습니다.
		// 따라서 이 메서드는 비워 두거나 다른 테스트 리소스를 정리하는 데 사용할 수 있습니다.
	}
	
	@DisplayName("사용자 조회 테스트")
	@Test
	public void getAllMembers() throws Exception {
	    // given - 테스트의 사전 조건을 설정 (유저를 지정) 
	    final String url = "/user/list";
	    User saveUser = new User(1L, "고길동", "a@nate.com");
	    
	    // 목 객체에서 save 메서드의 동작을 정의
	    when(userRepository.save(saveUser)).thenReturn(saveUser);
	    when(userRepository.findAll()).thenReturn(List.of(saveUser)); // findAll 호출 시 반환할 값을 설정

	    // when - 실제 테스트 동작을 수행 (유저 리스트 조회 API 호출)
	    ResultActions result = mockMvc.perform(get(url)
	            .accept(MediaType.APPLICATION_JSON));
	                                
	    // then - 테스트 결과를 검증하는 단계
	    result.andExpect(status().isOk())
	        .andExpect(jsonPath("$[0].id").value(saveUser.getId())) 
	        .andExpect(jsonPath("$[0].name").value(saveUser.getName()));
	}
}
