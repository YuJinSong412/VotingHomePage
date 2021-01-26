package com.kev.votinghomepage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kev.votinghomepage.dto.VoteDTO;
import com.kev.votinghomepage.request.VoteListDTO;

public interface VoteRepository extends JpaRepository<VoteDTO, Integer> {

  @Query(name = "getVoteList", nativeQuery = true)
  public List<VoteListDTO> getVoteList(@Param("MANAGER_SEQ") int managerSeq);

  @Query(name = "getVoteList_sysAdmin", nativeQuery = true)
  public List<VoteListDTO> getVoteList();

}
