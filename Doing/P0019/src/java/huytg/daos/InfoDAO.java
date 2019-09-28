/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.InfoDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SE130226
 */
public class InfoDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public InfoDAO(){
        
    }
    
    private void closeConnection() throws Exception{
        if(rs != null)
        {
            rs.close();
        }
        if(preStm != null){
            preStm.close();
        }
        if(conn != null){
            conn.close();
        }
    }
    
    public InfoDTO getInfo(int id) throws Exception{
        InfoDTO dto = null;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Tel,Email From Info Where Id = ?";
            preStm = conn.prepareStatement(sql);
            
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            
            if(rs.next()){
                String tel = rs.getString("Tel");
                String email = rs.getString("Email");
                
                dto = new InfoDTO(id, tel, email);
            }
        } finally {
            closeConnection();
        }
        
        return dto;
    }
    
    public InfoDTO getDetailInfo(int id) throws Exception{
        InfoDTO dto = null;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Tel,Email,Address,Country,City,Map From Info Where Id = ?";
            preStm = conn.prepareStatement(sql);
            
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            
            if(rs.next()){
                String tel = rs.getString("Tel");
                String email = rs.getString("Email");
                String country = rs.getString("Country");
                String address = rs.getString("Address");
                String map = rs.getString("Map");
                String city = rs.getString("City");
                
                dto = new InfoDTO(id, tel, email, address, country, city, map);
            }
        } finally {
            closeConnection();
        }
        
        return dto;
    }
    
    
}
