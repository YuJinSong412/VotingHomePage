package com.kev.votinghomepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kev.votinghomepage.dto.VoteParcpantDTO;

public interface VoteParcpantRepository extends JpaRepository<VoteParcpantDTO, Integer> {

}
