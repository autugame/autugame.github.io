package com.qfedu.test.service;

import com.qfedu.mtlms.dto.InfoDetail;
import com.qfedu.mtlms.service.InfoDetailService;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InfoDetailServiceTest {
    private static final InfoDetailService INFO_DETAIL_SERVICE = new InfoDetailService();

    @Test
    public void listDetailByBasicInfo() {
        List<InfoDetail> infoDetails = INFO_DETAIL_SERVICE.listDetailByBasicInfo(1);
        System.out.println();
    }
    @Test
    public void saveInfoDetail() {
        InfoDetail infoDetail = new InfoDetail(0, "32Gb", "google手机");
        boolean b = INFO_DETAIL_SERVICE.saveInfoDetail(infoDetail, 4);
        System.out.println(b);
    }
}