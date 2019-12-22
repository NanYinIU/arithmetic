package com.effctiveJava;

public class Person {
    private String firstName;
    private String lastName;

    private int age;

    private String address;
    private String email;

    public static class Builder{
        private String firstName;
        private String lastName;

        private int age;

        private String address;
        private String email;

        private Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        private Builder age(int age){
            this.age = age;
            return this;
        }

        private Builder email(String email){
            this.email = email;
            return this;
        }
        private  Builder address(String address){
            this.address = address;
            return this;
        }
    }

    private  Person(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.email = builder.email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person(new Builder("li","si").age(11).email("a@b").address("beijing"));
        System.out.println(person);
        Dog dog = Dog.getInstance();
        Dog dog2 = Dog.getInstance();
        System.out.println(dog == dog2);
    }

}
