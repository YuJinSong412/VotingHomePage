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
import com.kev.votinghomepage.request.VoteListDTO;
import lombok.Data;


// @SqlResultSetMappings({~,})
@SqlResultSetMapping(name = "voteListMapping",
    classes = @ConstructorResult(targetClass = VoteListDTO.class,
        columns = {
            @ColumnResult(name = "vote_seq", type = Integer.class),
            @ColumnResult(name = "apart_name", type = String.class),
            @ColumnResult(name = "vote_start_date", type = String.class),
            @ColumnResult(name = "vote_end_date", type = String.class),
            @ColumnResult(name = "vote_title", type = String.class),
            @ColumnResult(name = "esm_voter", type = Integer.class),}))

@NamedNativeQuery(
    query = "select v.vote_seq, a.apart_name, v.vote_start_date, v.vote_end_date, v.vote_title, v.esm_voter from application a JOIN vote v ON a.vote_seq = v.vote_seq where a.vote_seq = (select vote_seq from vote_history where manager_seq = :MANAGER_SEQ) ;",
    name = "getVoteList", resultSetMapping = "voteListMapping")

@NamedNativeQuery(
    query = "select v.vote_seq, a.apart_name, v.vote_start_date, v.vote_end_date, v.vote_title, v.esm_voter from application a JOIN vote v ON a.vote_seq = v.vote_seq;",
    name = "getVoteList_sysAdmin", resultSetMapping = "voteListMapping")

@Entity
@Table(name = "vote")
@Data
public class VoteDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

  @Column(name = "VOTE_START_DATE")
  private String voteStartDate;

  @Column(name = "VOTE_END_DATE")
  private String voteEndDate;

  @Column(name = "VOTE_TITLE")
  private String voteTitle;

  @Column(name = "ESM_VOTER")
  private Integer esmVoter;
  
  @Column(name = "VOTE_STATE_CD")
  private String voteStateCd;

}
