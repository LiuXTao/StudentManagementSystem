package mypack.serviceImpl;

import mypack.Response.TeacherInfo;
import mypack.dao.ProfessorMapper;
import mypack.service.TeaFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeaFileInfoServiceImpl")
public class TeaFileInfoServiceImpl implements TeaFileInfoService {

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public TeacherInfo getProfessorInfo(long id) {
       TeacherInfo teacherInfo= professorMapper.getProfessorInfo(id);
       System.out.println(teacherInfo.toString());
        return teacherInfo;
    }

    //, String nativePlace, String politicalStatus, String sex, String areaInterest, String title)
    @Override
    public boolean setProfessorInfo(long id, String nationality,int teachingAge,String educationBackgroud,String areaInterest,String politicalStatus){

        professorMapper.setProfessorInfo(id,nationality,teachingAge,educationBackgroud,areaInterest,politicalStatus);
        System.out.println("completed!");
        return true;
    }
}
