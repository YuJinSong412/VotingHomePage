package com.kev.votinghomepage.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VotingManagerDTO;

public interface VotingManagerRepository extends JpaRepository<VotingManagerDTO, Integer > {

  Optional<VotingManagerDTO> findByManagerIdAndManagerPw(String managerId, String managerPw);
}
