package com.kev.votinghomepage.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kev.votinghomepage.RandomOut;
import com.kev.votinghomepage.dao.VotingManagerRepository;
import com.kev.votinghomepage.dto.VotingManagerDTO;

@Controller
public class ApplyFormController {

  @Autowired
  public VotingManagerRepository votingManagerRepo;

  @GetMapping("/applyForm")
  public String moveApplyForm() {

    return "common/applyForm";

  }

  @PostMapping("/applyForm.do")
  public ResponseEntity<VotingManagerDTO> applyFormPage(HttpServletRequest req, Model model) {

    RandomOut randomOut = new RandomOut();
    String managerId = randomOut.getRandomStr(4);
    String managerPw = randomOut.getRandomStr(6);
        
    VotingManagerDTO votingManagerDTO = new VotingManagerDTO();
    votingManagerDTO.setManagerName(req.getParameter("managerName"));
    votingManagerDTO.setManagerPosition(req.getParameter("managerPosition"));
    votingManagerDTO.setManagerPHNum(req.getParameter("managerTel"));
    votingManagerDTO.setManagerId(managerId);
    votingManagerDTO.setManagerPw(managerPw);
    votingManagerRepo.save(votingManagerDTO);
    
    
    model.addAttribute("id", 200);
    model.addAttribute("pw", managerPw);
    
    return ResponseEntity.ok(votingManagerDTO);

  }

}
