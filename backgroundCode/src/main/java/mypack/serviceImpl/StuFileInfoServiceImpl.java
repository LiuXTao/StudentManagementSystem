package mypack.serviceImpl;

import mypack.Response.StudentInfo;
import mypack.dao.StudentMapper;
import mypack.pojo.Student;
import mypack.service.StuFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StuFileInfoServiceImpl")
public class StuFileInfoServiceImpl implements StuFileInfoService{
    @Autowired
    private StudentMapper stuFileInfoMapper;
    @Override
    public boolean setStudentInfo(long id,String nationality,String nativePlace,String politicalStatus,String sex,String areaInterest,String title) {
        stuFileInfoMapper.setStudentInfo(id,nationality,nativePlace,politicalStatus,sex,areaInterest,title);
        return true;
    }

    @Override
    public StudentInfo getStudentInfo(long id) {
        StudentInfo student=stuFileInfoMapper.getStudentInfo(id);
        return student;
    }

}
