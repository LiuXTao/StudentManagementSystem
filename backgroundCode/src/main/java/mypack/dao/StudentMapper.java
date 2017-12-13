package mypack.dao;

import mypack.Response.SelectCourseInfo;
import mypack.Response.StudentDepartResponse;
import mypack.Response.StudentInfo;
import mypack.pojo.Securitystu;
import mypack.pojo.Selects;
import mypack.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface StudentMapper {
    @Select("select * from student where id=#{id} and password=#{password}")
    Student findWithIdAndPassword(@Param("id") long id, @Param("password") String password);

    @Select("\n" +
            "select student.*,major.name as majName,department.name as depName,clazz.name as claName from student,major,department,clazz where student.majID=major.id and student.claID =clazz.id and major.depID=department.id and student.id=#{id}")
    StudentInfo getStudentInfo(@Param("id") long id);

    @Select("UPDATE student set areaInterest=#{areaInterest},nationality=#{nationality},nativePlace=#{nativePlace},politicalStatus=#{politicalStatus},sex=#{sex},title=#{title} where student.id=#{id}")
    void setStudentInfo(@Param("id") long id, @Param("nationality") String nationality, @Param("nativePlace") String nativePlace,
                        @Param("politicalStatus") String politicalStatus, @Param("sex") String sex,
                        @Param("areaInterest") String areaInterest, @Param("title") String title
    );

    @Select("select * from student where id=#{id} and password=#{password}")
    Student checkStudentPassword(@Param("id") long id, @Param("password") String password);

    @Select("UPDATE student SET password=#{password} WHERE id=#{id}")
    void changeStudentPassword(@Param("id")long id,@Param("password")String password);

    @Select("update securitystu\n" +
            "set queone=#{queone},quetwo=#{quetwo},quethree=#{quethree},ansone=#{ansone},anstwo=#{anstwo},ansthree=#{ansthree}" +
            "where stuID=#{id}")
    void resetSecurityQuestion(@Param("id")long id,@Param("queone")String queone,@Param("quetwo")String quetwo,
                               @Param("quethree")String quethree,@Param("ansone")String ansone,
                               @Param("anstwo")String anstwo,@Param("ansthree")String ansthree);

    @Select("SELECT * from securitystu WHERE stuID=#{id}")
    Securitystu securityQuestionQuery(@Param("id")long id);

    @Select("select * from securitystu where stuID=#{id}")
    Securitystu checkAnswer(@Param("id")long id);

    @Select("SELECT student.id as stuId,major.depID as depId\n" +
            "from student,major\n" +
            "where student.id=#{id} and student.majID=major.id")
    StudentDepartResponse getDepartId(@Param("id") long id);



    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "WHERE course.timeSlotID=timeslot.id and course.depID=department.id and course.proID=professor.id and course.opening=1 and course.type=#{type} and course.depID=#{id}")
    ArrayList<SelectCourseInfo> getSelectScourse(@Param("id")int id,@Param("type")int type);

    @Select("select *\n" +
            "from selects\n" +
            "where selects.couId=#{couId} and selects.stuId=#{stuId}")
    Selects checkSelectOrNot(@Param("couId")long id,@Param("stuId")long stuId);


}