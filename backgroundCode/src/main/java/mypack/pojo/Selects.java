package mypack.pojo;

public class Selects {
    private long couId;
    private long stuId;
    private int selected;

    public Selects() {
    }

    public Selects(long couId, long stuId, int selected) {
        this.couId = couId;
        this.stuId = stuId;
        this.selected = selected;
    }

    public long getCouId() {
        return couId;
    }

    public void setCouId(long couId) {
        this.couId = couId;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
