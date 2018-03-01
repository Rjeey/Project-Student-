package ru.javabegin.training.fastjava2.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    Menu() {
        System.out.print("Menu\n");
        System.out.print("If you want \"Out put all students\" write Output;\n");
        System.out.print("If you want \"Add new student\" write Input;\n");
        System.out.print("If you want \"remove student\" write delete;\n");
        System.out.print("If you want see menu again write menu.\n");
        System.out.print("If you want \" go exit\" write exit;\n");


    }
     private BufferedReader br = null;
    public void printmenu() {

        Action act = new Action();
        StudentOrg student=new StudentOrg();

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Inter your choice ");
            String input = br.readLine();
            System.out.println();
            System.out.print("");

            if ("Output".equals(input)||"output".equals(input)) {
                act.Outinf();

            }   if ("Input".equals(input)||"input".equals(input)){
                System.out.println("you choice \"Add new student\"");
                act.AddStudent(student);

            }   if ("delete".equals(input)||"Delete".equals(input)){
                System.out.println("you choice \"remove student\"");
                System.out.println("please write the criterion on the removed");
                act.RemoveNote();

            } if ("exit".equals(input)||"Exit".equals(input)){
                br.close();
                System.out.println(" you choice go exit");
                System.out.println("GoodBye");
                System.exit(0);
            } if ("menu".equals(input)||"Menu".equals(input)){
                System.out.print("Menu\n");
                System.out.print("If you want \"Out put all students\" write Output;\n");
                System.out.print("If you want \"Add new student\" write Input;\n");
                System.out.print("If you want \"remove student\" write delete;\n");
                System.out.print("If you want see menu again write menu.\n");
                System.out.print("If you want \" go exit\" write exit;\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 }
