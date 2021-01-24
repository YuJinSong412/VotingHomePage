package com.kev.votinghomepage.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kev.votinghomepage.dao.VoteRepository;
import com.kev.votinghomepage.dto.VoteListDTO;

@Controller
@RequestMapping("/votemanager")
public class voteManagerController {
  
  @Autowired
  public VoteRepository voteRepo;
  
  
  @GetMapping("/myPage")
  public String moveMypage(HttpServletRequest req, Model model) {
    
    Integer managerSeq = (Integer)(req.getSession().getAttribute("managerSeq"));
    
    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);
    
    model.addAttribute("voteList", voteList);
    
    return "votemanager/myPage";
    
  }
  
  @GetMapping("/voteOverview")
  public String moveVoteOverview() {
    
    return "common/voteOverview";
    
  }
  
  @GetMapping("/voteForm")
  public String moveMakeVoteForm() {
    
    return "votemanager/voteForm";
    
  }
  
  @GetMapping("/voteManagementForm")
  public String moveVoteManagementForm() {
    
    return "votemanager/voteManagementForm";
    
  }
  
  @GetMapping("/voteResult")
  public String moveVoteResult() {
    
    return "common/voteResult";
    
  }

}
