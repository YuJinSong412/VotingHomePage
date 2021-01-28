package com.kev.votinghomepage.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kev.votinghomepage.dto.VoterDTO;
import com.kev.votinghomepage.mergedto.VotingInfoDTO;

public interface VoterRepository extends JpaRepository<VoterDTO, Integer> {

  Optional<VoterDTO> findByVoterContAndPhoneNum(String voterCont, String phoneNum);
  
  @Query(name = "getVotingInfoList", nativeQuery = true)
  public List<VotingInfoDTO> getVotingInfoList(@Param("VOTE_SEQ") int voteSeq);
}
