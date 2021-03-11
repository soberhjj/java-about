package com.huangjunjie.oftenusedclass;


import java.util.Scanner;

/**
 * @Author: huangJunJie  2021-03-11 09:36
 */
public class ScannerDemo {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (!scanner.hasNext("#")){
//            System.out.println(scanner.next());
//        }
//        System.out.println("end");
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("EOF")) {
                System.out.println("停止扫描");
                break;
            }else {
                System.out.println(line);
                System.out.println("继续扫描或阻塞等待输入");
            }
        }
        System.out.println("end");
    }


}
