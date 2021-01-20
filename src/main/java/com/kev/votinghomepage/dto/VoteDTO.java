package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vote")
@Data
public class VoteDTO {
  
  @Id
  @Column(name = "VOTE_SEQ")
  private int voteSeq;

  @Column(name = "VOTE_START_DATE")
  private String voteStartDate;

  @Column(name = "VOTE_END_DATE")
  private String voteEndDate;

  @Column(name = "VOTE_TITLE")
  private String voteTitle;
  
  @Column(name = "ESM_VOTER")
  private String esmVoter;

}
