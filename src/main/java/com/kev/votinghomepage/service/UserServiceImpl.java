package com.kev.votinghomepage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kev.votinghomepage.dao.UserRepository;
import com.kev.votinghomepage.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{

  @Autowired  //자동 연결 
  private UserRepository userRepository;
  
  
  @Override
  public List<UserDTO> getAllUser() {
    
    return userRepository.findAll();

  }

}
