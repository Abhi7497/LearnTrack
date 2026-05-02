package com.airtribe.learntrack.entity;

public class Student extends Person{
   // id, firstName, lastName, email, batch, active (boolean)
    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);// from Person
        this.batch = batch;
        this.active = true; // as a default value we have to set here bool
    }

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName, "");
        this.batch = "";
        this.active = true;
    }

   //getters and setters
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //meathods
    public void display(){
        System.out.println("ID:  " + id +
                           ", Name: " + firstName + " " + lastName +
                           ", Email: " + email +
                           ", Batch: " + batch +
                           ", Active: " + active);
    }

    public void deactivate() {
        this.active = false;
    }
}
