package mypack.service;

import mypack.Response.TeacherInfo;

public interface TeaFileInfoService {
//    boolean setProfessorInfo(long id,String nationality,String nativePlace,String politicalStatus,String sex,String areaInterest,String title);
    boolean setProfessorInfo(long id, String nationality, int teachingAge, String educationBackgroud, String areaInterest, String politicalStatus,int sex,String title,String contact,String birthday);
    TeacherInfo getProfessorInfo(long id);

}
