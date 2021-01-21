package com.kev.votinghomepage.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplyFormController {

  @GetMapping("/applyForm")
  public String moveApplyForm() {

    return "common/applyForm";
    
  }
  
  @PostMapping("applyForm.do")
  public String applyFormPage(HttpServletRequest req) {
    
    //req.getParameter(name)
    return null;
    
  }

}
