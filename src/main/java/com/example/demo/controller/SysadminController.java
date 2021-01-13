package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sysadmin")
public class SysadminController {
  
  @GetMapping("/applicationStatus")
  public String moveApplicationStatus() {
    
    return "sysadmin/applicationStatus";
    
  }
  
  
  @GetMapping("/applicationStatusDetail")
  public String moveApplicationStatusDetail() {
    
    return "sysadmin/applicationStatusDetail";
    
  }
  
  @GetMapping("/voteOverview")
  public String moveOverview() {
    
    return "voteOverview";
    
  }
  
  @GetMapping("/votingStatus")
  public String moveVotingStatus() {
    
    return "sysadmin/votingStatus";
    
  }
  
  @GetMapping("/voteResult")
  public String moveVoteResult() {
    
    return "voteResult";
    
  }

}
