package com.qfedu.test.service;

import com.qfedu.mtlms.dto.BasicInfo;
import com.qfedu.mtlms.service.BasicInfoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BasicInfoServiceTest {
    private static final BasicInfoService BASIC_INFO_SERVICE = new BasicInfoService();
    @Test
    public void listBasicInfo() {
        List<BasicInfo> basicInfoList = BASIC_INFO_SERVICE.listBasicInfo();
        System.out.println();
    }
}