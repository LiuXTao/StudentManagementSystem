package mypack.serviceImpl;

import mypack.dao.StudentMapper;
import mypack.pojo.Student;
import mypack.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentAccountServiceImpl")
public class StudentAccountServiceImpl implements AccountService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean login(long id, String password) {
        if(studentMapper.findWithIdAndPassword(id, password) == null) {
            System.out.println('f');
            return false;
        }
        return true;
    }
}
