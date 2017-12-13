package mypack.Response;


public class SelectCourseInfo extends CourseInfo{
    private int selected;

    public SelectCourseInfo() {

    }

    public SelectCourseInfo(long id, String name, int type, int credict, int totalTime, String learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int stuNumber, int quantity, int opening, String startWeek, String endWeek, String times, String teaName, String depName, int selected) {
        super(id, name, type, credict, totalTime, learnTerm, learnYear, classroom, depID, timeSlotID, proID, admID, stuNumber, quantity, opening, startWeek, endWeek, times, teaName, depName);
        this.selected = selected;
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
    @Override
    public String toString() {
        String parents=toAllString();
        System.out.println(parents);

        return parents+",num:"+getNums()+",selected:"+getSelected();
    }
}
