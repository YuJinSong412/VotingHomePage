package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GuideController {
  
  @GetMapping("/")
  public String moveGuidePage() {

    return "guidePage";
  }
  

}
