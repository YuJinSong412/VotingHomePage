package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplyFormController {

  @GetMapping("/applyForm")
  public String moveApplyForm() {

    return "common/applyForm";
    
  }

}
