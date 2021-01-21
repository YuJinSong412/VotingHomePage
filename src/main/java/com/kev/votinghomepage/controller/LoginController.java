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
// @RequestMapping("/login")
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

    Optional<SysAdminDTO> dto = sysAdminRepo.findByAdminIDAndAdminPW(loginId, loginPw);
    SysAdminDTO result = dto.orElseGet(() -> null);

    if (result == null) {
      Optional<VotingManagerDTO> dto2 =
          votingManagerRepo.findByManagerIdAndManagerPw(loginId, loginPw);
      VotingManagerDTO result2 = dto2.orElseGet(() -> new VotingManagerDTO());

      if (loginId.equals(result2.getManagerId()) && loginPw.equals(result2.getManagerPw())) {
        return "votemanager/myPage";
      } else {
        return "common/index";
      }
    } else {
      return "sysadmin/applicationStatus";
    }
  }

}
