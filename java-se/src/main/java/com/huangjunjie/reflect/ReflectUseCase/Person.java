package com.huangjunjie.reflect.ReflectUseCase;

/**
 * @author sober 2020-06-05-20:00
 */
public class Person {
    private String name;
    private String sex;
    private String address;

    public Person(){}

    public  Person(String name,String sex,String address){
        this.name=name;
        this.sex=sex;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void sayHello(){
        System.out.println("hello,I am "+name);
    }

    public void sayHi(){
        System.out.println("hi,I come form "+address);
    }
}
