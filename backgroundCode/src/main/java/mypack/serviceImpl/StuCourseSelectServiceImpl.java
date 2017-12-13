package mypack.serviceImpl;

import mypack.Response.SelectCourseInfo;
import mypack.Response.StudentDepartResponse;
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
                if(studentMapper.checkSelectOrNot(cid,sid)==null)
                    selectCourseInfos.get(i).setSelected(0);
                else
                    selectCourseInfos.get(i).setSelected(1);
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
    public boolean addCourseToStudent(String[] jsonArr) {
        return false;
    }
}
