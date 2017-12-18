package mypack.serviceImpl;

import mypack.dao.ProfessorMapper;
import mypack.pojo.Professor;
import mypack.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProfessorAccountServiceImpl")
public class ProfessorAccountServiceImpl implements AccountService {

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public boolean login(long id, String password) {
        if(professorMapper.findWithIdAndPassword(id, password) == null) {
            return false;
        }
        return true;
    }
}
