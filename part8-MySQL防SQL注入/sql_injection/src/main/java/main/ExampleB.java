/*
 * @Copyright: free for non-commercial usage
 * @Author: ahy231
 * @Date: 2020-07-24 09:35:01
 * @LastEditor: ahy231
 * @LastEditTime: 2020-07-24 13:20:34
 */ 
package main;
import java.sql.*;

public class ExampleB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "test";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //执行查询
            System.out.println("实例化Statement对象...");
            String sql = "SELECT * FROM students WHERE `name`=? AND `password`=?";
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, args[0]);
            preState.setString(2, args[1]);
            ResultSet rs = preState.executeQuery();

            //展开结果集数据库
            while(rs.next()) {
                //通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");

                //输出数据
                System.out.println("学生信息：");
                System.out.println("ID：" + id);
                System.out.println("名字：" + name);
                System.out.println();
            }
            //完成后关闭
            rs.close();
            preState.close();
            conn.close();
        } catch (SQLException se) {
            //处理JDBC错误
            se.printStackTrace();
        } catch (Exception e) {
            //处理Class.forName错误
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                //to do nothing
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
