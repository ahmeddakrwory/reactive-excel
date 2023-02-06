package com.example.test.demo.test.searchmodels;

import java.util.Date;

public class ReportSearch {
    private String orgname;
    private Date Fdate;
    private  Date Tdate;

    public Date getFdate() {
        return Fdate;
    }

    public void setFdate(Date fdate) {
        Fdate = fdate;
    }

    public ReportSearch(String orgname, Date tdate) {
        this.orgname = orgname;
        Tdate = tdate;
    }

    public Date getTdate() {
        return Tdate;
    }

    public void setTdate(Date tdate) {
        Tdate = tdate;
    }

    public ReportSearch() {
    }

    public ReportSearch(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
}


