package mypack.service;

import mypack.Response.StudentInfo;
import mypack.pojo.Student;

public interface StuFileInfoService {

    boolean setStudentInfo(long id, String nationality, String nativePlace, String politicalStatus, int sex, String areaInterest, String title,String health,String enrollTime,String graduateTime,String birthday);
    StudentInfo getStudentInfo(long id);

}
