package mypack.serviceImpl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import mypack.Response.CourseInfo;
import mypack.Response.ScoreInfo;
import mypack.Response.TakesInfo;
import mypack.dao.CourseMapper;
import mypack.dao.TakesMapper;
import mypack.service.ProScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("ProScoreRecordServiceImpl")
public class ProScoreRecordServiceImpl implements ProScoreRecordService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TakesMapper takesMapper;
    @Override
    public String scoreQuery(long id, String year, int term, int type) {
        System.out.println("想得到结果");
        List<CourseInfo> courseInfos=courseMapper.procoursequery(id,year,term,type);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            System.out.println("进来了");
            for(int i=0;i<courseInfos.size();i++){
                if(i==courseInfos.size()-1)
                    result+=courseInfos.get(i).toAllString();
                else
                    result+=courseInfos.get(i).toAllString()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public boolean singleScore(long cid, String sid, String score) {
        Long id;
        System.out.println("11");
        float grade=0;
        if(isNumeric(sid))
            id=Long.parseLong(sid);
        else
            return false;
        grade=Float.parseFloat(score);
        System.out.println("21");
        takesMapper.updateSingleScore(cid,id,grade);
        System.out.println("15");
        return true;

    }

    @Override
    public Boolean batchScoreRegister(String[] jsonArr) {
        Long []cid=new Long[jsonArr.length];
        Long []sid=new Long[jsonArr.length];
        Float []grade=new Float[jsonArr.length];
        boolean flag=true;
        for(int i=0;i<jsonArr.length;i++){
            System.out.println(jsonArr[i]);

            String temp=jsonArr[i].substring(1,jsonArr[i].length()-1);
            String []eles=temp.split(",");
            for(int j=0;j<eles.length;j++)
                System.out.println(eles[j].split(":")[1]);
            cid[i]=Long.parseLong(eles[0].split(":")[1]);
            sid[i]=Long.parseLong(eles[1].split(":")[1]);
            String temp2=eles[2].split(":")[1];

            if(!isNumeric(temp2)) {
                flag = false;
                break;
            }
            grade[i]=Float.parseFloat(temp2);
        }
        if(!flag) return false;
        for(int i=0;i<jsonArr.length;i++){
            System.out.println(grade[i]);
            takesMapper.updateSingleScore(cid[i],sid[i],grade[i]);
            System.out.println(cid[i]);

        }


        return true;

    }

    @Override
    public String studentTake(long id) {
        System.out.println("进来了1");
        List<TakesInfo> takesInfos =takesMapper.getCourseStudent(id);
        System.out.println(takesInfos);
        if(takesInfos!=null){
            System.out.println("进来了2");
            String result="";
            for(int i=0;i<takesInfos.size();i++){
                if(i!=takesInfos.size()-1)
                    result+=takesInfos.get(i).toString()+";";
                else
                    result+=takesInfos.get(i).toString();
            }
            System.out.println(result);
            return result;
        }
        return "";
    }

    private boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
