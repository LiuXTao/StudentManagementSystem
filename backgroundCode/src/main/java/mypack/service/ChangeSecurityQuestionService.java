package mypack.service;

import mypack.pojo.Securitypro;
import mypack.pojo.Securitystu;

public interface ChangeSecurityQuestionService {
    boolean checkAnswer(Long id,String question1,String answer1,String question2,String answer2,String question3,String answer3);
    void resetSecurityQuestion(Long id,String question1,String answer1,String question2,String answer2,String question3,String answer3);
    Securitystu securityQuestionQuery(Long id);
    Securitypro securityQuestionQuery2(Long id);

}
