package mypack.controller;

import mypack.Response.Data;
import mypack.Response.NoticeInfo;
import mypack.Response.ResponsdString;
import mypack.Response.TeacherInfo;
import mypack.pojo.Professor;
import mypack.pojo.Securitypro;
import mypack.pojo.Securitystu;
import mypack.service.*;
import mypack.serviceImpl.NotificationServiceImpl;
import mypack.serviceImpl.ProfessorAccountServiceImpl;
import mypack.serviceImpl.TeaFileInfoServiceImpl;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfessorController {
    @Autowired
    @Qualifier("ProfessorAccountServiceImpl")
    private ProfessorAccountServiceImpl professorAccountService;

    @Autowired
    @Qualifier("TeaFileInfoServiceImpl")
    private TeaFileInfoServiceImpl teaFileInfoService;

    @Autowired
    @Qualifier("ProChangePasswordServiceImpl")
    private ChangePasswordService proChangePasswordServiceImpl;

    @Autowired
    @Qualifier("ProChangeSecurityQuestionServiceImpl")
    private ChangeSecurityQuestionService proChangeSecurityQuestionServiceImpl;

    @Autowired
    @Qualifier("NotificationServiceImpl")
    private NotificationService notificationServiceImpl;

    @Autowired
    @Qualifier("ProClassTableQueryServiceImpl")
    private ClassTableQueryService proClassTableQueryServiceImpl;

    @Autowired
    @Qualifier("ProScoreRecordServiceImpl")
    private ProScoreRecordService proScoreRecordServiceImpl;


    @RequestMapping("/teacher/login")
    @ResponseBody
    public Data login(HttpServletRequest request) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        Data data = new Data();
        if (professorAccountService.login(Long.parseLong(id), password))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/teacher/fileInfo")
    @ResponseBody
    public TeacherInfo getProfessprInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println(id);
        TeacherInfo teacherInfo = teaFileInfoService.getProfessorInfo(Long.parseLong(id));
        System.out.println(teacherInfo);
        return teacherInfo;
    }

    @RequestMapping("/teacher/setInfo")
    @ResponseBody
    public Data setProfessorInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        String nationality = request.getParameter("nationality");
        int teachingAge = Integer.parseInt(request.getParameter("teachingAge"));
        String educationBackgroud = request.getParameter("educationBackground");
        String politicalStatus = request.getParameter("politicalStatus");
        String areaInterest = request.getParameter("areaInterest");

        System.out.print(id + "--->" + nationality);
        boolean result = teaFileInfoService.setProfessorInfo(Long.parseLong(id), nationality, teachingAge, educationBackgroud, areaInterest, politicalStatus);
        Data data = new Data();
        if (result == true)
            data.setData(1);
        else
            data.setData(0);
        return data;

    }

    @RequestMapping("/teacher/securityQuery")
    @ResponseBody
    public Securitypro getProfessorSecurity(HttpServletRequest request) {
        System.out.println("here");
        Long id = Long.parseLong(request.getParameter("id"));
        Securitypro securitypro = proChangeSecurityQuestionServiceImpl.securityQuestionQuery2(id);
        if (securitypro != null)
            return securitypro;
        return null;
    }

    @RequestMapping("/teacher/setPassword")
    @ResponseBody
    public Data setProfessorPassword(HttpServletRequest request) {
        System.out.println("进入");
        long id = Long.parseLong(request.getParameter("id"));
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        Data data = new Data();
        System.out.println(id + ">>>" + oldPass);
        boolean flag = proChangePasswordServiceImpl.checkOldPassword(id, oldPass);
        System.out.println(flag);
        if (!flag) {
            data.setData(0);
            return data;
        }
        System.out.println(newPass + "进入修改");
        proChangePasswordServiceImpl.changePassword(id, newPass);
        System.out.println("out");
        data.setData(1);
        return data;
    }

    @RequestMapping("/teacher/resetSecurity")
    @ResponseBody
    public Data resetSecurityPassword(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String queone = request.getParameter("queone");
        String quetwo = request.getParameter("quetwo");
        String quethree = request.getParameter("quethree");
        String ansone = request.getParameter("ansone");
        String anstwo = request.getParameter("anstwo");
        String ansthree = request.getParameter("ansthree");
        System.out.println(id + "->" + queone + "->" + quetwo + "->" + quethree + "->" + ansone + "->" + anstwo + "->" + ansthree);
        System.out.println("进入插入");
        proChangeSecurityQuestionServiceImpl.resetSecurityQuestion(id, queone, ansone, quetwo, anstwo, quethree, ansthree);
        System.out.println("结束插入");

        return new Data(1);
    }

    @RequestMapping("/teacher/checkAnswer")
    @ResponseBody
    public Data checkAnswer(HttpServletRequest request) {
        Data data = new Data();
        Long id = Long.parseLong(request.getParameter("id"));
        String queone = request.getParameter("question1");
        String quetwo = request.getParameter("question2");
        String quethree = request.getParameter("question3");
        String ansone = request.getParameter("answer1");
        String anstwo = request.getParameter("answer2");
        String ansthree = request.getParameter("answer3");
        System.out.println(id + "->" + queone + "->" + quetwo + "->" + quethree + "->" + ansone + "->" + anstwo + "->" + ansthree);
        boolean flag = proChangeSecurityQuestionServiceImpl.checkAnswer(id, queone, ansone, quetwo, anstwo, quethree, ansthree);
        System.out.println(flag);
        if (flag)
            data.setData(1);
        return data;
    }

    @RequestMapping("/teacher/notificationQuery")
    @ResponseBody
    public ResponsdString getNotification(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        System.out.println("进入");
        String notify = notificationServiceImpl.getNotification(id, 1);
        System.out.println("结束");
        ResponsdString notify1 = new ResponsdString(notify);
        return notify1;
    }

    @RequestMapping("/teacher/deleteNotification")
    @ResponseBody
    public Data delNotifications(HttpServletRequest request) {
        Data data = new Data();
        Long id = Long.parseLong(request.getParameter("id"));
        if (notificationServiceImpl.delNotification(id))
            data.setData(1);
        else data.setData(0);
        return data;
    }

    @RequestMapping("/teacher/ReadNotification")
    @ResponseBody
    public Data readNotifications(HttpServletRequest request) {
        Data data = new Data();
        System.out.println(1111);
        Long id = Long.parseLong(request.getParameter("id"));
        if (notificationServiceImpl.readedNotification(id))
            data.setData(1);
        else data.setData(0);
        System.out.println(2222);
        System.out.println(data.toString());
        return data;
    }

    @RequestMapping("/teacher/classtablequery")
    @ResponseBody
    public ResponsdString getClassTableQuery(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String learnYear = request.getParameter("selectYear");
        Integer learnTerm = Integer.parseInt(request.getParameter("selectMonth"));
        String result = proClassTableQueryServiceImpl.getProfessorClassTable(id, learnYear, learnTerm);
        ResponsdString responsdString = new ResponsdString(result);

        return responsdString;
    }

    @RequestMapping("/teacher/coursequery")
    @ResponseBody
    public ResponsdString courseQuery(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String learnYear = request.getParameter("selectYear");
        System.out.println(request);
        Integer learnTerm = Integer.parseInt(request.getParameter("selectTerm"));

        Integer courseType = 0;
        if (request.getParameter("selectType") != "") {
            System.out.println(22);
            courseType = Integer.parseInt(request.getParameter("selectType"));
        }
        String string=proScoreRecordServiceImpl.scoreQuery(id,learnYear,learnTerm,courseType);

        ResponsdString responsdString=new ResponsdString(string);
        return responsdString;
    }

    @RequestMapping("/teacher/singleScoreSign")
    @ResponseBody
    public Data singleScore(HttpServletRequest request){
        Data data=new Data();
        System.out.println("51");
        long cid=Long.parseLong(request.getParameter("couid"));
        String sid=request.getParameter("stuid");
        String score=request.getParameter("score");
        System.out.println("17");
        if(proScoreRecordServiceImpl.singleScore(cid,sid,score))
            data.setData(1);
        else
            data.setData(0);
        System.out.println("44");
        return data;
    }
    @RequestMapping("/teacher/getStudentTakes")
    @ResponseBody
    public ResponsdString getStudentTakes(HttpServletRequest request){
        Long id=Long.parseLong(request.getParameter("couID"));

        System.out.println("id1:"+id);
        String result=proScoreRecordServiceImpl.studentTake(id);
        System.out.println("id2:"+id);
        ResponsdString responsdString=new ResponsdString(result);
        return responsdString;
    }

    @RequestMapping("/teacher/batchregister")
    @ResponseBody
    public Data batchingRegister(HttpServletRequest request){
        String []jsonArr=request.getParameterValues("scoreBat[]");
        System.out.println(jsonArr.length);
        for(int i=0;i<jsonArr.length;i++){
            System.out.println(jsonArr[i]);
        }

        Data data=new Data();
        if(proScoreRecordServiceImpl.batchScoreRegister(jsonArr))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }
}

