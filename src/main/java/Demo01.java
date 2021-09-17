import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.jimage.ImageStream;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2 获取连接
            Connection connection= DriverManager.getConnection("jdbc:mysql:///"test01", "root", "root") {
        // 3 准备传输器
        Statement statement = connection.createStatement();
        //增
            String sql1 = "insert into book (id,name,author,prices) values(null,'假如给我三天光明','海伦凯勒',50)";
            //int  result =statement.executeUpdate(sql1);
            //删
            String sql2 = "delete from book where author='老舍'";
            //int result=statement.executeUpdate(sql2);
            //改
            String sql3 = "update  book set name='假如给我三天光明' where author='海伦凯勒' ";
            //int result=statement.executeUpdate(sql3);
            // 4 执行sql
            ResultSet resultSet = statement.executeQuery("select * from book ");
            // 5 获取结果
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                        + resultSet.getString(3) + " " + resultSet.getDouble(4)
                );
            }
            // 6 关闭资源
            resultSet.close();
            statement.close();
            connection.close();
        }


    }

}







