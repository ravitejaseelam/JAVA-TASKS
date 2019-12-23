package com.raviteja;
import java.util.*;

public class New {


    public static void main(String[] args) {
      int k=0;
        List<task> t2 = new ArrayList<task>();
        while (true) {
            System.out.println("Select one of the below task");
            System.out.println("1.Add elements");
            System.out.println("2.List elements");
            System.out.println("3.Search element by name");
            System.out.println("4.Delete elements by name");
            System.out.println("5.Exit");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Name");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.println("Discription about task");
                    String dis = sc.nextLine();
                    System.out.println("Due Date");
                    Date due=new Date();
                    t2.add(new task(name, dis, due));
                    break;
                case 2:
                    System.out.println("Contents are Displayed");
                    for (task obj : t2) {
                        System.out.println("Name:"+obj.name1);
                        System.out.println();
                        System.out.println("Discription:"+obj.dis1);
                        System.out.println();
                        System.out.println("Due Date:"+obj.due1);
                        System.out.println();
                    }
                    break;
                case 3:
                    k = 0;
                    System.out.println("Enter name to be searched");
                    String n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
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

                    break;
                case 4:
                try {
                    k = 0;
                    System.out.println("Enter name to be searched");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
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
            }                catch (Exception e){
                    System.out.println("List has become empty");
                    System.out.println();
                }

                    break;
                case 5:
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
