package com.huangjunjie.oftenusedclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sober 2020-05-23-19:25
 *
 * 参考博文：https://www.cnblogs.com/ggjucheng/p/3423731.html
 */
public class PatternAndMatcher {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+"); //Pattern实例表示的就是一个正则表达式。这里根据compile()方法的参数（表示正则表达式的字符串）来创建一个Pattern实例
        String regex = p.pattern();//pattern()方法用于返回该Pattern实例所表示的正则表达式。Pattern类中的toString()方法与pattern()功能一致

        String[] strings = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com"); //p.split(String参数)方法表示通过该正则表达式(即p)来分割传入的字符串参数。

        boolean res = Pattern.matches("\\d+", "123456"); //Pattern.matches()该静态方法用于进行一次匹配，如果整个字符串符合正则表达式返回true,否则返回false

        /**
         * 当我们需要进行多次的匹配且需要更强更便捷的正则操作时，我们就可以通过一个Pattern实例来创建出一个Matcher实例。Pattern类只能做一些简单的匹配操作，而Matcher类正则操作更强大。
         * 上面代码中的Pattern.matches()方法内部实际上也是创建出一个Matcher实例，然后调用Matcher实例的matches()方法，
         * 当Pattern.matches()执行结束后，这个Matcher实例就被回收了，所以说Pattern.matches()方法只用于进行一次匹配，且匹配全部字符串（因为调用了Matcher实例的matches()方法,该方法下面会提及）。
         */
        Matcher m = p.matcher("22hhjj33");

        //Matcher类提供了三个匹配操作方法，分别为matches()、lookingAt()、find()，三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false。
        boolean res1 = m.matches();//matches()方法对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        boolean res2 = m.lookingAt();//lookingAt()方法对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        boolean res3 = m.find();//find()方法对字符串进行匹配,匹配到的字符串可以在任何位置

        //当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用这三个方法的返回值再根据Matcher类提供的另外三个方法分别为start()、end()、group()来得到更详细的信息。
        int start = m.start();//start()方法返回匹配到的子字符串在字符串中的索引位置
        int end = m.end();//end()方法返回匹配到的子字符串的最后一个字符在字符串中的索引位置
        String subString = m.group();//group()方法返回匹配到的子字符串

        //start(),end(),group()均有一个重载方法它们是start(int i),end(int i),group(int i)专用于分组操作。Mathcer类还有一个groupCount()用于返回有多少组。

        //下面结合使用上述的方法来对一段文本进行匹配，得出其中传数字子串的全部信息。
        String text="长久以来，一颗流浪的心忽然间3276273找到了一个可以安歇的去处。" +
                "坐在窗前，87309743我在试问我自己：647578324你有多久没有好好看看这蓝蓝的天，" +
                "闻一闻这芬芳的花香，3248659听一听那鸟儿的鸣唱？有多久没有回家看看，" +
                "听听家人的倾诉？有多久没和他们一起吃饭了，6547298听听那年老的欢笑？" +
                "有多久没与他们谈心，945928听听他门的烦恼、他们的心声呢？" +
                "是不是因为一路风风雨雨， 而忘了天边的彩虹？74657398是不是因为行色匆匆的脚步，" +
                "而忽视了沿路的风景？35245366除了一颗疲惫的心，麻木的心，2134565897你还有一颗感恩的心吗？" +
                "不要因为生命过于沉重，1567434563而忽略了感恩的心！";
        Matcher matcher = Pattern.compile("\\d+").matcher(text);
        System.out.println("总共找到"+matcher.groupCount()+"个纯数字子串");
        while (matcher.find()){
            String s=matcher.group()+"  该子串起始位置:"+matcher.start()+"  结束位置:"+matcher.end();
            System.out.println(s);
        }
    }
}
