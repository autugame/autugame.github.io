package com.qfedu.mtlms.dto;

import java.util.List;

/**
 * Evaluation category information entity class.
 */
public class BasicInfo {
    private int basicInfoId;
    private String basicInfoName;
    private int basicInfoStatus;
    //Define attribute storage options.
    private List<InfoDetail> infoDetailList;

    public List<InfoDetail> getInfoDetailList() {
        return infoDetailList;
    }

    public void setInfoDetailList(List<InfoDetail> infoDetailList) {
        this.infoDetailList = infoDetailList;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "basicInfoId=" + basicInfoId +
                ", basicInfoName='" + basicInfoName + '\'' +
                ", basicInfoStatus=" + basicInfoStatus +
                '}';
    }

    public BasicInfo() {
    }

    public BasicInfo(int basicInfoId, String basicInfoName, int basicInfoStatus) {
        this.basicInfoId = basicInfoId;
        this.basicInfoName = basicInfoName;
        this.basicInfoStatus = basicInfoStatus;
    }

    public int getBasicInfoId() {
        return basicInfoId;
    }

    public void setBasicInfoId(int basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public String getBasicInfoName() {
        return basicInfoName;
    }

    public void setBasicInfoName(String basicInfoName) {
        this.basicInfoName = basicInfoName;
    }

    public int getBasicInfoStatus() {
        return basicInfoStatus;
    }

    public void setBasicInfoStatus(int basicInfoStatus) {
        this.basicInfoStatus = basicInfoStatus;
    }
}
