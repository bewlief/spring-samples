package com.green.nowon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@SequenceGenerator(name = "gen_user", sequenceName = "seq_user", initialValue = 1001, allocationSize = 1)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_user") //MyUser로 써도 동일하게 들어감
@Entity
public class MyUserEntity extends BaseDateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_user") //sequence 이름이 아닌 generator 이름 삽입
	private long no;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	//social user인 경우 password가 필요없으므로 nullable = false 설정하지 않음
	private String pass;
	
	private String nickName;
	
	private boolean isSocial; //social login 여부 확인
	
	@Builder.Default //빌더에 적용되지 않으므로 default로 생성...?
	@Enumerated(EnumType.STRING) //저장되는 데이터 타입. defualt: ordinal(숫자형).
	@CollectionTable(name = "role") //테이블 이름 설정하지 않으면 부모 테이블명 + 변수명: my_user_role_set 
	//entity에 종속되는 테이블 이라는 의미(1:M): entity라기보다는 basic type, embededdable class을 의미
	@ElementCollection(fetch = FetchType.EAGER)
	//부모 테이블의 pk를 fk로 사용
	private Set<MyRole> roleSet = new HashSet<>();
	
	public MyUserEntity addRole(MyRole role) {
		roleSet.add(role);
		return this;
	}
	
}
