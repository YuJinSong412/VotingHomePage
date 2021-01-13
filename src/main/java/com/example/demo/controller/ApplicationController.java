package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/writeApp")
public class ApplicationController {

  @GetMapping("/home")
  public String moveApplicationPage() {

    return "applicationScreen";
  }

  @GetMapping("/appApply")
  public String moveIndexPage() {

    return "index";
  }
}
