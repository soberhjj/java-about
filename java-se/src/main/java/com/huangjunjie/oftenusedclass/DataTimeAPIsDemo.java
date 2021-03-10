package com.huangjunjie.oftenusedclass;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * @author huangJunJie 2021-03-10-20:06
 */
public class DataTimeAPIsDemo {

    /**
     * java.lang.System类中的时间相关API
     */
    @Test
    public void demo1() {
        //返回当前时间与1970-01-01 00:00:00 之间以毫秒为单位的时间差（也称为时间戳）
        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        /**
         *  nanoTime()返回的是纳秒，但是返回的这个纳秒本身没有什么意义，因为它基于的时间点是随机的，甚至可能是一个未来的时间，所以返回值可能为负数，
         *  虽然nanoTime基于的时间点是随机的，但是对于同一个JVM里，任何地方nanoTime使用到的基点时间是一样的，所以可以用nanoTime的意义在于
         *  可以用它计算时间差（纳秒级别），当currentTimeMillis（毫秒级别）计算时间差无法满足需要时，可以使用nanoTime来计算时间差
         */

        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println(Math.abs(start - end));
    }

    /**
     * java.util.Date类：该类的实例表示一个特定的瞬间，精确到毫秒
     */
    @Test
    public void demo2() {
        //空构造器：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        //toString()：显示当前的年月日时分秒
        //getTime()：获取当前Date对象对应的时间戳，和System.currentTimeMillis()一样
        System.out.println(date1);
        System.out.println(date1.getTime());

        //创建一个指定时间（传入时间戳）的Date对象
        Date date2 = new Date(1650306204104L);
        System.out.println(date2);
        System.out.println(date2.getTime());
    }

    /**
     * java.sql.Date类：对应着数据库中的日期类型。该类是java.util.Date类的子类。用法和它类似
     */
    @Test
    public void demo3() {
        Date date = new java.sql.Date(1650306204104L);
        System.out.println(date);
        System.out.println(date.getTime());
    }

    /**
     * java.text.SimpleDateFormat类：它是一个不与语言有关的可对日期进行格式化和解析的类。格式化即日期->文本  解析即问文本->日期
     */
    @Test
    public void demo4() throws ParseException {
        /**
         * 日期格式化
         */
        Date date = new Date();
        System.out.println(date);
        //空参构造SimpleDateFormat，采用的是默认的格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        //指定格式化格式 构造SimpleDateFormat
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        /**
         * 解析：注意解析要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
         */
        String time = "2021-3-10 20:49";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parse = simpleDateFormat2.parse(time);
        System.out.println(parse.getTime());

    }

    /**
     * java.util.Calendar：日历类。它是一个抽象基类，主要用于完成日期字段（年、月、日等字段）之间相互操作的功能
     * 一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想要的时间信息。比如YEAR、MONTY、DAY_OF_WEEK、MINUTER、SECOND等
     * 注意：获取月份时：一月是0，二月是1，以此类推 12月是11
     * 获取星期使时：周日是1，周二是2，…… 周六是7
     */
    @Test
    public void demo5() {
        // 使用默认时区和语言环境获得一个日历
        Calendar cal = Calendar.getInstance();
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

        //给日历设置指定日期
        Calendar cal1 = Calendar.getInstance();
        // 如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1
        // cal.set(year, month, date, hourOfDay, minute, second);
        cal1.set(2021, 1, 15, 23, 59, 59);
        System.out.println(cal1.getTime());

        //add方法的使用：用于对指定的字段进行加减，如前三天即天这个字段减3就是前三天，后一个月即月这个字段加1就是后一个月
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MONTH, +1);
        cal2.add(Calendar.DAY_OF_WEEK, -3);
        System.out.println(cal2.getTime());
    }

}
