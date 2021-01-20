package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kev.votinghomepage.dto.SysAdminDTO;

@Repository
public interface UserRepository extends JpaRepository<SysAdminDTO, Integer>{ 

}
