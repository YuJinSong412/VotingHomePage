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
import com.kev.votinghomepage.dto.bind.VotingInfoDTO;
import lombok.Data;

@SqlResultSetMapping(name = "votingInfoListMapping",
    classes = @ConstructorResult(targetClass = VotingInfoDTO.class,
        columns = {@ColumnResult(name = "vote_item_seq", type = Integer.class),
            @ColumnResult(name = "vote_seq", type = Integer.class),
            @ColumnResult(name = "vote_item_name", type = String.class),
            @ColumnResult(name = "vote_item_type", type = String.class),
            @ColumnResult(name = "cand_seq", type = Integer.class),
            @ColumnResult(name = "cand_name", type = String.class),}))

@NamedNativeQuery(
    query = "select * from voteitem i, candidate c where i.vote_seq = :VOTE_SEQ and i.vote_seq = c.vote_seq and i.vote_item_seq = c.vote_item_seq;",
    name = "getVotingInfoList", resultSetMapping = "votingInfoListMapping")


@Entity
@Table(name = "voter")
@Data
public class VoterDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "VOTER_SEQ")
  private Integer voterSeq;

  @Column(name = "VOTE_SEQ")
  private Integer voteSeq;

  @Column(name = "VOTER_NAME")
  private String voteName;

  @Column(name = "PHONE_NUM")
  private String phoneNum;

  @Column(name = "VOTER_CONT")
  private String voterCont;
}
