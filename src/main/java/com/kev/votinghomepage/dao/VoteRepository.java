package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VoteDTO;

public interface VoteRepository extends JpaRepository<VoteDTO, Integer>{

}
