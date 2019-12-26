package com.raviteja;

import java.util.*;

public class InMemoryTaskRepository implements TaskRepository{
    List<Task> taskList = new ArrayList<Task>();
    public void add(String name, String dis, Date due, Status st,String id) {
        taskList.add(new Task(name, dis, due,st,id));
    }

    @Override
    public void updateStatus(String status, String name, String id) {
        for (Task obj : taskList) {
            if (obj.name1.equals(name)&&obj.id1.equals(id))
                obj.st1=Status.valueOf(status);
        }
    }

    public List<Task> display()
    {
        return taskList;
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
        taskList.remove(obj);
    }
}
