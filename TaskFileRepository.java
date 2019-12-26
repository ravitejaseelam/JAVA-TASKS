package com.raviteja;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.*;


public class TaskFileRepository implements TaskRepository {
    List<Task> tasks = new ArrayList<Task>();
    private static final String TASKS_JSON_FILE ="/home/ravitejas/Desktop/tasks.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    File file = new File(TASKS_JSON_FILE);


    public TaskFileRepository() {
     // tasks=readFromFile();
    }

    private void writeToFile(List<Task> tasks) {
   //     objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE), tasks);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Task> readFromFile() {

     //   objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        if (file.exists()) {
            try {
                return objectMapper.readValue(file, TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Task> display() {
        return readFromFile();
    }

    @Override
    public List<Task> search(String n) {
        List<Task> nameSearchList = new ArrayList<Task>();

        for (Task obj : tasks) {
            if (obj.name1.equals(n))
                nameSearchList.add(obj);
        }
        return nameSearchList;
    }

    @Override
    public List<Task> searchStatus(String n) {
        List<Task> statusSerchList = new ArrayList<Task>();
        List<Task> taskList =readFromFile();
        for (Task obj : taskList) {
            if (obj.st1.equals(Status.valueOf(n)))
                statusSerchList.add(obj);
        }
        return statusSerchList;
    }

    @Override
    public void delete(Task obj) {
        tasks.remove(obj);
        writeToFile(tasks);

    }

    @Override
    public void add(String name, String dis, Date due, Status st,String id) {
        tasks=readFromFile();
        tasks.add(new Task(name, dis, due,st,id));
        writeToFile(tasks);

    }

    @Override
    public void updateStatus(String status,String name,String id) {
        for (Task obj : tasks) {
            if (obj.name1.equals(name)&&obj.id1.equals(id))
               obj.st1=Status.valueOf(status);
        }
        writeToFile(tasks);
    }
}