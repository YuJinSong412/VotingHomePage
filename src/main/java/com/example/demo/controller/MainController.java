package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@Controller
public class MainController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/")
  public ModelAndView main() {

    ModelAndView mv = new ModelAndView();
    List<UserDTO> userList = userService.getAllUser();
    mv.addObject("userList", userList);
    mv.setViewName("index");
    return mv;
  }

}
