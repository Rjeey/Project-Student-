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
    public StudentOrg(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getPayskin() {
        return payskin;
    }

    public void setPayskin(boolean payskin) {
        this.payskin = payskin;
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

