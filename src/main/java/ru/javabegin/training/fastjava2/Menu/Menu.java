package ru.javabegin.training.fastjava2.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    Menu() {
        System.out.print("Menu\n");
        System.out.print("If you want \"Out put all students\" press 1;\n");
        System.out.print("If you want \"Add new student\" press 2;\n");
        System.out.print("If you want \"remove student\" press 3;\n");
        System.out.print("If you want see menu again press 4.\n");
        System.out.print("If you want \" go exit\" press 0;\n");


    }
     private BufferedReader br = null;
    public void printmenu() {

        Action act = new Action();

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Inter your choice ");
            String input = br.readLine();
            System.out.println();
            System.out.print("");

            if ("1".equals(input)) {
                act.Outinf();

            }   if ("2".equals(input)){
                System.out.println("you choice \"Add new student\"");
                act.AddStudent();

            }   if ("3".equals(input)){
                System.out.println("you choice \"remove student\"");
                System.out.println("please write the criterion on the removed");
                act.RemoveNote();

            } if ("0".equals(input)){
                br.close();
                System.out.println(" you choice go exit");
                System.out.println("GoodBye");
                System.exit(0);
            } if ("4".equals(input)){
                System.out.println("Menu");
                System.out.print("If you want \"Out put all students\" press 1;\n ");
                System.out.print("If you want \"Add new student\" press 2;\n");
                System.out.print("If you want \"remove student\" press 3;\n");
                System.out.print("If you want see menu again press 4;\n");
                System.out.print("If you want \" go exit\" press 0.\n");

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 }
