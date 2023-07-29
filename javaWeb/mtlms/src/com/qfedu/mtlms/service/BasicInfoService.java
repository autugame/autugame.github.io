package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.BasicInfoDAO;
import com.qfedu.mtlms.dto.BasicInfo;

import java.util.List;

/**
 * Complete the evaluation category operation.
 */
public class BasicInfoService {
    private static final BasicInfoDAO BASIC_INFO_DAO = new BasicInfoDAO();
    public List<BasicInfo> listBasicInfo(){
        return BASIC_INFO_DAO.selectBasicInfos();
    }

    public boolean saveBasicInfo(BasicInfo basicInfo){
        int i = BASIC_INFO_DAO.insertBasicInfo(basicInfo);
        return i > 0;
    }
}
