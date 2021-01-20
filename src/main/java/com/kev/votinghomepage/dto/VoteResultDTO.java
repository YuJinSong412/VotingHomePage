package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vote_result")
@Data
public class VoteResultDTO {
  
  @Id
  @Column(name = "VOTER_RESULT_SEQ")
  private int voterResultSeq;

  @Column(name = "VOTE_SEQ")
  private String voteSeq;

  @Column(name = "VOTE_ITEM_SEQ")
  private String voterItemSeq;

  @Column(name = "CAND_SEQ")
  private String candSeq;
  
  @Column(name = "VOTE_VALUE")
  private String voteValue;

  @Column(name = "PARCPANT_SEQ")
  private String parcpantSeq;
}
