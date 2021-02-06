package com.huangjunjie.io;

import org.junit.Test;

import java.io.*;


/**
 * @author huangJunJie 2020-11-28-22:57
 * <p>
 * 对象流：类似数据流，数据流操作的java八大基本类型和字符串，而对象流操作的是java对象
 */
public class ObjectInputOutputSteam implements Serializable{

    @Test
    public void testObjectInputOutputSteam() throws IOException, ClassNotFoundException {
        User user = new User("zhangsan", "123456");
        //将对象序列化到内存
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(user);
        byte[] datas = baos.toByteArray();

        //从内存中反序列出对象
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        ObjectInputStream ois=new ObjectInputStream(bais);
        User olduser= (User) ois.readObject();
        System.out.println(olduser.getUsername());
        System.out.println(olduser.getPassword());


    }


    class User implements Serializable{
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public User(String username, String password) {
            this.username = username;
            this.password = password;


        }


    }
}
