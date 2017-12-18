package mypack.Response;

public class StudentDepartResponse {
    private long stuId;
    private int depId;

    public StudentDepartResponse() {
    }

    public StudentDepartResponse(long stuId, int depId) {
        this.stuId = stuId;
        this.depId = depId;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }
}
