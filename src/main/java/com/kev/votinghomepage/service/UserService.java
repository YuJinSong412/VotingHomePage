package com.kev.votinghomepage.service;

import java.util.List;
import com.kev.votinghomepage.dto.SysAdminDTO;

public interface UserService {

  List<SysAdminDTO> getAllUser();
}
