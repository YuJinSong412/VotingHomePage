package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "voteitem")
@Data
public class VoteItemDTO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "VOTE_ITEM_SEQ")
  private Integer voteItemSeq;

  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

  @Column(name = "VOTE_ITEM_NAME")
  private String voteItemName;

  @Column(name = "VOTE_ITEM_TYPE")
  private String voteItemType;

}
