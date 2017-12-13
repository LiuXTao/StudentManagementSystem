package mypack.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {
    private long id;
    private String noticeContent;
    private Date time;
    private int admId;
    private int readed;
    public Notice() {
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public Notice(long id, String noticeContent, Date time, int admId,int readed) {

        this.id = id;
        this.noticeContent = noticeContent;
        this.time = time;
        this.admId = admId;
        this.readed=readed;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAdmId() {
        return admId;
    }

    public void setAdmId(int admId) {
        this.admId = admId;
    }


}
