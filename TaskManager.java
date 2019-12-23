package com.raviteja;

import java.util.*;

public class TaskManager {
    List<task> t2 = new ArrayList<task>();
public static void  add(List<task> t2,String name,String dis,Date due)
{
    t2.add(new task(name, dis, due));
}
    public static void  display(List<task> t2)
    {
        for (task obj : t2) {
            System.out.println("Name:"+obj.name1);
            System.out.println();
            System.out.println("Discription:"+obj.dis1);
            System.out.println();
            System.out.println("Due Date:"+obj.due1);
            System.out.println();
        }
    }
    public static void search(List<task> t2,String n)
    {
        int k=0;
        for (task obj : t2) {
            if (obj.name1.equals(n)) {
                System.out.println("Found");
                System.out.println("Name:"+obj.name1);
                System.out.println();
                System.out.println("Discription:"+obj.dis1);
                System.out.println();
                System.out.println("Date:"+obj.due1);
                System.out.println();
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Not Found");
            System.out.println();
        }
    }
    public static void delete(List<task> t2,String n)
    { int k=0;
        for (task obj : t2) {
            if (obj.name1.equals(n)) {
                System.out.println("Deleted");
                System.out.println("Name:");
                System.out.println(obj.name1);
                System.out.println("Discription:");
                System.out.println(obj.dis1);
                System.out.println("Due Date:");
                System.out.println(obj.due1);
                System.out.println();
                k++;
                t2.remove(obj);
            }
        }
        if (k == 0) {
            System.out.println("Not Found");
            System.out.println();
        }
    }


}
