package mypack.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {
    private long id;
    private String password;
    private String name;
    private Date timeEnrollment;
    private Date timeGraduation;
    private String title;
    private  int sex;
    private Date birthday;
    private String nationality;
    private String areaInterest;
    private String healthState;
    private String nativePlace;
    private String politicalStatus;
    private int majId;
    private long claId;



    public Student() {
    }



    public Student(long id, String password, String name, Date timeEnrollment, Date timeGraduation, String title, int sex, Date birthday, String nationality, String areaInterest, String healthState, String nativePlace, String politicalStatus, int majId, long claId) {

        this.id = id;
        this.password = password;
        this.name = name;
        this.timeEnrollment = timeEnrollment;
        this.timeGraduation = timeGraduation;
        this.title = title;
        this.sex = sex;
        this.birthday = birthday;
        this.nationality = nationality;
        this.areaInterest = areaInterest;
        this.healthState = healthState;
        this.nativePlace = nativePlace;
        this.politicalStatus = politicalStatus;
        this.majId = majId;
        this.claId = claId;


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

    public Date getTimeEnrollment() {
        return timeEnrollment;
    }

    public void setTimeEnrollment(Date timeEnrollment) {
        this.timeEnrollment = timeEnrollment;
    }

    public Date getTimeGraduation() {
        return timeGraduation;
    }

    public void setTimeGraduation(Date timeGraduation) {
        this.timeGraduation = timeGraduation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public int getMajId() {
        return majId;
    }

    public void setMajId(int majId) {
        this.majId = majId;
    }

    public long getClaId() {
        return claId;
    }

    public void setClaId(long claId) {
        this.claId = claId;
    }

}
