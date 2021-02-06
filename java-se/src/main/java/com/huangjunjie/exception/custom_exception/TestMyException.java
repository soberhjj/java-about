package com.huangjunjie.exception.custom_exception;

/**
 * @author huangJunJie 2021-02-06-22:36
 */
public class TestMyException {
    public static void main(String[] args) throws MyException {
        Student student1 = new Student();
        student1.register(1);
        System.out.println(student1.toString());

        Student student2 = new Student();
        student2.register(-1);
        System.out.println(student2.toString());

    }

}

class Student {
    private int id;

    public void register(int id) throws MyException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new MyException("输入数据非法");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
