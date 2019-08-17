import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSourceDemo {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DataSource datasource = new ComboPooledDataSource();
        //创建数据库连接
        Connection con = datasource.getConnection();
        String sql = "update product set  price = ? where pname = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,"5000");
        pt.setString(2,"戴尔");
        int i = pt.executeUpdate();
        System.out.println(i);
        pt.close();
        con.close();

    }
}
