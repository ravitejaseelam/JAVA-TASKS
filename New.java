package com.raviteja;
import java.util.*;

public class New {


    public static void main(String[] args) {
      TaskManager tm =new TaskManager();
        List<Task> t2 = new ArrayList<Task>();
        List<Task> t1 = new ArrayList<Task>();
        while (true) {
            System.out.println("Select one of the below task");
            System.out.println("1.Add elements");
            System.out.println("2.List elements");
            System.out.println("3.Search element by name");
            System.out.println("4.Delete elements by name");
            System.out.println("5.Search by status");
            System.out.println("6.Exit");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    int id;
                    System.out.println("Name");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.println("Discription about task");
                    String dis = sc.nextLine();
                    System.out.println("Due Date");
                    Date due=new Date();
                    System.out.println("Status (any of Assigned,InProgress,Complete)");
                    String sta=sc.nextLine();
                    Status st= Status.valueOf(sta);
                    id=tm.idAllocate(t2,name,dis,due,st);


                    t2.add(new Task(name, dis, due,st,id));
                    break;


                case 2:
                    System.out.println("Contents are Displayed");
                   // tm.display(t2);
                    for (Task obj : t2) {
                        System.out.println("Id:"+obj.id1);
                        System.out.println();
                        System.out.println("Name:"+obj.name1);
                        System.out.println();
                        System.out.println("Discription:"+obj.dis1);
                        System.out.println();
                        System.out.println("Due Date:"+obj.due1);
                        System.out.println();
                        System.out.println("Status:"+obj.st1);
                        System.out.println();
                    }
                    break;


                case 3:
                    System.out.println("Enter name to be searched");
                    String n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    t1=tm.search(t2,n);

                   if(t1==null)
                   {
                       System.out.println("Not Found");
                   }
                   else {
                       for (Task obj : t1) {
                           System.out.println("Id:"+obj.id1);
                           System.out.println();
                           System.out.println("Name:"+obj.name1);
                           System.out.println();
                       }
                       System.out.println("Enter id to get full details");
                       id=sc.nextInt();
                       for (Task obj : t1) {
                           if (id==obj.id1){
                               System.out.println("ID:" + obj.id1);
                               System.out.println();
                               System.out.println("Name:" + obj.name1);
                               System.out.println();
                               System.out.println("Discription:" + obj.dis1);
                               System.out.println();
                               System.out.println("Due Date:" + obj.due1);
                               System.out.println();
                               System.out.println("Status:" + obj.st1);
                               System.out.println();

                           }
                       }


                   }
                    break;


                case 4:
                try {

                    System.out.println("Enter name to be deleted");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    t1 = tm.search(t2, n);
                    if (t1 == null) {
                        System.out.println("Not Found");
                    } else {
                        for (Task obj : t1) {
                            System.out.println("Id:" + obj.id1);
                            System.out.println();
                            System.out.println("Name:" + obj.name1);
                            System.out.println();
                        }
                        System.out.println("Enter id to get deleted perminently");
                        id = sc.nextInt();

                        for (Task obj : t1) {
                            if (id == obj.id1) {
                                t2 = tm.delete(t2, obj);
                            }
                        }
                    }
                }

                catch (Exception e){
                    System.out.println("List has become empty");
                    System.out.println();
                }

                    break;
                case 5:
                    System.out.println("Enter status to be searched(Assigned,InProgress,Complete)");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    t1=tm.searchStatus(t2,n);
                    if(t1==null)
                        System.out.println("Not Found");
                    else {
                        for (Task obj : t1) {
                            System.out.println("Id:"+obj.id1);
                            System.out.println();
                            System.out.println("Name:"+obj.name1);
                            System.out.println();
                        }
                        System.out.println("Enter id to get full details");
                        id=sc.nextInt();
                        for (Task obj : t1) {
                            if (id==obj.id1){
                                System.out.println("ID:" + obj.id1);
                                System.out.println();
                                System.out.println("Name:" + obj.name1);
                                System.out.println();
                                System.out.println("Discription:" + obj.dis1);
                                System.out.println();
                                System.out.println("Due Date:" + obj.due1);
                                System.out.println();
                                System.out.println("Status:" + obj.st1);
                                System.out.println();

                            }
                        }

                    }
                    break;

                case 6:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Plz Enter Correct Input from (1-5)");
                    System.out.println();
                    break;

            }
        }
    }
}
