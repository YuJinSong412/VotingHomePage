package com.example.demo.controller.voter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vote")
public class VotingController {

  @GetMapping("/home")
  public String votingMainPage() {

    return "vote/votingMain";
    
  }

  @GetMapping("/overview")
  public String votingOverviewPage() {

    return "vote/votingOverview";

  }
  
  @GetMapping("/voting")
  public String votingPage() {
    
    return "vote/votingScreen";
    
  }
  
  @GetMapping("/votingResult")
  public String votingResultPage() {
    
    return "vote/votingResult";
    
  }
}
