package com.raviteja;

import java.util.*;

public class TaskManager {
    int id = 0;
    List<Task> taskList = new ArrayList<Task>();

    public List<Task> display()
    {
        return taskList;
    }

    public int add( String name, String dis, Date due, Status st) {
        id++;
        taskList.add(new Task(name, dis, due,st,id));
        return id;
    }

    public List<Task> search( String n) {
        List<Task> nameSearchList = new ArrayList<Task>();
        for (Task obj : taskList) {
            if (obj.name1.equals(n))
                nameSearchList.add(obj);
        }
            return nameSearchList;

    }
    public List<Task> searchStatus( String n) {
        List<Task> statusSerchList = new ArrayList<Task>();
        for (Task obj : taskList) {
            if (obj.st1.equals(Status.valueOf(n)))
                statusSerchList.add(obj);
        }
            return statusSerchList;

    }

    public void delete( Task obj) {
        List<Task> deletedList = new ArrayList<Task>();
        deletedList.clear();
        taskList.remove(obj);
    }
}

