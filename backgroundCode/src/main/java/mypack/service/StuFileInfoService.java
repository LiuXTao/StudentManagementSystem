package mypack.service;

import mypack.Response.StudentInfo;
import mypack.pojo.Student;

public interface StuFileInfoService {

    boolean setStudentInfo(long id, String nationality, String nativePlace, String politicalStatus, String sex, String areaInterest, String title);
    StudentInfo getStudentInfo(long id);

}
