package ru.javabegin.training.fastjava2.Menu;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Action {
    //connect to mongodb and connect registers;
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    MongoClient mongoClient = new MongoClient("localhost",  MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
    MongoDatabase dbs = mongoClient.getDatabase("student_info");
    MongoCollection<StudentOrg> collection = dbs.getCollection("student",StudentOrg.class);
    MongoCredential credential = MongoCredential.createScramSha1Credential("Teacher", "student_info", "123456".toCharArray());

    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    public Action() {
        mongoLogger.setLevel(Level.WARNING); //скрытие логов
    }

    public void Outinf() {
        Block<StudentOrg> printBlock = new Block<StudentOrg>() {
            @Override
            public void apply(final StudentOrg student) {
                System.out.println(student);
            }
        };
        collection.find().forEach(printBlock);
    }
    // method for add object student;
    public void AddStudent(StudentOrg studentOrg) {

        int number = 0;
        int course = 0;
        boolean payskin=false;
        //introduction of values ​​and their scanning;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Inter name: ");
            String name = bufferedReader.readLine();
            if (Filters.filterForname(name)) {
                while (Filters.filterForname(name)) {
                    System.out.println("you typed something wrong repeat please");
                    name = bufferedReader.readLine();
                }
            } //else studentOrg.setName(name);

            System.out.print("Inter surname: ");
            String surename = bufferedReader.readLine();
            if (Filters.filterForname(surename)) {
                while (Filters.filterForname(surename)) {
                    System.out.println("you typed something wrong repeat please");
                    surename = bufferedReader.readLine();
                }
            } //else studentOrg.setSurename(surename);

            System.out.println("Example <12.12.2014>");
            System.out.println("Inter date:");
            String date = bufferedReader.readLine();
            if (Filters.date(date)) {
                while (Filters.date(date)) {
                    System.out.println("you typed something wrong repeat please");
                    date = bufferedReader.readLine();
                }
            } //else studentOrg.setDate(date);

            System.out.print("Inter Phone number: ");
            String stnum = bufferedReader.readLine();
            if (Filters.number(stnum)) {
                while (Filters.number(stnum)) {
                    System.out.println("you typed something wrong repeat please");
                    stnum = bufferedReader.readLine();
                }
            } else number = Integer.parseInt(stnum);

            System.out.print("Inter Number course: ");
            String stcourse = bufferedReader.readLine();
            if (Filters.course(stcourse)) {
                while (Filters.course(stcourse)) {
                    System.out.println("you typed something wrong repeat please");
                    stcourse = bufferedReader.readLine();
                }
            } else course = Integer.parseInt(stcourse);

            System.out.print("Inter Gender: ");
            String gender = bufferedReader.readLine();
            if (Filters.filterForGender(gender)) {
                while (Filters.filterForGender(gender)) {
                    System.out.println("you typed something wrong repeat please");
                    gender = bufferedReader.readLine();
                }
            } //else studentOrg.setGender(gender);

            System.out.print("Inter position student \" true  or false \": ");
            String stpayskin = bufferedReader.readLine();
            if (Filters.filterForPos(stpayskin)) {
                while (Filters.filterForPos(stpayskin)) {
                    System.out.println("field must not be empty and he contain name \"true or false\"");
                    stpayskin = bufferedReader.readLine();
                }
            } else  payskin=Boolean.parseBoolean(stpayskin);

            // add the object in mongodb;
            System.out.println();
            StudentOrg student = new StudentOrg(name,surename,date,number,course,gender,payskin);

           collection.insertOne(student);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //method for remove note;
    public void RemoveNote()  {
        //Scan input value;
        try {
            //создание потока для ввода;
            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
            //вводим имя для удаления;
            System.out.print("Enter Name: ");
            String name = bufferedReader.readLine();
            if (Filters.filterForname(name)) {
                while (Filters.filterForname(name)) {
                    System.out.println("Name enter incorrectly, please repeat");
                    name = bufferedReader.readLine();
                }
            }
            //вводим фамилию для удаления;
            System.out.print("Enter Sure name: ");
            String surename = bufferedReader.readLine();
            if (Filters.filterForname(surename)) {
                while (Filters.filterForname(surename)) {
                    System.out.println("Sure name enter incorrectly, please repeat ");
                    surename = bufferedReader.readLine();
                }
            }
            //запрос на удаление записи;
            BasicDBObject doc = new BasicDBObject();
            doc.append("name",name).append("surename",surename);
                collection.deleteOne(doc);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
