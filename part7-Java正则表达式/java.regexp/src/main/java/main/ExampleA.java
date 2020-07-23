/*
 * @Copyright: free for non-commercial usage
 * @Author: ahy231
 * @Date: 2020-07-23 10:18:52
 * @LastEditor: ahy231
 * @LastEditTime: 2020-07-23 10:33:10
 */ 
package main;
import java.util.regex.*;

/**
 * App
 */
public class ExampleA {

    public static void main(String[] args) {
        String content = "I am noob" +
            "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含'runoob'子字符串?" + isMatch);
        //输出结果：字符串中是否包含了'runoob'子字符串？true
    }
}