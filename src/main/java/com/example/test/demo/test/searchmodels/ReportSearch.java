package com.example.test.demo.test.searchmodels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportSearch {
    private ArrayList<String> orgname;
    private LocalDateTime Fdate;
    private  LocalDateTime Tdate;

    public LocalDateTime getFdate() {
        return Fdate;
    }

    public void setFdate(LocalDateTime fdate) {
        Fdate = fdate;
    }


    public ReportSearch(ArrayList<String> orgname, LocalDateTime fdate, LocalDateTime tdate) {
        this.orgname = orgname;
        Fdate = fdate;
        Tdate = tdate;
    }

    public ReportSearch() {
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

    public LocalDateTime getTdate() {
        return Tdate;
    }

    public void setTdate(LocalDateTime tdate) {
        Tdate = tdate;
    }
}


