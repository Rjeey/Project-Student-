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
        int number = 0;
        int course = 0;
        boolean payskin;



        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Inter name: ");
            String name = bufferedReader.readLine();
            if (Filters.filterForname(name)) {
                while (Filters.filterForname(name)) {
                    System.out.println("you typed something wrong repeat please");
                     name = bufferedReader.readLine();
                }
            }



            System.out.print("Inter surname: ");
            String surename = bufferedReader.readLine();
            if (Filters.filterForname(surename)) {
                while (Filters.filterForname(surename)) {
                    System.out.println("you typed something wrong repeat please");
                    surename = bufferedReader.readLine();
                }
            }
            
            System.out.println("Example <12.12.2014>");
            System.out.println("Inter date:");
            String date = bufferedReader.readLine();
            if (Filters.date(date)) {
               while ( Filters.date(date)) {
                        System.out.println("you typed something wrong repeat please");
                        date = bufferedReader.readLine();
               }

            }

            System.out.print("Inter Phone number: ");
            String stnum = bufferedReader.readLine();
            if ( Filters.number(stnum)) {
                while ( Filters.number(stnum)) {
                    System.out.println("you typed something wrong repeat please");
                    stnum = bufferedReader.readLine();
                }
            } else number = Integer.parseInt(stnum);



            System.out.print("Inter Number course: ");
            String stcourse = bufferedReader.readLine();
            if ( Filters.course(stcourse)) {
                while (Filters.course(stcourse)) {
                    System.out.println("you typed something wrong repeat please");
                    stcourse = bufferedReader.readLine();
                }
            }  course = Integer.parseInt(stcourse);



            System.out.print("Inter Gender: ");
            String gender = bufferedReader.readLine();
            if (Filters.filterForGender(gender)) {
                while (Filters.filterForGender(gender)) {
                        System.out.println("you typed something wrong repeat please");
                        gender = bufferedReader.readLine();
                }
            }

            System.out.print("Inter position student \" true  or false \": ");
            String stpayskin = bufferedReader.readLine();
            if (Filters.filterForPos(stpayskin)) {
                   while (Filters.filterForPos(stpayskin)) {
                        System.out.println("field must not be empty and he contain name \"true or false\"");
                        stpayskin = bufferedReader.readLine();
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
