/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.MenuDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class MenuDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public MenuDAO(){
        
    }
    
    private void closeConnection() throws Exception{
        if(rs != null){
            rs.close();
        }
        if(preStm != null){
            preStm.close();
        }
        if(conn != null){
            conn.close();
        }
    }
    
    public ArrayList<MenuDTO> getAll() throws Exception{
        ArrayList<MenuDTO> list = null;
        MenuDTO dto;
        
        int id;
        String name,description;
        float price;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Name,Description,Price From Menus";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getFloat("Price");
                
                dto = new MenuDTO(name, description, price);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
