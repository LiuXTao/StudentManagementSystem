package mypack.Response;

import mypack.pojo.Course;

public class ScoreInfo extends Course{
    private float score;
    private int ranking;
    private float point;
    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public ScoreInfo() {
    }

    public ScoreInfo(float score, int ranking, float point,String depName) {
        this.score = score;
        this.ranking = ranking;
        this.point = point;
        this.depName=depName;
    }

    public ScoreInfo(long id, String name, int type, int credict, int totalTime, String learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int stuNumber, int quantity, int opening, float score, int ranking, float point, String depName) {
        super(id, name, type, credict, totalTime, learnTerm, learnYear, classroom, depID, timeSlotID, proID, admID, stuNumber, quantity, opening);
        this.score = score;
        this.ranking = ranking;
        this.point = point;
        this.depName = depName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    @Override
    public String toString() {
        String result="id:"+getId()+",cname:"+getName()+",ctype:"+getType()+",clscore:"+
                +getCredict()+",cltime:"+getTotalTime()+",cbelongto:"+getDepName()+",score:"+getScore()+
                ",point:"+getPoint()+",ranking:"+getRanking();
        return result;
    }
}
