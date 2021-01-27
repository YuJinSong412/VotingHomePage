package com.kev.votinghomepage.enums;


public enum VoteStatusCode {

  A("01", "접수"),
  B("02", "이용신청서 승인 완료"),
  C("03", "만들기 승인 완료"),
  D("04", "투표 진행 중"),
  E("05", "개표 완료");

  private final String codeNum;

  private final String codeTitle;

  private VoteStatusCode(String codeNum, String codeTitle) {

    this.codeNum = codeNum;
    this.codeTitle = codeTitle;
  }


  public String getCodeNum() {

    return codeNum;
  }


  public String getCodeTitle() {

    return codeTitle;
  }

}