package com.kev.votinghomepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/login")
public class LoginController {

  @GetMapping("/login")
  public String moveLoginPage() {
    
    return "common/login";
  }
  
  @GetMapping("/login.do")
  public String loginPage(@RequestParam(value = "loginId") String id, @RequestParam(value = "loginPW") String pw) {
    if(id.equals("1") && pw.equals("1")) {
      return "sysadmin/applicationStatus";
    }else if(id.equals("2") && pw.equals("2")) {
      return "votemanager/myPage"; 
    }else {
      return "common/index";
    }
  }

}
