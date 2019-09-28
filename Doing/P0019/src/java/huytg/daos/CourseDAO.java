/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.CourseDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class CourseDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public CourseDAO(){
        
    }
    private void closeConnection() throws Exception{
        if(rs != null){
            rs.close();
        }
        if(preStm != null){
            preStm.close();
        }
        if(rs != null){
            rs.close();
        }
    }
    
    public ArrayList<CourseDTO> getAll() throws Exception{
        ArrayList<CourseDTO> list;
        CourseDTO dto;
        
        int id;
        String name,content,date;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Name,Content,Date From Courses Order By Date DESC";
            preStm = conn.prepareCall(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                content = rs.getString("Content");
                date = rs.getString("Date");
                
                dto = new CourseDTO(id, name, content, date);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
    
    public ArrayList<CourseDTO> getAllDetail() throws Exception{
        ArrayList<CourseDTO> list = null;
        CourseDTO dto;
        
        int id;
        String name,content;
        float price;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Name,Content,Price From Courses";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                content = rs.getString("Content");
                price = rs.getFloat("Price");
                
                dto = new CourseDTO(id, name, content, price);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        
        return list;
    }
}
