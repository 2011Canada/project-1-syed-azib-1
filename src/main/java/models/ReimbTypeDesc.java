package models;

import java.util.ArrayList;

public class ReimbTypeDesc {int id;
    String desc;

    private static ArrayList<ReimbTypeDesc> reimbTypeDescriptions= new ArrayList<>();

    public ReimbTypeDesc(int id, String desc) {
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

    public static ArrayList<ReimbTypeDesc> getReimbTypeDescriptions() {
        return reimbTypeDescriptions;
    }

    public static void setReimbTypeDescriptions(ArrayList<ReimbTypeDesc> reimbTypeDescriptions) {
        ReimbTypeDesc.reimbTypeDescriptions = reimbTypeDescriptions;
    }

    public static void generateReimbTypeReferences() {
        reimbTypeDescriptions.add(new ReimbTypeDesc(1, "lodging"));
        reimbTypeDescriptions.add(new ReimbTypeDesc(2, "travel"));
        reimbTypeDescriptions.add(new ReimbTypeDesc(3, "food"));
        reimbTypeDescriptions.add(new ReimbTypeDesc(4, "other"));
    }
}