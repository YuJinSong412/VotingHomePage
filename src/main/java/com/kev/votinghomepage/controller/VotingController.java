package com.kev.votinghomepage.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kev.votinghomepage.ApplicationDate;
import com.kev.votinghomepage.dao.VoteParcpantRepository;
import com.kev.votinghomepage.dao.VoteResultRepository;
import com.kev.votinghomepage.dao.VoterRepository;
import com.kev.votinghomepage.dto.VoteParcpantDTO;
import com.kev.votinghomepage.dto.VoteResultDTO;
import com.kev.votinghomepage.dto.VoterDTO;
import com.kev.votinghomepage.dto.bind.VotingInfoDTO;

@Controller
@RequestMapping("/voters")
public class VotingController {

  @Autowired
  VoterRepository voterRepo;
  
  @Autowired
  VoteParcpantRepository vpRepo;
  
  @Autowired
  VoteResultRepository vrRepo;

  @GetMapping("/authentication")
  public String moveAuthenticationPage() {

    return "voters/authentication";

  }

  @GetMapping("/voteOverview")
  public String moveVoteOverviewPage() {

    return "voters/voterVoteOverview";

  }

  @GetMapping("/voting")
  public String moveVotingPage(HttpServletRequest req, Model model) {

    Integer voteSeq = (Integer) (req.getSession().getAttribute("voteSeq"));

    List<VotingInfoDTO> votingInfoList = voterRepo.getVotingInfoList(voteSeq);

    model.addAttribute("votingInfoList", votingInfoList);

    return "voters/voting";

  }

  @GetMapping("/voteResult")
  public String moveVoteResultPage() {

    return "voters/voterVoteResult";

  }

  @PostMapping("/authentication.do")
  public String authenticationPage(HttpServletRequest req) {

    String voterCont = req.getParameter("voterCont");
    String phoneNum = req.getParameter("phoneNum");

    Optional<VoterDTO> voterDTO = voterRepo.findByVoterContAndPhoneNum(voterCont, phoneNum);
    VoterDTO result = voterDTO.orElseGet(() -> null);

    if (result == null) {
      return "redirect:/common/index";
    } else {

      req.getSession().setAttribute("voterName", result.getVoteName());
      req.getSession().setAttribute("voteSeq", result.getVoteSeq());
      req.getSession().setAttribute("voterSeq",  result.getVoterSeq());
      
      return "redirect:/voters/voting";
    }

  }

  @GetMapping("/voteOut")
  public String doVoteOut(HttpServletRequest req) {

    req.getSession().invalidate();

    return "redirect:/voters/authentication";
  }

  @PostMapping("/voting.do")
  public String doVoting(HttpServletRequest req) {

    Integer voteSeq = (Integer) (req.getSession().getAttribute("voteSeq"));
    Integer voterSeq = (Integer) (req.getSession().getAttribute("voterSeq"));

    List<VotingInfoDTO> votingInfoList = voterRepo.getVotingInfoList(voteSeq);

    ApplicationDate appDate = new ApplicationDate();
    String dateStr = appDate.getApplicationDate();
    
    VoteParcpantDTO voterParcpantDTO = new VoteParcpantDTO();
    voterParcpantDTO.setVoteSeq(voteSeq);
    voterParcpantDTO.setVoterSeq(voterSeq);
    voterParcpantDTO.setVoteRegDate(dateStr);
    voterParcpantDTO = vpRepo.save(voterParcpantDTO);
    
    VoteResultDTO voteResultDTO = new VoteResultDTO();
    voteResultDTO.setVoteSeq(voteSeq);
    voteResultDTO.setVoterItemSeq(votingInfoList.get(0).getVoteItemSeq());
    voteResultDTO.setCandSeq(votingInfoList.get(0).getCandSeq());
    voteResultDTO.setVoteValue(req.getParameter("sendResultBtn"));
    voteResultDTO.setParcpantSeq(voterParcpantDTO.getParcpantSeq());
    vrRepo.save(voteResultDTO);
    
    return "redirect:/voters/voteResult";
  }

}
