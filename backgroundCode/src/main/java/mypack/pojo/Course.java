package mypack.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private long id;
    private String name;
    private int type;
    private int credict;
    private int totalTime;
    private String learnTerm;
    private String learnYear;
    private String classroom;
    private int depID;
    private int timeSlotID;
    private long proID;
    private int admID;
    private int stuNumber;
    private int quantity;
    private int opening;

    public int getOpening() {
        return opening;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Course(long id, String name, int type, int credict, int totalTime, String learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int stuNumber, int quantity, int opening) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.credict = credict;
        this.totalTime = totalTime;
        this.learnTerm = learnTerm;
        this.learnYear = learnYear;
        this.classroom = classroom;
        this.depID = depID;
        this.timeSlotID = timeSlotID;
        this.proID = proID;
        this.admID = admID;
        this.stuNumber = stuNumber;
        this.quantity = quantity;
        this.opening = opening;
    }

    public Course() {
    }



    public int getCredict() {
        return credict;
    }

    public void setCredict(int credict) {
        this.credict = credict;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getLearnTerm() {
        return learnTerm;
    }

    public void setLearnTerm(String learnTerm) {
        this.learnTerm = learnTerm;
    }

    public String getLearnYear() {
        return learnYear;
    }

    public void setLearnYear(String learnYear) {
        this.learnYear = learnYear;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public void setTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public long getProID() {
        return proID;
    }

    public void setProID(long proID) {
        this.proID = proID;
    }

    public int getAdmID() {
        return admID;
    }

    public void setAdmID(int admID) {
        this.admID = admID;
    }
}
