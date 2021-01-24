package com.kev.votinghomepage.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;

@Data
public class votingHistoryKey implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "MANAGER_SEQ")
  private Integer managerSeq;

  @Id
  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;
}
