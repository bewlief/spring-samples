package com.green.nowon.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.UserSaveDTO;
import com.green.nowon.domain.entity.MyUserEntityRepository;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceProcess implements UserService {
	
	private final MyUserEntityRepository repository;
	
	private final PasswordEncoder encoder;

	@Override
	public void saveProcess(UserSaveDTO dto) {
		
		//dto에 getter 설정해서 뽑아와도 됨
		repository.save(dto.toEntity(encoder).addRole(MyRole.USER));
		
	}

}
