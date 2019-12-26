package com.raviteja;

import java.util.*;

public interface TaskRepository {
    public List<Task> display();
    public List<Task> search( String n);
    public List<Task> searchStatus( String n);
    public void delete( Task obj);
    public void add(String name, String dis, Date due, Status st,String id);
    public void updateStatus(String status,String name,String id);
}
