package com.kev.votinghomepage.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kev.votinghomepage.dao.SysadminRepository;
import com.kev.votinghomepage.dao.VotingManagerRepository;
import com.kev.votinghomepage.dto.SysAdminDTO;
import com.kev.votinghomepage.dto.VotingManagerDTO;

@Controller
public class LoginController {

  @Autowired
  public SysadminRepository sysAdminRepo;

  @Autowired
  public VotingManagerRepository votingManagerRepo;

  @GetMapping("/login")
  public String moveLoginPage() {

    return "common/login";
  }

  @PostMapping("/login.do")
  public String loginPage(HttpServletRequest req) {

    String loginId = req.getParameter("loginId");
    String loginPw = req.getParameter("loginPW");

    Optional<SysAdminDTO> sysAdminDTO = sysAdminRepo.findByAdminIDAndAdminPW(loginId, loginPw);
    SysAdminDTO result = sysAdminDTO.orElseGet(() -> null);

   
    if (result == null) {
      Optional<VotingManagerDTO> votingManagerDTO =
          votingManagerRepo.findByManagerIdAndManagerPw(loginId, loginPw);
      VotingManagerDTO v_result = votingManagerDTO.orElseGet(() -> new VotingManagerDTO());

      
      if (loginId.equals(v_result.getManagerId()) && loginPw.equals(v_result.getManagerPw())) {
        req.getSession().setAttribute("managerSeq", v_result.getManagerSeq());
        req.getSession().setAttribute("managerName", v_result.getManagerName());
        
        return "redirect:/votemanager/myPage";
      } else {
        return "redirect:/common/index";
      }
    } else {
      
      req.getSession().setAttribute("sysAdminSeq" , result.getAdminSeq());
      req.getSession().setAttribute("sysAdminId", result.getAdminID());
      
      return "redirect:/sysadmin/applicationStatusDetail";
    }
  }

}
