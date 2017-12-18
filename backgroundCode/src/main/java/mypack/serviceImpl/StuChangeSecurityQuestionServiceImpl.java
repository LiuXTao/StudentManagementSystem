package mypack.serviceImpl;

import mypack.dao.StudentMapper;
import mypack.pojo.Securitypro;
import mypack.pojo.Securitystu;
import mypack.service.ChangeSecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StuChangeSecurityQuestionServiceImpl")
public class StuChangeSecurityQuestionServiceImpl implements ChangeSecurityQuestionService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void resetSecurityQuestion(Long id, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
        System.out.println("开始设置密保");
        studentMapper.resetSecurityQuestion(id,question1,question2,question3,answer1,answer2,answer3);
        System.out.println("ending");
    }

    @Override
    public boolean checkAnswer(Long id, String question1, String answer1, String question2, String answer2, String question3, String answer3) {

        Securitystu securitystu=studentMapper.checkAnswer(id);
        if(securitystu.getQueone().equals(question1) &&securitystu.getAnsone().equals(answer1)&&
                securitystu.getQuetwo().equals(question2)&&securitystu.getAnstwo().equals(answer2)&&
                securitystu.getQuethree().equals(question3)&&securitystu.getAnsthree().equals(answer3)){
            return true;
        }
        return false;
    }

    @Override
    public Securitystu securityQuestionQuery(Long id) {
        Securitystu securitystu=studentMapper.securityQuestionQuery(id);
        return securitystu;
    }

    @Override
    public Securitypro securityQuestionQuery2(Long id) {
        return null;
    }
}
