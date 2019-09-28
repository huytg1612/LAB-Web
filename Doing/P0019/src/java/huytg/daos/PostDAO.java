/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.PostDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class PostDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public PostDAO(){
        
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
    
    public ArrayList<PostDTO> getAll() throws Exception{
        ArrayList<PostDTO> list;
        PostDTO dto;
        
        int id;
        String title,content,picture;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Top 3 Id,Title,Content,Picture From Posts Order By Datetime DESC";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList();
            
            while(rs.next()){
                id = rs.getInt("Id");
                title = rs.getString("Title");
                content = rs.getString("Content");
                picture = rs.getString("Picture");
                
                dto = new PostDTO(id, title, content, picture);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
