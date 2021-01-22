package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class ApplicationDTO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "APP_SEQ")
  private int appSeq;

  @Column(name = "APART_NAME")
  private String apartName;

  @Column(name = "BIZ_LCS_NUM")
  private String bizLcsNum;
  
  @Column(name = "APART_NUM")
  private String apartNum;

  @Column(name = "VOTE_SEQ")
  private int voteSeq;

}
