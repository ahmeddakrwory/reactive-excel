package com.example.test.demo.test.searchmodels;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class FinanceSerch {
    private ArrayList<String> orgname;
    private LocalDateTime Fdate;
    private  LocalDateTime Tdate;

    public FinanceSerch() {
    }

    public FinanceSerch(ArrayList<String> orgname, LocalDateTime fdate, LocalDateTime tdate) {
        this.orgname = orgname;
        Fdate = fdate;
        Tdate = tdate;
    }

    public ArrayList<String> getOrgname() {
        return orgname;
    }

    public void setOrgname(ArrayList<String> orgname) {
        this.orgname = orgname;
    }

    public LocalDateTime getFdate() {
        return Fdate;
    }

    public void setFdate(LocalDateTime fdate) {
        Fdate = fdate;
    }

    public LocalDateTime getTdate() {
        return Tdate;
    }

    public void setTdate(LocalDateTime tdate) {
        Tdate = tdate;
    }
}
