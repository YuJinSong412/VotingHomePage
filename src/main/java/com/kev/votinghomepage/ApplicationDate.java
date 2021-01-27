package com.kev.votinghomepage;

import java.util.Calendar;

public class ApplicationDate {
  
  public String getApplicationDate() {
    Calendar cal = Calendar.getInstance();

    // 현재 년도, 월, 일
    int year = cal.get(cal.YEAR);
    int month = cal.get(cal.MONTH) + 1;
    int date = cal.get(cal.DATE);

    String dateStr = year + "/" + month + "/" + date;

    return dateStr;
  }
  

}
