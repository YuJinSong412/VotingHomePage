package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voters")
public class VotingController {

  @GetMapping("/authentication")
  public String moveAuthenticationPage() {

    return "voters/authentication";
    
  }

  @GetMapping("/voteOverview")
  public String moveVoteOverviewPage() {

    return "common/voteOverview";

  }
  
  @GetMapping("/voting")
  public String moveVotingPage() {
    
    return "voters/voting";
    
  }
  
  @GetMapping("/voteResult")
  public String moveVoteResultPage() {
    
    return "common/voteResult";
    
  }
}
