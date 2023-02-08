package com.example.test.demo.test.searchmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportSearch {
    private ArrayList<String> orgname;
    private Date Fdate;
    private  Date Tdate;

    public Date getFdate() {
        return Fdate;
    }

    public void setFdate(Date fdate) {
        Fdate = fdate;
    }


    public ReportSearch(ArrayList<String> orgname, Date fdate, Date tdate) {
        this.orgname = orgname;
        Fdate = fdate;
        Tdate = tdate;
    }

    public ArrayList<String> getOrgname() {
        return orgname;
    }

    public ReportSearch(ArrayList<String> orgname) {
        this.orgname = orgname;
    }

    public void setOrgname(ArrayList<String> orgname) {
        this.orgname = orgname;
    }

    public Date getTdate() {
        return Tdate;
    }

    public void setTdate(Date tdate) {
        Tdate = tdate;
    }
}


