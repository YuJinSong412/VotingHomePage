package com.kev.votinghomepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kev.votinghomepage.ApplicationDate;
import com.kev.votinghomepage.RandomOut;
import com.kev.votinghomepage.dao.ApplicationRepository;
import com.kev.votinghomepage.dao.VoteRepository;
import com.kev.votinghomepage.dao.VotingHistoryRepository;
import com.kev.votinghomepage.dao.VotingManagerRepository;
import com.kev.votinghomepage.dto.ApplicationDTO;
import com.kev.votinghomepage.dto.VoteDTO;
import com.kev.votinghomepage.dto.VotingHistoryDTO;
import com.kev.votinghomepage.dto.VotingManagerDTO;
import com.kev.votinghomepage.request.ApplyFormRequest;

@Controller
public class ApplyFormController {

  @Autowired
  public VotingManagerRepository votingManagerRepo;
  
  @Autowired
  public ApplicationRepository applicationRepo; 
  
  @Autowired
  public VoteRepository voteRepo;
  
  @Autowired
  public VotingHistoryRepository votingHistoryRepo;

  @GetMapping("/applyForm")
  public String moveApplyForm() {

    return "common/applyForm";
 
  }

  @PostMapping("/applyForm.do")
  public @ResponseBody VotingManagerDTO applyFormPage(@RequestBody ApplyFormRequest req) {

    RandomOut randomOut = new RandomOut();
    String managerId = randomOut.getRandomStr(4);
    String managerPw = randomOut.getRandomStr(6);
    
    VoteDTO voteDTO = new VoteDTO();
    voteDTO.setVoteTitle(req.getVoteTitle());
    voteDTO.setEsmVoter(req.getEsmVoter());
    voteDTO.setVoteStartDate(req.getVoteStartTime());
    voteDTO.setVoteEndDate(req.getVoteEndTime());
    voteDTO = voteRepo.save(voteDTO);
    
    ApplicationDTO appDTO = new ApplicationDTO();
    appDTO.setApartName(req.getApartName());
    appDTO.setApartNum(req.getApartTel());
    appDTO.setBizLcsNum(req.getBizLcsNum());
    appDTO.setVoteSeq(voteDTO.getVoteSeq());
    applicationRepo.save(appDTO);
    
    
    VotingManagerDTO votingManagerDTO = new VotingManagerDTO();
    votingManagerDTO.setManagerName(req.getManagerName());
    votingManagerDTO.setManagerPosition(req.getManagerPosition());
    votingManagerDTO.setManagerPHNum(req.getManagerTel());
    votingManagerDTO.setManagerId(managerId);
    votingManagerDTO.setManagerPw(managerPw);
    votingManagerDTO = votingManagerRepo.save(votingManagerDTO);
    
    ApplicationDate appDate = new ApplicationDate();
    String dateStr = appDate.getApplicationDate();
    
    VotingHistoryDTO votingHistoryDTO = new VotingHistoryDTO();
    votingHistoryDTO.setManagerSeq(votingManagerDTO.getManagerSeq());
    votingHistoryDTO.setVoteSeq(voteDTO.getVoteSeq());
    votingHistoryDTO.setRegDate(dateStr);
    votingHistoryRepo.save(votingHistoryDTO);
    
    
    return votingManagerDTO;

  }

}
