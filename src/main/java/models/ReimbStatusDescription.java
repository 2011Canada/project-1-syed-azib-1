package models;

import java.util.ArrayList;

public class ReimbStatusDescription {int id;
    String desc;

    private static ArrayList<ReimbStatusDescription> reimbStatusDescriptions= new ArrayList<>();

    public ReimbStatusDescription(int id, String desc) {
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


    public static ArrayList<ReimbStatusDescription> getReimbStatusDescriptions() {
        return reimbStatusDescriptions;
    }

    public static void setReimbStatusDescriptions(ArrayList<ReimbStatusDescription> reimbStatusDescriptions) {
        ReimbStatusDescription.reimbStatusDescriptions = reimbStatusDescriptions;
    }

    public static void generateReimbStatusReferences() {
        reimbStatusDescriptions.add(new ReimbStatusDescription(1, "pending"));
        reimbStatusDescriptions.add(new ReimbStatusDescription(2, "approved"));
        reimbStatusDescriptions.add(new ReimbStatusDescription(3, "denied"));
    }
}