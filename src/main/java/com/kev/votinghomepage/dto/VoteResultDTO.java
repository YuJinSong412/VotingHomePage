package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vote_result")
@Data
public class VoteResultDTO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "VOTE_RESULT_SEQ")
  private Integer voteResultSeq;

  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

  @Column(name = "VOTE_ITEM_SEQ")
  private Integer voterItemSeq;

  @Column(name = "CAND_SEQ")
  private Integer candSeq;
  
  @Column(name = "VOTE_VALUE")
  private String voteValue;

  @Column(name = "PARCPANT_SEQ")
  private Integer parcpantSeq;
}
