/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.ServiceDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class ServiceDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public ServiceDAO() {

    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public ArrayList<ServiceDTO> getAllDetail() throws Exception{
        ArrayList<ServiceDTO> list = null;
        ServiceDTO dto;
        
        int id;
        String name,info;
        float price;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Name,Info,Price From Services";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                info = rs.getString("Info");
                price = rs.getFloat("Price");
                
                dto = new ServiceDTO(id, name, info, price);
                list.add(dto);
                
            }
        } finally  {
            closeConnection();
        }
        
        return list;
    }
}
