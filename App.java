package com.raviteja;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    public static void main(String[] args) throws ParseException, SQLException {
      TaskManager tm =new TaskManager();
        while (true) {
            System.out.println("Select one of the below task");
            System.out.println("1.Add elements");
            System.out.println("2.List elements");
            System.out.println("3.Search element by name");
            System.out.println("4.Delete elements by name");
            System.out.println("5.Search by status");
            System.out.println("6.Update");
            System.out.println("7.Pending List");
            System.out.println("8.Today's Due List");
            System.out.println("9.Exit");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
            switch (a) {
                case "1":
                    String id;
                    System.out.println("Name");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.println("Discription about task");
                    String dis = sc.nextLine();
                    Date dat=new Date();
                    System.out.println("Enter Due Date in (DD/MM/YYYY) format");
                    String sdueDate = sc.nextLine();
                    SimpleDateFormat sdfo=new SimpleDateFormat("dd/MM/yyyy");
                    Date dueDate=sdfo.parse(sdueDate);
                    Status st= Status.valueOf("Assigned");
                    tm.add(name, dis, dat, st, dueDate);
                    System.out.println(".............Added...............");
                    break;

                case "2":
                    List <Task> taskList=tm.display();

                    if(taskList==null)
                    {
                        // System.out.println("Not Found");
                    }
                    else {
                        System.out.println(".............Contents...............");
                        Print(taskList);
                    }
                    break;

                case "3":
                    System.out.println("Enter name to be searched");
                    String n = sc.next();
                    sc.nextLine();
                    List<Task> nameSearchList=tm.search(n);

                   if(nameSearchList==null)
                   {
                      // System.out.println("Not Found");
                   }
                   else {
                       for (Task obj : nameSearchList) {
                           System.out.println("Id:"+obj.id1);
                           System.out.println("Name:"+obj.name1);
                           System.out.println();
                       }
                       System.out.println("Enter id to get full details");
                       id=sc.next();
                       System.out.println(".............Contents...............");
                       for (Task obj : nameSearchList) {
                           if (obj.id1.equals(id)){
                               System.out.println("ID:" + obj.id1);
                               System.out.println("Name:" + obj.name1);
                               System.out.println("Discription:" + obj.dis1);
                               System.out.println("Date:"+obj.dat1);
                               System.out.println("Due date:"+obj.due1);
                               System.out.println("Status:" + obj.st1);
                               System.out.println();

                           }
                       }
                   }
                    break;

                case "4":
                try {

                    System.out.println("Enter name to be deleted");
                    n = sc.next();
                    sc.nextLine();
                    List<Task> deleteList = tm.search(n);

                    if (deleteList == null) {
                        // System.out.println("Not Found");
                    }
                    else {

                        for (Task obj : deleteList) {
                            System.out.println("Id:" + obj.id1);
                            System.out.println("Name:" + obj.name1);
                            System.out.println();
                        }
                        System.out.println("Enter id to get deleted perminently");
                        id = sc.next();
                        tm.delete(n,id);
                    }
                }

                catch (Exception e){
                    System.out.println("List has become empty");
                    System.out.println();
                }
                    System.out.println(".............Deleted...............");
                    break;

                case "5":
                    System.out.println("Enter status to be searched(Assigned,InProgress,Complete)");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    List<Task> satusSearchList=tm.searchStatus(n);

                    if(satusSearchList==null)
                    {
                        // System.out.println("Not Found");
                    }
                    else
                    {
                        for (Task obj : satusSearchList) {
                            System.out.println("Id:" + obj.id1);
                            System.out.println();
                            System.out.println("Name:" + obj.name1);
                            System.out.println();
                        }
                        System.out.println("Enter id to get full details");
                        id = sc.next();
                        System.out.println(".............Contents...............");
                        for (Task obj : satusSearchList) {
                            if (obj.id1.equals(id)) {
                                System.out.println("ID:" + obj.id1);
                                System.out.println("Name:" + obj.name1);
                                System.out.println("Discription:" + obj.dis1);
                                System.out.println("Date:" + obj.dat1);
                                System.out.println("Due date:" + obj.due1);
                                System.out.println("Status:" + obj.st1);
                                System.out.println();

                            }
                        }
                    }

                    break;

                case "6":
                    System.out.println("Enter name to be updated");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    List<Task>updateList = tm.search( n);
                    if(updateList==null)
                    {
                        // System.out.println("Not Found");
                    }

                  else {
                        for (Task obj : updateList) {
                            System.out.println("Id:" + obj.id1);
                            System.out.println("Name:" + obj.name1);
                            System.out.println();
                        }
                        System.out.println("Enter id to edit");
                        id = sc.next();

                        for (Task obj : updateList) {
                            if (obj.id1.equals(id)) {
                                System.out.println("Change the Status to(Assigned,InProgress,Complete)");
                                try {
                                    String status1 = sc.next();
                                    Status status=Status.valueOf(status1);
                                    tm.updateStatus(status, n, id);
                                }
                                catch(Exception e)
                                {
                                    System.out.println("It is not from the above items");
                                }
                            }
                        }
                        System.out.println(".............Updated...............");
                    }
                    break;

                case "7":
                    List<Task> pendingTask=tm.getPendingTask();

                    if(pendingTask==null)
                    {
                        // System.out.println("Not Found");
                    }

                    else
                    {
                        System.out.println(".............Pending Tasks...............");
                        Print(pendingTask);
                    }
                    break;

                case "8":
                    System.out.println(".............Today's Tasks...............");
                    Date date=new Date();
                    List<Task> todaysTask=tm.getTodaysTask(date);

                    if(todaysTask==null)
                    {
                        // System.out.println("Not Found");
                    }
                    else {
                        Print(todaysTask);
                    }
                    break;

                case "9":
                    System.exit(1);
                    break;

                default:
                    System.out.println("Plz Enter Correct Input from (1-5)");
                    System.out.println();
                    break;

            }
        }
    }
    static void Print(List<Task> list) {
        for (Task obj : list) {
            System.out.println("Id:" + obj.id1);
            System.out.println("Name:" + obj.name1);
            System.out.println("Discription:" + obj.dis1);
            System.out.println("Due date:" + obj.due1);
            System.out.println("Status:" + obj.st1);
            System.out.println();
        }
    }
}
