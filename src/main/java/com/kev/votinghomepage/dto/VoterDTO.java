package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "voter")
@Data
public class VoterDTO {
  
  @Id
  @Column(name = "VOTER_SEQ")
  private int voterSeq;

  @Column(name = "VOTE_SEQ")
  private String voteSeq;

  @Column(name = "VOTER_NAME")
  private String voteName;

  @Column(name = "PHONE_NUM")
  private String phoneNum;

  @Column(name = "VOTER_CONT")
  private String voterCont;
}
