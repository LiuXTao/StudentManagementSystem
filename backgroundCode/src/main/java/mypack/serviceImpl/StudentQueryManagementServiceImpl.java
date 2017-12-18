package mypack.serviceImpl;

import mypack.Response.CourseInfo;
import mypack.Response.ScoreInfo;
import mypack.dao.CourseMapper;
import mypack.dao.TakesMapper;
import mypack.service.StuQueryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("StudentQueryManagementServiceImpl")
public class StudentQueryManagementServiceImpl implements StuQueryManagementService{
    @Autowired
    private TakesMapper takesMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String scoreQuery(long id, String learnYear, int learnTerms, int courseType) {
        System.out.println("想得到结果");
        List<ScoreInfo> scoreInfos=takesMapper.getScoreList(id,learnYear,learnTerms,courseType);
        System.out.println(scoreInfos);
        String result="";
        if(scoreInfos!=null){
            System.out.println("进来了");
            for(int i=0;i<scoreInfos.size();i++){
                if(i==scoreInfos.size()-1)
                    result+=scoreInfos.get(i).toString();
                else
                    result+=scoreInfos.get(i).toString()+";";
            }
        }
        System.out.println("结果");
        return result;
    }

    @Override
    public String courseQuery(long id, String searchWays, String searchKeyWords) {
        Integer ways=Integer.parseInt(searchWays);
        switch(ways){
            case 1:
                return searchByID(searchKeyWords);

            case 2:
                return searchByName(searchKeyWords);

            case 3:
                return searchByDepart(searchKeyWords);

            case 4:
                return searchByProName(searchKeyWords);

            case 5:
                return seachByType(searchKeyWords);

        }
        return null;
    }
    private int courseType(String keyWords){
        if(keyWords.indexOf("必修")!=-1)
            return 1;
        if(keyWords.indexOf("选修")!=-1)
            return 2;
        if(keyWords.indexOf("通选")!=-1)
            return 3;
        return 0;
    }
    private String seachByType(String keyWords){
        int key=courseType(keyWords);
        if(key==0)
            return "";
        else{
            List<CourseInfo> courseInfos=courseMapper.courseQuerybyType(key);
            System.out.println(courseInfos);
            String result="";
            if(courseInfos!=null){
                result=getListContent(courseInfos);
            }
            System.out.println("结果");
            return result;
        }

    }
    private String searchByProName(String keyWords){
        List<CourseInfo> courseInfos=courseMapper.courseQuerybyProfessor(keyWords);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            result=getListContent(courseInfos);
        }
        System.out.println("结果");
        return result;
    }

    private String searchByDepart(String keyWords){
        List<CourseInfo> courseInfos=courseMapper.courseQuerybyDepart(keyWords);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            result=getListContent(courseInfos);
        }
        System.out.println("结果");
        return result;
    }
    private String searchByID(String keyWords){
        if(!isNumeric(keyWords))
            return "error IDs";
        Long id=Long.parseLong(keyWords);
        List<CourseInfo> courseInfos=courseMapper.courseQuerybyID(id);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            result=getListContent(courseInfos);
        }
        System.out.println("结果");
        return result;
    }
    private String searchByName(String keyWords){
        List<CourseInfo> courseInfos=courseMapper.courseQuerybyName(keyWords);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            result=getListContent(courseInfos);
        }
        System.out.println("结果");
        return result;
    }

    private String getListContent(List<CourseInfo> courseInfos){
        String result="";
        System.out.println("进来了");
        for(int i=0;i<courseInfos.size();i++){
            if(i==courseInfos.size()-1)
                result+=courseInfos.get(i).toAllString();
            else
                result+=courseInfos.get(i).toAllString()+";";
        }
        System.out.println(result);
        return result;
    }

    private boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
