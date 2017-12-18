package mypack.Response;


public class SelectCourseInfo extends CourseInfo{
    private int selected;
    private int completed;

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public SelectCourseInfo() {

    }

    public SelectCourseInfo(long id, String name, int type, int credict, int totalTime, String learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int stuNumber, int quantity, int opening, String startWeek, String endWeek, String times, String teaName, String depName, int selected, int completed) {
        super(id, name, type, credict, totalTime, learnTerm, learnYear, classroom, depID, timeSlotID, proID, admID, stuNumber, quantity, opening, startWeek, endWeek, times, teaName, depName);
        this.selected = selected;
        this.completed = completed;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getNums(){
        return getQuantity()-getStuNumber();
    }



    public String getYears(){
        String start=getLearnYear().substring(0,4);
        String end=getLearnYear().substring(4);
        return start+"-"+end;
    }
    @Override
    public String toString() {
        String parents=toAllString();
        System.out.println(parents);

        return parents+",num:"+getNums()+",selected:"+getSelected()+",completed:"+getCompleted()+",learnTerm:"+getLearnTerm()+",learnYear:"+getYears();
    }
}
