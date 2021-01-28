package com.kev.votinghomepage.mergedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteItem {
  
  private String voteItemTitle;
  
  private String candidateName; 

}
