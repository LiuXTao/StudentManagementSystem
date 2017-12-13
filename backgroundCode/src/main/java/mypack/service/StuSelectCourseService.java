package mypack.service;

import mypack.Response.StudentDepartResponse;

public interface StuSelectCourseService {
    StudentDepartResponse getStudentDepart(long id);
    String getSelectCourse(int id,int type,int yuliang,long sid);
    boolean addCourseToStudent(String[] jsonArr);
}
