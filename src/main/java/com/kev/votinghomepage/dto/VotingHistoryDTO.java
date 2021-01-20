package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vote_history")
@Data
public class VotingHistoryDTO {
  
  @Id
  @Column(name = "MANAGER_SEQ")
  private int managerSeq;

  @Id
  @Column(name = "VOTE_SEQ")
  private String voteSeq;

  @Column(name = "REG_DATE")
  private String regDate;

}
