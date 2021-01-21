package com.kev.votinghomepage.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/login.do")
  public String loginPage(@RequestParam(value = "loginId") String id,
      @RequestParam(value = "loginPW") String pw) {

    Optional<SysAdminDTO> dto = sysAdminRepo.findByAdminIDAndAdminPW(id, pw);
    SysAdminDTO result = dto.orElseGet(() -> null);

    if (result == null) {
      Optional<VotingManagerDTO> dto2 = votingManagerRepo.findByManagerIdAndManagerPw(id, pw);
      VotingManagerDTO result2 = dto2.orElseGet(() -> new VotingManagerDTO());

      if (id.equals(result2.getManagerId()) && pw.equals(result2.getManagerPw())) {
        return "votemanager/myPage";
      } else {
        return "common/index";
      }
    } else {
      return "sysadmin/applicationStatus";
    }

  }

}
