package mypack.Response;

import mypack.pojo.Professor;

import java.sql.Date;

public class TeacherInfo extends Professor {

    private String depName;
    private String stringBirthday;

    public String getStringBirthday() {
        return stringBirthday;
    }

    public void setStringBirthday(String stringBirthday) {
        this.stringBirthday = stringBirthday;
    }

    public TeacherInfo() {
    }

    public TeacherInfo(long id, String password, String name, Integer teachingAge, String title, String educationBackground, Date birthday, String nationality, String areaInterest, int sex, String politicalStatus, String contactInfomation, int depId, String depName) {
        super(id, password, name, teachingAge, title, educationBackground, birthday, nationality, areaInterest, sex, politicalStatus, contactInfomation, depId);
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "depName:"+depName;
    }
}
