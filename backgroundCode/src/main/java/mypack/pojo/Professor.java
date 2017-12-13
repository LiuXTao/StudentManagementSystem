package mypack.pojo;

import java.io.Serializable;
import java.util.Date;

public class Professor implements Serializable {
    private long id;
    private String password;
    private String name;
    private Integer teachingAge;
    private String title;
    private String educationBackground;
    private Date birthday;
    private String nationality;
    private String areaInterest;
    private String sex;
    private String politicalStatus;
    private String contactInfomation;
    private int depId;

    public Professor() {
    }

    public Professor(long id, String password, String name, Integer teachingAge, String title, String educationBackground, Date birthday, String nationality, String areaInterest, String sex, String politicalStatus, String contactInfomation, int depId) {

        this.id = id;
        this.password = password;
        this.name = name;
        this.teachingAge = teachingAge;
        this.title = title;
        this.educationBackground = educationBackground;
        this.birthday = birthday;
        this.nationality = nationality;
        this.areaInterest = areaInterest;
        this.sex = sex;
        this.politicalStatus = politicalStatus;
        this.contactInfomation = contactInfomation;
        this.depId = depId;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeachingAge() {
        return teachingAge;
    }

    public void setTeachingAge(Integer teachingAge) {
        this.teachingAge = teachingAge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAreaInterest() {
        return areaInterest;
    }

    public void setAreaInterest(String areaInterest) {
        this.areaInterest = areaInterest;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getContactInfomation() {
        return contactInfomation;
    }

    public void setContactInfomation(String contactInfomation) {
        this.contactInfomation = contactInfomation;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }
}
