package com.qfedu.mtlms.dto;

public class InfoDetail {
    private int infoDetailId;
    private String infoDetailName;
    private String infoDetailDesc;

    @Override
    public String toString() {
        return "InfoDetail{" +
                "infoDetailId=" + infoDetailId +
                ", infoDetailName='" + infoDetailName + '\'' +
                ", infoDetailDesc='" + infoDetailDesc + '\'' +
                '}';
    }

    public InfoDetail() {
    }

    public InfoDetail(int infoDetailId, String infoDetailName, String infoDetailDesc) {
        this.infoDetailId = infoDetailId;
        this.infoDetailName = infoDetailName;
        this.infoDetailDesc = infoDetailDesc;
    }

    public int getInfoDetailId() {
        return infoDetailId;
    }

    public void setInfoDetailId(int infoDetailId) {
        this.infoDetailId = infoDetailId;
    }

    public String getInfoDetailName() {
        return infoDetailName;
    }

    public void setInfoDetailName(String infoDetailName) {
        this.infoDetailName = infoDetailName;
    }

    public String getInfoDetailDesc() {
        return infoDetailDesc;
    }

    public void setInfoDetailDesc(String infoDetailDesc) {
        this.infoDetailDesc = infoDetailDesc;
    }
}
