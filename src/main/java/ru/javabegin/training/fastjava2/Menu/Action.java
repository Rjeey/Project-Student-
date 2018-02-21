package ru.javabegin.training.fastjava2.Menu;

import com.mongodb.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Action {


    MongoClient mongoClient = new MongoClient("localhost", 27017);
    DB db = mongoClient.getDB("student_info");
    DBCollection table = db.getCollection("student");
    MongoCredential credential = MongoCredential.createScramSha1Credential("Teacher", "student_info", "123456".toCharArray());
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");


    public Action() {
        mongoLogger.setLevel(Level.SEVERE);
    }


    public void Outinf() throws Exception {

        DBCursor cursor = table.find();
        if (cursor.hasNext()) {
            while(cursor.hasNext())
            {
                System.out.println(cursor.next());
            }
        }else System.out.println("No records");

}



    public void AddStudent()throws Exception {
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
            BasicDBObject document = new BasicDBObject();
            document.put("name", name);
            document.put("surename",surename);
            document.put("date",date);
            document.put("number",number);
            document.put("course",course);
            document.put("gender",gender);
            document.put("payskin",payskin);

            table.insert(document);


        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public void RemoveNote()throws Exception {
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

            BasicDBObject doc = new BasicDBObject();
            DBCursor cursor = table.find();
            if(cursor.hasNext()) {
                    doc.append("name",name).append("surename",surename);
                    table.remove(doc);
                    System.out.println("Student is removed");
            } else System.out.println("No records");


        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
