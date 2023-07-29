package com.qfedu.mtlms.service;

import com.qfedu.mtlms.dao.InfoDetailDAO;
import com.qfedu.mtlms.dto.InfoDetail;

import java.util.List;

/**
 * complete business operations related to evaluation options.
 */
public class InfoDetailService {
    /**
     * Query evaluation options under this evaluation category based on the evaluation category id.
     */
    private static final InfoDetailDAO INFO_DETAIL_DAO = new InfoDetailDAO();
    public List<InfoDetail> listDetailByBasicInfo(int basicInfoId){
        return INFO_DETAIL_DAO.selectInfoDetailsByBasicInfo(basicInfoId);
    }

    /**
     * Save evaluation options.
     * @param infoDetail
     * @param basicInfoId
     * @return
     */
    public boolean saveInfoDetail(InfoDetail infoDetail, int basicInfoId){
        int i = INFO_DETAIL_DAO.insertInfoDetail(infoDetail, basicInfoId);
        return i > 0;
    }
}
