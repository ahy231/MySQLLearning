/*
 * @Copyright: free for non-commercial usage
 * @Author: ahy231
 * @Date: 2020-07-23 16:47:27
 * @LastEditor: ahy231
 * @LastEditTime: 2020-07-23 16:48:32
 */ 
package main;
import java.util.regex.*;

/**
 * Hello world!
 *
 */
public class ExampleA
{
    public static void main( String[] args )
    {
        String pattern = "[a-zA-Z0-9_\\.]{8,20}";
        boolean isMatch = Pattern.matches(pattern, args[0]);
        if (isMatch) {
            System.out.println("username 输入正常");
        } else {
            System.out.println("username 输入异常");
        }
    }
}
