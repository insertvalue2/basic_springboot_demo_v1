package com.tenco.demo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // 이 클래스가 JPA 엔티티임을 나타냅니다. 데이터베이스 테이블과 매핑됩니다.
@Data  // 게터(getter), 세터(setter), toString(), equals(), hashCode() 메서드를 자동으로 생성합니다.
@NoArgsConstructor  
@AllArgsConstructor  
public class User {

    @Id  // 이 필드가 엔티티의 기본 키(primary key)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키 생성을 데이터베이스에 위임합니다 (주로 AUTO_INCREMENT).
    private Long id;
    
    private String name; 
    private String email;  
}
