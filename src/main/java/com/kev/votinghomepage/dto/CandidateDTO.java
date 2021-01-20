package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "candidate")
@Data
public class CandidateDTO {

  @Id
  @Column(name = "CAND_SEQ")
  private int candSeq;

  @Column(name = "VOTE_SEQ")
  private String voteSeq;

  @Column(name = "VOTE_ITEM_SEQ")
  private String voteItemSeq;

  @Column(name = "CAND_NAME")
  private String candName;
}
