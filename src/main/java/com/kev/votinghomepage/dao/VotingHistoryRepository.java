package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VotingHistoryDTO;

public interface VotingHistoryRepository extends JpaRepository<VotingHistoryDTO,Integer>{

}
