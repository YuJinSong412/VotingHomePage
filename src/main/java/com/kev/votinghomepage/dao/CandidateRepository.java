package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.CandidateDTO;

public interface CandidateRepository extends JpaRepository<CandidateDTO, Integer>{

}
