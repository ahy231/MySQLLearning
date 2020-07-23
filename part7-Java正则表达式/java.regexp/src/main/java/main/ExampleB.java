/*
 * @Copyright: free for non-commercial usage
 * @Author: ahy231
 * @Date: 2020-07-23 10:27:42
 * @LastEditor: ahy231
 * @LastEditTime: 2020-07-23 10:37:07
 */ 
package main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleB {
    public static void main(String[] args) {
        
        //按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        //创建Pattern对象
        Pattern r = Pattern.compile(pattern);

        //现在创建matcher对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }
}