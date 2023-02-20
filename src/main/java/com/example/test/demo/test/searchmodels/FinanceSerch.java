package com.example.test.demo.test.searchmodels;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class FinanceSerch {
    private String id;
    private String Fdate;
    private  String Tdate;
private String branchId;
    public FinanceSerch() {
    }

    public FinanceSerch(String id, String fdate, String tdate, String branchId) {
        this.id = id;
        this. Fdate = fdate;
        this.Tdate = tdate;
        this.branchId = branchId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFdate() {
        return Fdate;
    }

    public void setFdate(String fdate) {
        Fdate = fdate;
    }

    public String getTdate() {
        return Tdate;
    }

    public void setTdate(String tdate) {
        Tdate = tdate;
    }

    public String getBranchId() {
        return branchId;
    }
}
