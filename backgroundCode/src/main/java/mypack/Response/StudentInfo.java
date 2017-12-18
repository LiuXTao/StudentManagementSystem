package mypack.Response;

import mypack.pojo.Student;

import java.sql.Date;

public class StudentInfo extends Student {

    private String majName;
    private String depName;
    private String claName;
    private String stringtimeEnrollment;
    private String stringtimeGraducation;
    private String stringbirthDay;
    public StudentInfo() {

    }

    public StudentInfo(long id, String password, String name, Date timeEnrollment, Date timeGraduation, String title, int sex, Date birthday, String nationality, String areaInterest, String healthState, String nativePlace, String politicalStatus, int majId, long claId, String majName, String depName, String claName) {
        super(id, password, name, timeEnrollment, timeGraduation, title, sex, birthday, nationality, areaInterest, healthState, nativePlace, politicalStatus, majId, claId);
        this.majName = majName;
        this.depName = depName;
        this.claName = claName;
    }

    public String getStringtimeEnrollment() {
        return stringtimeEnrollment;
    }

    public void setStringtimeEnrollment(String stringtimeEnrollment) {
        this.stringtimeEnrollment = stringtimeEnrollment;
    }

    public String getStringtimeGraducation() {
        return stringtimeGraducation;
    }

    public void setStringtimeGraducation(String stringtimeGraducation) {
        this.stringtimeGraducation = stringtimeGraducation;
    }

    public String getStringbirthDay() {
        return stringbirthDay;
    }

    public void setStringbirthDay(String stringbirthDay) {
        this.stringbirthDay = stringbirthDay;
    }

    public String getMajName() {
        return majName;
    }

    public void setMajName(String majName) {
        this.majName = majName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName;
    }
}
