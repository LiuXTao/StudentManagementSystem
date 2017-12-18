package mypack.serviceImpl;

import mypack.Response.SelectCourseInfo;
import mypack.Response.StudentDepartResponse;
import mypack.dao.CourseMapper;
import mypack.dao.StudentMapper;
import mypack.service.StuSelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("StuCourseSelectServiceImpl")
public class StuCourseSelectServiceImpl implements StuSelectCourseService{

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public StudentDepartResponse getStudentDepart(long id) {
        StudentDepartResponse studentDepartResponse=studentMapper.getDepartId(id);
        if(studentDepartResponse!=null)
            return studentDepartResponse;
        return null;
    }

    @Override
    public String getSelectCourse(int id, int type,int yuliang,long sid) {
        System.out.println(1);
        List<SelectCourseInfo> selectCourseInfo=studentMapper.getSelectScourse(id,type);

       if(selectCourseInfo!=null){
           List<SelectCourseInfo> selectCourseInfos=new ArrayList<SelectCourseInfo>();
           if(yuliang==0){
               selectCourseInfos=selectCourseInfo;
           }else if(yuliang==1){
               for(int i=0;i<selectCourseInfo.size();i++){
                   if(selectCourseInfo.get(i).getNums()>0)
                       selectCourseInfos.add(selectCourseInfo.get(i));
               }
           }else{
               for(int i=0;i<selectCourseInfo.size();i++){
                   if(selectCourseInfo.get(i).getNums()<=0)
                       selectCourseInfos.add(selectCourseInfo.get(i));
               }
           }
            System.out.println(2);
            String result="";
            for(int i=0;i<selectCourseInfos.size();i++){
                long cid=selectCourseInfos.get(i).getId();
                courseMapper.updateStudentNums(cid);
                if(studentMapper.checkSelectOrNot(cid,sid,1)==null) {
                    selectCourseInfos.get(i).setSelected(0);
                    System.out.println(3);
                }
                else{
                    selectCourseInfos.get(i).setSelected(1);
                    System.out.println(4);
                }
                System.out.println( selectCourseInfos.get(i).getSelected());

                if(i==selectCourseInfos.size()-1)
                    result+=selectCourseInfos.get(i).toString();
                else{
                    result+=selectCourseInfos.get(i).toString()+";";
                }
            }
            System.out.println(result);
            return result;
        }

        return null;
    }

    @Override
    public boolean subStudentSelect(String[] jsonArr) {
        boolean flag=true;
        System.out.println(jsonArr.length);
        for(int i=0;i<jsonArr.length;i++){
            String temp=jsonArr[i].substring(1,jsonArr[i].length()-1);
            String []eles=temp.split(",");
            for(int j=0;j<eles.length;j++)
                System.out.println(eles[j].split(":")[1]);
            Long cid=Long.parseLong(eles[0].split(":")[1]);
            Long sid=Long.parseLong(eles[1].split(":")[1]);
            int select=Integer.parseInt(eles[2].split(":")[1]);
            System.out.println(cid);

            if(studentMapper.checkSelectOrNot(cid,sid,-1)==null){
                boolean result=courseMapper.submitCourses(cid,sid,select);
                if(result==false){
                    flag=false;
                    return flag;
                }
            }else{
                boolean result=courseMapper.updataSubmitCourse(cid,sid,select);
                if(result==false){
                    flag=false;
                    return flag;
                }
            }

                courseMapper.updateStudentNums(cid);

        }
        return true;
    }

    @Override
    public String getMyAllCourses(long id) {
        System.out.println(222);
        List<SelectCourseInfo>selectCourseInfos=courseMapper.getStuMyCourse(id);
        if(selectCourseInfos!=null){
            System.out.println(111);
            String result="";
            System.out.println(selectCourseInfos.size());
            for(int i=0;i<selectCourseInfos.size();i++){
                System.out.println(i);
                if(i==selectCourseInfos.size()-1)
                    result+=selectCourseInfos.get(i).toString();
                else {
                    result += selectCourseInfos.get(i).toString() + ";";
                }
            }
            System.out.println(result);
            return result;
        }
        return "";
    }
}
