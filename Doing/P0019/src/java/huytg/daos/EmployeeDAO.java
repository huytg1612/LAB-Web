/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.EmployeeDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class EmployeeDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public EmployeeDAO(){
        
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
    
    public EmployeeDTO getFirst() throws Exception{
        EmployeeDTO dto = null;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Top 1 Id,Picture,Name From Employees";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            if(rs.next()){
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String picture = rs.getString("Picture");
                
                dto = new EmployeeDTO(id, name, picture);
            }
            
        } finally {
            closeConnection();
        }
        
        return dto;
    }
    public ArrayList<EmployeeDTO> getAll() throws Exception{
        ArrayList<EmployeeDTO> list = null;
        EmployeeDTO dto;
        
        int id;
        String name,picture,description;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Picture,Name,Description From Employees";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                picture = rs.getString("Picture");
                description = rs.getString("Description");
                
                dto = new EmployeeDTO(id, name, picture, description);
                list.add(dto);
            }
            
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
