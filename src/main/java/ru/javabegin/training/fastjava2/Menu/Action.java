package ru.javabegin.training.fastjava2.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;



public class Action {
      static List<StudentOrg> list = new LinkedList<StudentOrg>();

    public void Outinf() {
        if (list.isEmpty()) {
            System.out.print("Information: \"List is empty\"\n");
        }
        for (Object item : list) {
            System.out.println(item);
        }

    }

    public void AddStudent() {
        BufferedReader nm ;
        BufferedReader sn ;
        BufferedReader dt ;
        BufferedReader n ;
        BufferedReader cr;
        BufferedReader fl;
        BufferedReader pn;
        int number = 0;
        int course = 0;
        boolean payskin;

        try {

            nm = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Inter name: ");
            String name = nm.readLine();
            if (Filters.filterForname(name)) {
                while (Filters.filterForname(name)) {
                    System.out.println("you typed something wrong repeat please");
                    name = nm.readLine();
                }
            }


            sn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Inter surname: ");
            String surename = sn.readLine();
            if (Filters.filterForname(surename)) {
                while (Filters.filterForname(surename)) {
                    System.out.println("\n" +"you typed something wrong repeat please");
                    surename = sn.readLine();
                }
            }

            dt = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\rInter date:");
            System.out.println("Example <12.12.2014>");
            System.out.print("\rInput: ");

            String date = dt.readLine();
            if (Filters.date(date)) {
               while ( Filters.date(date)) {
                        System.out.println("you typed something wrong repeat please");
                        date = dt.readLine();
               }

            }


            n = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\rInter Phone number: ");
            String stnum = n.readLine();
            if ( Filters.number(stnum)) {
                while ( Filters.number(stnum)) {
                    System.out.println("you typed something wrong repeat please");
                    stnum = n.readLine();
                }
            } else number = Integer.parseInt(stnum);


            cr = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\rInter Number course: ");
            String stcourse = cr.readLine();
            if ( Filters.course(stcourse)) {
                while (Filters.course(stcourse)) {
                    System.out.println("you typed something wrong repeat please");
                    stcourse = cr.readLine();
                }
            } else course = Integer.parseInt(stcourse);


            fl = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\rInter Gender: ");
            String gender = fl.readLine();
            if (Filters.filterForGender(gender)) {
                while (Filters.filterForGender(gender)) {
                        System.out.println("you typed something wrong repeat please");
                        gender = fl.readLine();
                }
            }

            pn = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\rInter position student \" true  or false \": ");
            String stpayskin = pn.readLine();
            if (Filters.filterForPos(stpayskin)) {
                   while (Filters.filterForPos(stpayskin)) {
                        System.out.println("field must not be empty and he contain name \"true or false\"");
                        stpayskin = pn.readLine();
                   }
                }
                payskin = Boolean.parseBoolean(stpayskin);
                System.out.println();

            list.add(new StudentOrg( name, surename, date, number, course, gender, payskin));

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public void RemoveNote() {
        try {
            BufferedReader deln;
            BufferedReader dels;
            deln = new BufferedReader(new InputStreamReader(System.in));
            dels=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Name: ");
            String  name = deln.readLine();
            if (Filters.filterForname(name)){
                while (Filters.filterForname(name)){
                    System.out.println("Name enter incorrectly, please repeat");
                    name = deln.readLine();
                }
            }
            System.out.print("Enter Sure name: ");
            String  surename=dels.readLine();
            if (Filters.filterForname(surename)){
                while (Filters.filterForname(surename)){
                    System.out.println("Sure name enter incorrectly, please repeat ");
                    surename = dels.readLine();
                }
            }
            StudentOrg wanted= new StudentOrg(name,surename);
            if (list.isEmpty()){
                System.out.println("List is empty");
            }else
            for (StudentOrg st:list) {
                if (st.equals(wanted)) {
                    list.remove(st);
                    System.out.println("Student is removed");
                }
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
