package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuideController {
  
  @GetMapping("/site-map")
  public String moveGuidePage() {

    return "guidePage";
  }
  

}
