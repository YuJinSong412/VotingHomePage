package com.kev.votinghomepage.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.SysAdminDTO;

public interface SysadminRepository extends JpaRepository<SysAdminDTO, Integer> {

  Optional<SysAdminDTO> findByAdminIDAndAdminPW(String adminID, String adminPW);

}