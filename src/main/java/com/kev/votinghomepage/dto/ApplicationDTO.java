package com.kev.votinghomepage.dto;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import com.kev.votinghomepage.dto.bind.ApplyForm;
import lombok.Data;

@SqlResultSetMapping(name = "applyFormMapping",
    classes = @ConstructorResult(targetClass = ApplyForm.class,
        columns = {@ColumnResult(name = "apart_name", type = String.class),
            @ColumnResult(name = "apart_num", type = String.class),
            @ColumnResult(name = "biz_lcs_num", type = String.class),
            @ColumnResult(name = "manager_name", type = String.class),
            @ColumnResult(name = "position", type = String.class),
            @ColumnResult(name = "ph_num", type = String.class),
            @ColumnResult(name = "vote_title", type = String.class),
            @ColumnResult(name = "esm_voter", type = Integer.class),
            @ColumnResult(name = "vote_start_date", type = String.class),
            @ColumnResult(name = "vote_end_date", type = String.class),}))

@NamedNativeQuery(
    query = "SELECT a.apart_name, a.apart_num, a.biz_lcs_num, m.manager_name, m.position, m.ph_num, v.vote_title, v.esm_voter, v.vote_start_date, v.vote_end_date \r\n"
        + "FROM application a INNER JOIN vote v ON a.vote_seq = v.vote_seq INNER JOIN vote_history h ON h.vote_seq = v.vote_seq INNER JOIN voting_manager m ON h.manager_seq = m.manager_seq\r\n"
        + "WHERE a.vote_seq = (select vote_seq from vote_history where manager_seq = :MANAGER_SEQ);",
    name = "getApplyForm", resultSetMapping = "applyFormMapping")

@NamedNativeQuery(
    query = "SELECT a.apart_name, a.apart_num, a.biz_lcs_num, m.manager_name, m.position, m.ph_num, v.vote_title, v.esm_voter, v.vote_start_date, v.vote_end_date \r\n"
        + "FROM application a INNER JOIN vote v ON a.vote_seq = v.vote_seq INNER JOIN vote_history h ON h.vote_seq = v.vote_seq INNER JOIN voting_manager m ON h.manager_seq = m.manager_seq\r\n",
    name = "getApplyForm_sysAdmin", resultSetMapping = "applyFormMapping")


@Entity
@Table(name = "application")
@Data
public class ApplicationDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "APP_SEQ")
  private Integer appSeq;

  @Column(name = "APART_NAME")
  private String apartName;

  @Column(name = "BIZ_LCS_NUM")
  private String bizLcsNum;

  @Column(name = "APART_NUM")
  private String apartNum;

  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

}
