package com.kev.votinghomepage.request;

import lombok.Data;

@Data
public class ApplyFormRequest {
  
  private String apartName;
  
  private String apartTel;
 
  private String bizLcsNum;
  
  private String managerName;
  
  private String managerPosition;
  
  private String managerTel;
  
  private String voteTitle;
  
  private String esmVoter;
  
  private String voteStartTime;
  
  private String voteEndTime;

}
