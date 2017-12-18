package mypack.serviceImpl;

import mypack.Response.TeacherInfo;
import mypack.dao.ProfessorMapper;
import mypack.service.TeaFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service("TeaFileInfoServiceImpl")
public class TeaFileInfoServiceImpl implements TeaFileInfoService {

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public TeacherInfo getProfessorInfo(long id) {
        System.out.println("123");
        System.out.println(id);
       TeacherInfo teacherInfo= professorMapper.getProfessorInfo(id);
       System.out.println("over");
       teacherInfo.setStringBirthday(teacherInfo.getBirthday().toString());
       System.out.println(teacherInfo.getStringBirthday());
        return teacherInfo;
    }

    //, String nativePlace, String politicalStatus, String sex, String areaInterest, String title)
    @Override
    public boolean setProfessorInfo(long id, String nationality, int teachingAge, String educationBackgroud, String areaInterest, String politicalStatus, int sex, String title, String contact, String birthday) {
        System.out.println(birthday);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;

        try {
            d =format.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date birth = new java.sql.Date(d.getTime());
        System.out.println(">"+birth);

        boolean result=professorMapper.setProfessorInfo(id,nationality,teachingAge,educationBackgroud,areaInterest,politicalStatus,sex,title,contact,birth);
        System.out.println("completed!");
        return result;
    }
}
