package mypack.serviceImpl;

import mypack.dao.ProfessorMapper;
import mypack.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProChangePasswordServiceImpl")
public class ProChangePasswordServiceImpl implements ChangePasswordService{

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public void changePassword(Long id, String password) {
        System.out.println("endter"+id);

        professorMapper.changeProfessorPassword(id,password);
        System.out.println(password);
    }

    @Override
    public boolean checkOldPassword(Long id, String password) {
        if(professorMapper.checkProfessorPassword(id,password)!=null)
            return true;
        return false;
    }
}
