package mypack.serviceImpl;

import mypack.Response.NoticeInfo;
import mypack.dao.NoticeMapper;
import mypack.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NotificationServiceImpl")
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public String getNotification(Long id, int flag) {
        List<NoticeInfo>notices;
        System.out.println("想得到结果");
        if(flag==1) {
            notices=noticeMapper.getProNotificationList(id);
        }else{
            notices=noticeMapper.getStuNotificationList(id);
        }
        String notifiListString="";
        System.out.println("结果呢");
        System.out.println(notices);
        if(notices!=null) {
            for(int i=0;i<notices.size();i++){
                if(i==notices.size()-1)
                    notifiListString=notifiListString+notices.get(i).toString();
                else
                    notifiListString=notifiListString+notices.get(i).toString()+";";
            }
            System.out.println(notifiListString);

        }
        return notifiListString;
    }

    @Override
    public boolean delNotification(long id) {
        System.out.println(id);
        noticeMapper.deleNotification(id);
        System.out.println(123);
        return true;
    }

    @Override
    public boolean readedNotification(long id) {
        System.out.println(4554);
        noticeMapper.readNotification(id);
        System.out.println(id);
        return true;
    }
}
