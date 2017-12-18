package mypack.Response;

import mypack.pojo.Course;

public class CourseInfo extends Course{
    private String startWeek;
    private String endWeek;
    private String times;
    private String teaName;
    private String depName;


    public CourseInfo() {
    }

    public CourseInfo(long id, String name, int type, int credict, int totalTime, String learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int stuNumber, int quantity, int opening, String startWeek, String endWeek, String times, String teaName, String depName) {
        super(id, name, type, credict, totalTime, learnTerm, learnYear, classroom, depID, timeSlotID, proID, admID, stuNumber, quantity, opening);
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.times = times;
        this.teaName = teaName;
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(String startWeek) {
        this.startWeek = startWeek;
    }

    public String getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(String endWeek) {
        this.endWeek = endWeek;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return getName()+"\n  "+getTeaName()+"\n  "+getClassroom()+"\n  ("+getStartWeek()+"-"+getEndWeek()+")\n";

    }

    public String toAllString() {
        return "cID:"+getId()+",cname:"+getName()+",teacher:"+getTeaName()+",classroom:"+getClassroom()+",ctype:"+getStrType()+",clscore:"+getCredict()+",cltime:"+getTotalTime()+",cbelongto:"+getDepName()+",weeks:"+getLastingTime()+",stuNumber:"+getStuNumber()+",quantity:"+getQuantity();
    }
    private String getStrType(){
        if(getType()==1)
            return "必修课";
        else if(getType()==2)
            return "选修课";
        else
            return "通选课";
    }
    private String getLastingTime(){
        return "第"+getStartWeek()+"--"+getEndWeek()+"周";

    }
}
