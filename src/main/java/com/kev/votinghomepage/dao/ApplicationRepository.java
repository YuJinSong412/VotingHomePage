package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.ApplicationDTO;

public interface ApplicationRepository extends JpaRepository<ApplicationDTO, Integer>{
  
  

}
