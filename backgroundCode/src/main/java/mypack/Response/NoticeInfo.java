package mypack.Response;

import mypack.pojo.Notice;

import java.sql.Array;
import java.sql.Date;

public class NoticeInfo extends Notice{
    private String author;

    public NoticeInfo(String author) {
        this.author = author;
    }

    public NoticeInfo(long id, String noticeContent, Date time, int admId, int readed, String author) {
        super(id, noticeContent, time, admId, readed);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        String result="id:"+getId()+",noticeContent:"+getNoticeContent()+",time:"+getTime()+",readed:"+
                getReaded()+",author:"+getAuthor();
        return result;
    }
}
