package mypack.service;

public interface ChangePasswordService {
    boolean checkOldPassword(Long id,String password);
    void changePassword(Long id,String password);

}
