package mypack.dao;

import mypack.Response.TeacherInfo;
import mypack.pojo.Professor;
import mypack.pojo.Securitypro;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ProfessorMapper {
    @Select("select * from professor where id=#{id} and password=#{password}")
    Professor findWithIdAndPassword(@Param("id") long id, @Param("password") String password);

    @Select("SELECT professor.*,department.name as depName from professor,department WHERE professor.depID=department.id and professor.id=#{id}")
    TeacherInfo getProfessorInfo(@Param("id") long id);

    @Select("\n" +
            "UPDATE professor\n" +
            "set nationality=#{nationality},teachingAge=#{teachingAge},educationBackground=#{educationBackground},areaInterest=#{areaInterest} ,politicalStatus=#{politicalStatus} \n" +
            "where professor.id=#{id}")
    void setProfessorInfo(@Param("id") long id, @Param("nationality") String nationality, @Param("teachingAge") int teachingAge,
                          @Param("educationBackground") String educationBackground, @Param("areaInterest") String areaInterest,
                          @Param("politicalStatus") String politicalStatus);

    @Select("select * from professor where id=#{id} and password=#{password}")
    Professor checkProfessorPassword(@Param("id") long id, @Param("password") String password);

    @Select("UPDATE professor SET password=#{password} WHERE id=#{id}")
    void changeProfessorPassword(@Param("id")long id,@Param("password")String password);

    @Select("SELECT * from securitypro WHERE proID=#{id}")
    Securitypro securityQuestionQuery(@Param("id") long id);

    @Select("update securitypro\n" +
            "set queone=#{queone},quetwo=#{quetwo},quethree=#{quethree},ansone=#{ansone},anstwo=#{anstwo},ansthree=#{ansthree}" +
            "where proID=#{id}")
    void resetSecurityQuestion(@Param("id")long id,@Param("queone")String queone,@Param("quetwo")String quetwo,
                               @Param("quethree")String quethree,@Param("ansone")String ansone,
                               @Param("anstwo")String anstwo,@Param("ansthree")String ansthree);

    @Select("select * from securitypro where proID=#{id}")
    Securitypro checkAnswer(@Param("id")long id);
}
