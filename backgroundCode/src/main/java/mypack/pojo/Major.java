package mypack.pojo;

import java.io.Serializable;

public class Major implements Serializable {
    private int id;
    private String name;
    private int depID;

    public Major() {
    }

    public Major(int id, String name, int depID) {
        this.id = id;
        this.name = name;
        this.depID = depID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
}
