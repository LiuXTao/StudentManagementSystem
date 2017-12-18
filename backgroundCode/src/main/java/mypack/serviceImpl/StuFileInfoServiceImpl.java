package mypack.serviceImpl;

import mypack.Response.StudentInfo;
import mypack.dao.StudentMapper;
import mypack.pojo.Student;
import mypack.service.StuFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

@Service("StuFileInfoServiceImpl")
public class StuFileInfoServiceImpl implements StuFileInfoService{
    @Autowired
    private StudentMapper stuFileInfoMapper;

    @Override
    public boolean setStudentInfo(long id, String nationality, String nativePlace, String politicalStatus,int sex, String areaInterest, String title, String health, String enrollTime, String graduateTime, String birthday) {
        System.out.println(enrollTime);
        System.out.println(graduateTime);
        System.out.println(birthday);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        java.util.Date a=null;
        java.util.Date c=null;

        try {
            d = format.parse(enrollTime);
            a=format.parse(graduateTime);
            c=format.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date enroll = new java.sql.Date(d.getTime());
        java.sql.Date graduate = new java.sql.Date(a.getTime());
        java.sql.Date birth = new java.sql.Date(c.getTime());

//        StringTokenizer et  =  new  StringTokenizer(enrollTime, "-");
//        java.sql.Date enroll=new  java.sql.Date(Integer.parseInt(et.nextToken()));
//        StringTokenizer gt  =  new  StringTokenizer(graduateTime, "-");
//        java.sql.Date graduate=new  java.sql.Date(Integer.parseInt(gt.nextToken()));
//        StringTokenizer bt  =  new  StringTokenizer(birthday, "-");
//        java.sql.Date birth=new  java.sql.Date(Integer.parseInt(bt.nextToken()));
        System.out.println(enroll+">"+graduate+">"+birth);

        return stuFileInfoMapper.setStudentInfo(id,nationality,nativePlace,politicalStatus,sex,areaInterest,title,health,enroll,graduate,birth);

    }

    @Override
    public StudentInfo getStudentInfo(long id) {
        System.out.println("123");
        StudentInfo student=stuFileInfoMapper.getStudentInfo(id);
        student.setStringbirthDay(student.getBirthday().toString());
        student.setStringtimeEnrollment(student.getTimeEnrollment().toString());
        student.setStringtimeGraducation(student.getTimeGraduation().toString());
        System.out.println(student.getStringbirthDay());
        return student;
    }

}
