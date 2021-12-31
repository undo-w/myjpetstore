package org.csu.mypetstore.domain;

import java.util.Date;

public class Daily {
    private int dailyid;
    private String userid;
    private Date date;
    private String operationtype;

    public int getDailyid() {
        return dailyid;
    }

    public void setDailyid(int dailyid) {
        this.dailyid = dailyid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }


}
