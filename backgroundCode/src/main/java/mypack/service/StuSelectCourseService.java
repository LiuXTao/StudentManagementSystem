package mypack.service;

import mypack.Response.StudentDepartResponse;

public interface StuSelectCourseService {
    StudentDepartResponse getStudentDepart(long id);
    String getSelectCourse(int id,int type,int yuliang,long sid);
    boolean subStudentSelect(String[] jsonArr);

    String getMyAllCourses(long id);

}
