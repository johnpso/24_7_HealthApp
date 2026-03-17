package org.example._4_7_healthapp;

public class UserInfo {
    private String userName;
    private int age;
    private String gender;
    private double weight;
    private double height;

    //Constructor
    public UserInfo(String userName, int age, String gender, double weight, double height) {
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    //ToString


    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    //Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
