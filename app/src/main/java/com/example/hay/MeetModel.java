package com.example.hay;

public class MeetModel {
    private int id ;
    private String CompanyName;
    private String comment;
    private String avtime;
    private String resch;
    private String auttNum;
    private String packedge;

    public MeetModel(int id, String companyName, String comment, String avtime, String resch, String auttNum, String packedge) {
        this.id = id;
        CompanyName = companyName;
        this.comment = comment;
        this.avtime = avtime;
        this.resch = resch;
        this.auttNum = auttNum;
        this.packedge = packedge;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getComment() {
        return comment;
    }

    public String getAvtime() {
        return avtime;
    }

    public String getResch() {
        return resch;
    }

    public String getAuttNum() {
        return auttNum;
    }

    public String getPackedge() {
        return packedge;
    }
}
