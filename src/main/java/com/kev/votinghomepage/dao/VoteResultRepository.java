package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VoteResultDTO;

public interface VoteResultRepository extends JpaRepository<VoteResultDTO, Integer>{

}
