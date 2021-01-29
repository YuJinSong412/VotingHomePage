package com.kev.votinghomepage.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.kev.votinghomepage.dao.ApplicationRepository;
import com.kev.votinghomepage.dao.CandidateRepository;
import com.kev.votinghomepage.dao.VoteItemRepository;
import com.kev.votinghomepage.dao.VoteRepository;
import com.kev.votinghomepage.dao.VoterRepository;
import com.kev.votinghomepage.dto.CandidateDTO;
import com.kev.votinghomepage.dto.VoteItemDTO;
import com.kev.votinghomepage.dto.VoterDTO;
import com.kev.votinghomepage.dto.bind.ApplyForm;
import com.kev.votinghomepage.dto.bind.VoteItem;
import com.kev.votinghomepage.dto.bind.VoteListDTO;

@Controller
@RequestMapping("/votemanager")
public class voteManagerController {

  @Autowired
  public VoteRepository voteRepo;

  @Autowired
  public ApplicationRepository applicationRepo;

  @Autowired
  public VoterRepository voterRepo;

  @Autowired
  public VoteItemRepository voteItemRepo;

  @Autowired
  public CandidateRepository candRepo;

  @GetMapping("/myPage")
  public String moveMypage(HttpServletRequest req, Model model) {

    Integer managerSeq = (Integer) (req.getSession().getAttribute("managerSeq"));

    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);

    model.addAttribute("voteList", voteList);

    List<ApplyForm> applyFormList = applicationRepo.getApplyFormList(managerSeq);

    model.addAttribute("applyFormList", applyFormList);

    return "votemanager/myPage";

  }

  @GetMapping("/voteOverview")
  public String moveVoteOverview() {

    return "common/voteOverview";

  }

  @GetMapping("/voteForm")
  public String moveMakeVoteForm(HttpServletRequest req, Model model) {

    Integer managerSeq = (Integer) (req.getSession().getAttribute("managerSeq"));

    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);

    model.addAttribute("voteList", voteList);

    return "votemanager/voteForm";

  }

  @GetMapping("/voteManagementForm")
  public String moveVoteManagementForm(HttpServletRequest req, Model model) {

    Integer managerSeq = (Integer) (req.getSession().getAttribute("managerSeq"));

    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);

    model.addAttribute("voteList", voteList);

    return "votemanager/voteManagementForm";

  }

  @GetMapping("/voteResult")
  public String moveVoteResult() {

    return "common/voteResult";

  }

  @PostMapping("/parseVoter")
  public @ResponseBody Void parseVoter(@RequestParam("myFile") MultipartFile file,
      HttpServletRequest req) throws IOException {

    String extension = FilenameUtils.getExtension(file.getOriginalFilename());
    if (!extension.equals("xls")) {
      throw new IOException("엑셀파일을 업로드 해주세요.");
    }
    Workbook workbook = new HSSFWorkbook(file.getInputStream());
    Sheet worksheet = workbook.getSheetAt(0);

    Integer managerSeq = (Integer) (req.getSession().getAttribute("managerSeq"));
    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);

    for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
      Row row = worksheet.getRow(i);
      if (row.getCell(0) == null) {
        break;
      }

      VoterDTO voterDTO = new VoterDTO();
      voterDTO.setVoteName(row.getCell(0).getStringCellValue());
      voterDTO.setPhoneNum(row.getCell(1).getStringCellValue());
      voterDTO.setVoterCont(row.getCell(2).getStringCellValue());
      voterDTO.setVoteSeq(voteList.get(0).getVoteSeq());
      voterRepo.save(voterDTO);

    }
    return null;
  }

  @PostMapping("/makeVote.do")
  public String makeVote(HttpServletRequest req, VoteItem request) { // , VoteItem request

    Integer managerSeq = (Integer) (req.getSession().getAttribute("managerSeq"));
    List<VoteListDTO> voteList = voteRepo.getVoteList(managerSeq);

    VoteItemDTO voteItemDTO = new VoteItemDTO();
    voteItemDTO.setVoteItemName(request.getVoteItemTitle());
    voteItemDTO.setVoteItemType("찬반 투표");
    voteItemDTO.setVoteSeq(voteList.get(0).getVoteSeq());
    voteItemDTO = voteItemRepo.save(voteItemDTO);

    CandidateDTO candDTO = new CandidateDTO();
    candDTO.setVoteSeq(voteList.get(0).getVoteSeq());
    candDTO.setVoteItemSeq(voteItemDTO.getVoteItemSeq());
    candDTO.setCandName(request.getCandidateName());
    candRepo.save(candDTO);


    return "redirect:/votemanager/voteManagementForm";
  }

  @PostMapping("/statusCode")
  public @ResponseBody Void changeStatusCode(@RequestParam("voteSeq") Integer voteSeq,
      @RequestParam("code") String code) {

    voteRepo.updateStatusCodeByVoteSeq(code, voteSeq);

    return null;

  }


}
