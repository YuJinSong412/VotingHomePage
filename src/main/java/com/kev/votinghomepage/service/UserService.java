package com.kev.votinghomepage.service;

import java.util.List;
import com.kev.votinghomepage.dto.UserDTO;

public interface UserService {

  List<UserDTO> getAllUser();
}
