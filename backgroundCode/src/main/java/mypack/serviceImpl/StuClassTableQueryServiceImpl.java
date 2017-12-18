package mypack.serviceImpl;

import mypack.Response.CourseInfo;
import mypack.dao.CourseMapper;
import mypack.service.ClassTableQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StuClassTableQueryServiceImpl")
public class StuClassTableQueryServiceImpl implements ClassTableQueryService{

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String getStudentClassTable(long id, String learnYear, int learnTerm) {
        System.out.print("查课表");
        List<CourseInfo> courseInfos=courseMapper.getStudentClassTable(id,learnTerm,learnYear);
        System.out.print(courseInfos);
        String passValue="";
        for(int i=0;i<courseInfos.size();i++){
            String basic=courseInfos.get(i).toString();
            String[] times=courseInfos.get(i).getTimes().split(";");
            for(int j=0;j<times.length;j++) {
                if (j == times.length - 1 && i == courseInfos.size() - 1)
                    passValue += basic + ":" + times[j] ;
                else
                    passValue += basic + ":" + times[j] + ";";
            }
        }
        return passValue;

    }

    @Override
    public String getProfessorClassTable(long id, String learnYear, int learnTerm) {
        return null;
    }
}
