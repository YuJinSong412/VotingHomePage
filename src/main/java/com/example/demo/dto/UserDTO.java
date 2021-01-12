package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sysadmin")
@Data
public class UserDTO {

  @Id
  @Column(name = "ADMIN_SEQ")
  private int adminSeq;

  @Column(name = "ADMIN_CATG")
  private String adminCatg;

  @Column(name = "ADMIN_ID")
  private String adminID;

  @Column(name = "ADMMIN_PW")
  private String adminPW;

}
