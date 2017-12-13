package mypack.pojo;

import java.io.Serializable;

public class Department implements Serializable {
    private int id;
    private String name;
    private String building;
    private String contactInformation;

    public Department() {

    }

    public Department(int id, String name, String building, String contactInformation) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.contactInformation = contactInformation;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
