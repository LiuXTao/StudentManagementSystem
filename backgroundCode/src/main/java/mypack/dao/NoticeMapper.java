package mypack.dao;

import mypack.Response.NoticeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface NoticeMapper {

    @Select("select notice.*,administor.name as author\n" +
            "from noticepro,notice,administor\n" +
            "where noticepro.notID=notice.id and notice.admID=administor.id and noticepro.proID=#{id}")
    ArrayList<NoticeInfo> getProNotificationList(@Param("id")Long id);

    @Select("select notice.*,administor.name as author\n"+
            "from noticestu,notice,administor\n"+
            "where noticestu.notID=notice.id and notice.admID=administor.id and noticestu.stuID=#{id}")
    ArrayList<NoticeInfo> getStuNotificationList(@Param("id")Long id);

    @Select("update notice set notice.readed=1 where notice.id=#{id}")
    void readNotification(@Param("id")long id);

    @Select("delete from notice where notice.id=#{id}")
    void deleNotification(@Param("id")long id);


}
