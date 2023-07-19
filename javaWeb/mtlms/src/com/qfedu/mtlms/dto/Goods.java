package com.qfedu.mtlms.dto;

public class Goods {
    private int goodId;
    private String goodName;
    private String goodImg;
    private int goodCost;
    private int goodMinPrice;

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodImg='" + goodImg + '\'' +
                ", goodCost=" + goodCost +
                ", goodMinPrice=" + goodMinPrice +
                '}';
    }

    public Goods() {
    }

    public Goods(int goodId, String goodName, String goodImg, int goodCost, int goodMinPrice) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodImg = goodImg;
        this.goodCost = goodCost;
        this.goodMinPrice = goodMinPrice;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    public int getGoodCost() {
        return goodCost;
    }

    public void setGoodCost(int goodCost) {
        this.goodCost = goodCost;
    }

    public int getGoodMinPrice() {
        return goodMinPrice;
    }

    public void setGoodMinPrice(int goodMinPrice) {
        this.goodMinPrice = goodMinPrice;
    }
}
