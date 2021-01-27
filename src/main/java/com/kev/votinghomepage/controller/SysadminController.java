package com.kev.votinghomepage.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kev.votinghomepage.dao.ApplicationRepository;
import com.kev.votinghomepage.dao.VoteRepository;
import com.kev.votinghomepage.request.ApplyForm;
import com.kev.votinghomepage.request.VoteListDTO;

@Controller
@RequestMapping("/sysadmin")
public class SysadminController {

  @Autowired
  public VoteRepository voteRepo;

  @Autowired
  public ApplicationRepository applicationRepo;

  @GetMapping("/applicationStatus")
  public String moveApplicationStatus() {

    return "sysadmin/applicationStatus";

  }


  @GetMapping("/applicationStatusDetail")
  public String moveApplicationStatusDetail(HttpServletRequest req, Model model) {

    List<VoteListDTO> voteList = voteRepo.getVoteList();

    model.addAttribute("voteList", voteList);

    List<ApplyForm> applyFormList = applicationRepo.getApplyFormList();
    System.out.println(applyFormList.size());
    model.addAttribute("applyFormList", applyFormList);

    return "sysadmin/applicationStatusDetail";

  }

  @GetMapping("/voteOverview")
  public String moveOverview() {

    return "common/voteOverview";

  }

  @GetMapping("/votingStatus")
  public String moveVotingStatus() {

    return "sysadmin/votingStatus";

  }

  @GetMapping("/voteResult")
  public String moveVoteResult() {

    return "common/voteResult";

  }

}
