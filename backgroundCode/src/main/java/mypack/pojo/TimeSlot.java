package mypack.pojo;

import java.io.Serializable;
import java.sql.Time;

public class TimeSlot implements Serializable {
    private int id;
    private String startWeek;
    private String endWeek;
    private String times;

    public TimeSlot(int id, String startWeek, String endWeek, String times) {
        this.id = id;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.times = times;
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

    public TimeSlot() {
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
