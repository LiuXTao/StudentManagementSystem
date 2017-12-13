package mypack.service;

public interface NotificationService {
    String getNotification(Long id,int flag);
    boolean delNotification(long id);
    boolean readedNotification(long id);
}
