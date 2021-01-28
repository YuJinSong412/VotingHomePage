package com.kev.votinghomepage.mergedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingInfoDTO {
  
  private Integer voteItemSeq;
  
  private Integer voteSeq;
  
  private String voteItemName;
 
  private String voteItemType;
  
  private Integer candSeq;

  private String candName;
}
