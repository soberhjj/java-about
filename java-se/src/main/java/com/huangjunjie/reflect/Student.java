package com.huangjunjie.reflect;

/**
 * @author sober 2020-06-05-19:48
 */
class Student {
    private String college;
    private String name;
    private int grade;

    public String address;
    public String hobit;


    public Student(String college, String name, int grade) {
        this.college = college;
        this.name = name;
        this.grade = grade;
    }

    public Student(String college,String name){
        this.college=college;
        this.name=name;
    }

    private Student(String name){
        this.name=name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    private void sayHello(){
        System.out.println("hello everyone, I am "+name);

    }

    public void sayHi(){
        System.out.println("hi everyone, I am "+name);
    }

    @Override
    public String toString() {
        String s="专业："+college+" 名字："+name+" 年级："+grade;
        return s;
    }
}
