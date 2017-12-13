package mypack.serviceImpl;

import mypack.dao.StudentMapper;
import mypack.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StuChangePasswordServiceImpl")
public class StuChangePasswordServiceImpl implements ChangePasswordService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean checkOldPassword(Long id, String password) {
        if(studentMapper.checkStudentPassword(id,password)!=null)
            return true;
        return false;
    }

    @Override
    public void changePassword(Long id, String password) {
        System.out.println("endter"+id);

        studentMapper.changeStudentPassword(id,password);
        System.out.println(password);
    }
}
