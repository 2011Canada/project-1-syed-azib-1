package models;

import java.util.ArrayList;

public class UserTypeDesc {
    private int id;
    private String desc;

    private static ArrayList<UserTypeDesc> userTypeDescriptions= new ArrayList<>();

    public UserTypeDesc(int id, String desc) {
        super();
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static ArrayList<UserTypeDesc> getUserTypeDescriptions() {
        return userTypeDescriptions;
    }

    public static void setUserTypeDescriptions(ArrayList<UserTypeDesc> userTypeDescriptions) {
        UserTypeDesc.userTypeDescriptions = userTypeDescriptions;
    }

    public static void generateUserTypeReferences() {
        userTypeDescriptions.add(new UserTypeDesc(1, "FinanceMgr"));
        userTypeDescriptions.add(new UserTypeDesc(2, "Employee"));
    }
}
