package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VoteItemDTO;

public interface VoteItemRepository extends JpaRepository<VoteItemDTO, Integer>{

}
