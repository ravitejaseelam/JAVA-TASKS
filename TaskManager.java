package com.raviteja;

import java.util.*;

public class TaskManager {
    int id = 0;
    List<Task> t2 = new ArrayList<Task>();
    List<Task> t1 = new ArrayList<Task>();

    public int idAllocate(List<Task> t2, String name, String dis, Date due, Status st) {
        id++;
        return id;
    }

    public List<Task> search(List<Task> t2, String n) {
        int flag = 0;
        for (Task obj : t2) {
            if (obj.name1.equals(n))
                t1.add(obj);
            flag++;
        }
        if (flag == 0)
            return null;
        else
            return t1;

    }
    public List<Task> searchStatus(List<Task> t2, String n) {
        int flag = 0;
        for (Task obj : t2) {
            if (obj.st1.equals(Status.valueOf(n)))
                t1.add(obj);
            flag++;
        }
        if (flag == 0)
            return null;
        else
            return t1;

    }

    public List<Task> delete(List<Task> t2, Task obj) {
        t2.remove(obj);
        return t2;
    }
}

