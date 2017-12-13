package mypack.pojo;

public class Securitystu {
    private long id;
    private long stuID;
    private String queone;
    private String quetwo;
    private String quethree;
    private String ansone;
    private String anstwo;
    private String ansthree;

    public Securitystu() {
    }

    public Securitystu(long id, long stuID, String queone, String quetwo, String quethree, String ansone, String anstwo, String ansthree) {
        this.id = id;
        this.stuID = stuID;
        this.queone = queone;
        this.quetwo = quetwo;
        this.quethree = quethree;
        this.ansone = ansone;
        this.anstwo = anstwo;
        this.ansthree = ansthree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStuID() {
        return stuID;
    }

    public void setStuID(long stuID) {
        this.stuID = stuID;
    }

    public String getQueone() {
        return queone;
    }

    public void setQueone(String queone) {
        this.queone = queone;
    }

    public String getQuetwo() {
        return quetwo;
    }

    public void setQuetwo(String quetwo) {
        this.quetwo = quetwo;
    }

    public String getQuethree() {
        return quethree;
    }

    public void setQuethree(String quethree) {
        this.quethree = quethree;
    }

    public String getAnsone() {
        return ansone;
    }

    public void setAnsone(String ansone) {
        this.ansone = ansone;
    }

    public String getAnstwo() {
        return anstwo;
    }

    public void setAnstwo(String anstwo) {
        this.anstwo = anstwo;
    }

    public String getAnsthree() {
        return ansthree;
    }

    public void setAnsthree(String ansthree) {
        this.ansthree = ansthree;
    }
}
