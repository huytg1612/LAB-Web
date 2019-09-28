/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.conn;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author SE130226
 */
public class MyConnection implements Serializable{
    public static Connection getMyConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=P0019","sa","123456");
        
        return conn;
    }
}
