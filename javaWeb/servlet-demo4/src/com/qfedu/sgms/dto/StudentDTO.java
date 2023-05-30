package com.qfedu.sgms.dto;

public class StudentDTO {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private String stuPwd;

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", age=" + stuAge +
                ", stuPwd='" + stuPwd + '\'' +
                '}';
    }

    public StudentDTO(String stuNum, String stuName, String stuGender, int age, String stuPwd) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = age;
        this.stuPwd = stuPwd;
    }

    public StudentDTO() {
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getAge() {
        return stuAge;
    }

    public void setAge(int age) {
        this.stuAge = age;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }
}
