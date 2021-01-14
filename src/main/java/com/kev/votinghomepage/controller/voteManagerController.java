package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/votemanager")
public class voteManagerController {
  
  @GetMapping("/myPage")
  public String moveMypage() {
    
    return "votemanager/myPage";
    
  }
  
  @GetMapping("/voteOverview")
  public String moveVoteOverview() {
    
    return "voteOverview";
    
  }
  
  @GetMapping("/makeVoteForm")
  public String moveMakeVoteForm() {
    
    return "votemanager/makeVoteForm";
    
  }
  
  @GetMapping("/voteManagementForm")
  public String moveVoteManagementForm() {
    
    return "votemanager/voteManagementForm";
    
  }
  
  @GetMapping("/voteResult")
  public String moveVoteResult() {
    
    return "voteResult";
    
  }

}
