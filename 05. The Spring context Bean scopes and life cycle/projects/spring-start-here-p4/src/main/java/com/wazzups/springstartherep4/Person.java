package com.wazzups.springstartherep4;

public class Person {
    private String firstName;
    private String lastName;
    private Job job; // Has-A relationship


    /* COMPOSITION
    * Composition is achieved by using instance variables that refers to other objects
    * */
    public Person() {
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }
}
