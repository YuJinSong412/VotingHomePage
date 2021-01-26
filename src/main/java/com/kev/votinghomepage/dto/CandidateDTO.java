package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "candidate")
@Data
public class CandidateDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CAND_SEQ")
  private Integer candSeq;

  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

  @Column(name = "VOTE_ITEM_SEQ")
  private Integer voteItemSeq;

  @Column(name = "CAND_NAME")
  private String candName;
}
