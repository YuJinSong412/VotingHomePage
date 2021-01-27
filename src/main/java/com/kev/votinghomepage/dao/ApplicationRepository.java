package com.kev.votinghomepage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.kev.votinghomepage.dto.ApplicationDTO;
import com.kev.votinghomepage.request.ApplyForm;

public interface ApplicationRepository extends JpaRepository<ApplicationDTO, Integer>{
  
  @Query(name = "getApplyForm", nativeQuery = true)
  public List<ApplyForm> getApplyFormList(@Param("MANAGER_SEQ") int managerSeq);
  
  @Query(name="getApplyForm_sysAdmin", nativeQuery = true)
  public List<ApplyForm> getApplyFormList();
  
 
}
