package mypack.pojo;

import java.io.Serializable;

public class NoticeStu implements Serializable {
    private long notID;
    private long stuID;

    public NoticeStu() {
    }

    public NoticeStu(long notID, long stuID) {
        this.notID = notID;
        this.stuID = stuID;
    }

    public long getNotID() {

        return notID;
    }

    public void setNotID(long notID) {
        this.notID = notID;
    }

    public long getStuID() {
        return stuID;
    }

    public void setStuID(long stuID) {
        this.stuID = stuID;
    }
}
