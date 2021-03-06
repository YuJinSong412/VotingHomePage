package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sysadmin")
@Data
public class SysAdminDTO {

  @Id
  @Column(name = "ADMIN_SEQ")
  private Integer adminSeq;

  @Column(name = "ADMIN_CATG")
  private String adminCatg;

  @Column(name = "ADMIN_ID")
  private String adminID;

  @Column(name = "ADMIN_PW")
  private String adminPW;

}
