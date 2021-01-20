package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vote_parcpant")
@Data
public class VoteParcpantDTO {
  
  @Id
  @Column(name = "PARCPANT_SEQ")
  private int parcpantSeq;

  @Column(name = "VOTE_SEQ")
  private String voteSeq;

  @Column(name = "VOTER_SEQ")
  private String voterSeq;

  @Column(name = "VOTE_REG_DATE")
  private String voteRegDate;

}
