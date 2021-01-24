package com.kev.votinghomepage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteListDTO {
  
  private String apartName;
  
  private String voteStartDate;
  
  private String voteEndDate;
  
  private String voteTitle;
  
  private String esmVoter;
  
}
