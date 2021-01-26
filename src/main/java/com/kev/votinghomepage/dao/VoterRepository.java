package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VoterDTO;

public interface VoterRepository extends JpaRepository<VoterDTO, Integer> {

  
}
