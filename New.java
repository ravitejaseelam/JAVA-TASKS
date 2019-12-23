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
                    TaskManager.add(t2,name,dis,due);
                    //t2.add(new task(name, dis, due));
                    break;
                case 2:
                    System.out.println("Contents are Displayed");
                    TaskManager.display(t2);
                    break;
                case 3:
                    k = 0;
                    System.out.println("Enter name to be searched");
                    String n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                   TaskManager.search(t2,n);

                    break;
                case 4:
                try {
                    k = 0;
                    System.out.println("Enter name to be searched");
                    n = sc.next();
                    sc.nextLine();
                    System.out.println(n);
                    TaskManager.delete(t2, n);
                }              

                catch (Exception e){
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
