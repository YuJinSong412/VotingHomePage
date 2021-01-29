package com.kev.votinghomepage.dto.bind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteListDTO {
  
  private Integer voteSeq;
  
  private String apartName;
  
  private String voteStartDate;
  
  private String voteEndDate;
  
  private String voteTitle;
  
  private Integer esmVoter;
  
  private String voteStateCd;
  
}
