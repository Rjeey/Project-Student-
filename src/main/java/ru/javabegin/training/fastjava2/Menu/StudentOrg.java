package ru.javabegin.training.fastjava2.Menu;

public class StudentOrg {

    private String name;
    private String surename;
    private String date;
    private int number;
    private int course;
    private String gender;
    private boolean payskin;


    public StudentOrg(String name,String surname,String date,int  number,int course,String gender,boolean payskin){

        this.name=name;
        this.surename = surname;
        this.date=date;
        this.number = number;
        this.course=course;
        this.gender=gender;
        this.payskin=payskin;
    }
    public StudentOrg(String name,String surename){
    this.name=name;
    this.surename=surename;

    }
    @Override
    public String toString(){
       return "Name: "+name+"; Sure name: "+surename+"; Birthday: "+date+"; Call number "+"+375"+number+
               "; Course: "+course+"; Gender: "+gender+"; Pay skin: "+payskin;
       }
      @Override
       public boolean equals(Object o){
         StudentOrg examples=(StudentOrg)o;
           return (name.compareTo(examples.name)==0 && surename.compareTo(examples.surename)==0);
      }

 }

