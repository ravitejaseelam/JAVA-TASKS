package com.raviteja;

import java.util.*;

public class TaskManager {
   //InMemoryTaskRepository repository=new InMemoryTaskRepository();
    TaskFileRepository repository =new TaskFileRepository();
    int id =0;

    public List<Task> display()
    {
        List<Task> taskList= repository.display();
        return taskList;
    }


    public void add( String name, String dis, Date due, Status st) {
        String id = UUID.randomUUID().toString();
        repository.add(name,dis,due,st,id);
    }

    public List<Task> search( String n) {
        List<Task> nameSearchList = repository.search(n);
            return nameSearchList;

    }
    public List<Task> searchStatus( String n) {
        List<Task> statusSerchList = repository.searchStatus(n);
            return statusSerchList;

    }

    public void delete( Task obj) {
        repository.delete(obj);
    }
    public void updateStatus(String status,String name ,String id ){
        repository.updateStatus(status,name,id);
    }
}

