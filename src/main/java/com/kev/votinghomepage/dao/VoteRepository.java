package com.kev.votinghomepage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.kev.votinghomepage.dto.VoteDTO;
import com.kev.votinghomepage.request.VoteListDTO;

public interface VoteRepository extends JpaRepository<VoteDTO, Integer> {

  @Query(name = "getVoteList", nativeQuery = true)
  public List<VoteListDTO> getVoteList(@Param("MANAGER_SEQ") int managerSeq);

  @Query(name = "getVoteList_sysAdmin", nativeQuery = true)
  public List<VoteListDTO> getVoteList();

  @Transactional
  @Modifying
  @Query(value = "UPDATE vote SET vote_state_cd= :voteStateCd WHERE VOTE_SEQ= :voteSeq",
      nativeQuery = true)
  void updateStatusCodeByVoteSeq(@Param("voteStateCd") String ca,
      @Param("voteSeq") Integer voteSeq);

}
