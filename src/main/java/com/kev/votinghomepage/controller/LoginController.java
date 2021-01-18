package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/login")
public class LoginController {

  @GetMapping("/login")
  public String moveLoginPage() {
    
    return "common/login";
  }

}
