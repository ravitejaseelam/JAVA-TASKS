package com.raviteja;
import java.util.Date;

public class Task {
    String name1, dis1, id1;
    Date dat1, due1;
    Status st1;


    public Task() {
    }
    public Task(String name, String dis, Date dat, Status st, String id, Date dueDate) {

        this.name1 = name;
        this.dis1 = dis;
        this.dat1 = dat;
        this.st1 = st;
        this.id1 = id;
        this.due1 = dueDate;

    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDis1() {
        return dis1;
    }

    public void setDis1(String dis1) {
        this.dis1 = dis1;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public Date getDat1() {
        return dat1;
    }

    public void setDat1(Date dat1) {
        this.dat1 = dat1;
    }

    public Date getDue1() {
        return due1;
    }

    public void setDue1(Date due1) {
        this.due1 = due1;
    }

    public Status getSt1() {
        return st1;
    }

    public void setSt1(Status st1) {
        this.st1 = st1;
    }


}