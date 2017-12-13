package mypack.pojo;

import java.io.Serializable;

public class NoticePro implements Serializable {
    private long notID;
    private long proID;

    public NoticePro() {
    }

    public NoticePro(long notID, long proID) {
        this.notID = notID;
        this.proID = proID;
    }

    public long getNotID() {
        return notID;
    }

    public void setNotID(long notID) {
        this.notID = notID;
    }

    public long getProID() {
        return proID;
    }

    public void setProID(long proID) {
        this.proID = proID;
    }
}
