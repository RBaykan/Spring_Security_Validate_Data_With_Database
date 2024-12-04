package com.nontius.proje.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.nontius.proje.dto.UserDTO;


@Service
public interface UserService {
	List<UserDTO> getAllUser();
	UserDTO registerNewUser(UserDTO user);

}
