package com.kev.votinghomepage.dto.bind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyForm {
  
  private String apartName;
  
  private String apartTel;
 
  private String bizLcsNum;
  
  private String managerName;
  
  private String managerPosition;
  
  private String managerTel;
  
  private String voteTitle;
  
  private Integer esmVoter;
  
  private String voteStartTime;
  
  private String voteEndTime;

}
