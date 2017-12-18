package mypack.Response;

import mypack.pojo.Takes;

public class TakesInfo extends Takes{
    private String couName;
    private String stuName;

    public TakesInfo() {
    }

    public TakesInfo(long stuId, long couId, double grade, int ranking, int performancePoint, int selected, String couName, String stuName) {
        super(stuId, couId, grade, ranking, performancePoint, selected);
        this.couName = couName;
        this.stuName = stuName;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {

        return "courseName:"+getCouName()+",stuid:"+getStuId()+",name:"+getStuName()+",score:"+getGrade();
    }
}
