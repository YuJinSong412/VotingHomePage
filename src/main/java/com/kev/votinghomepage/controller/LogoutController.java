package com.kev.votinghomepage.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

  
  @GetMapping("/logout")
  public String doLogout(HttpServletRequest req) {
    
    req.getSession().invalidate();
    
    return "redirect:/";
  }
}
