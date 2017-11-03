package com.miguelcr.a02_customlist;

/**
 * Created by miguelcampos on 3/11/17.
 */

public class Student {
    private String name;
    private String training;
    private String school;
    private int age;
    private String urlPhoto;

    // Constructor
    public Student() {
    }

    // Constructor
    public Student(String name, String training, String school, int age, String urlPhoto) {
        this.name = name;
        this.training = training;
        this.school = school;
        this.age = age;
        this.urlPhoto = urlPhoto;
    }

    // Getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
