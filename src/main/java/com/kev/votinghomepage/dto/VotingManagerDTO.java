package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "voting_manager")
@Data
public class VotingManagerDTO {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MANAGER_SEQ")
  private int managerSeq;

  @Column(name = "PH_NUM")
  private String managerPHNum;

  @Column(name = "MANAGER_NAME")
  private String managerName;

  @Column(name = "POSITION")
  private String managerPosition;
  
  @Column(name = "MANAGER_ID")
  private String managerId;
  
  @Column(name = "MANAGER_PW")
  private String managerPw;

}
