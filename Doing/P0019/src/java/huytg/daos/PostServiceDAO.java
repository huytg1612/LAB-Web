/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.PostServiceDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class PostServiceDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public PostServiceDAO(){
        
    }
    
    private void closeConnection() throws Exception{
        if(rs!= null){
            rs.close();
        }
        if(preStm != null){
            preStm.close();
        }
        if(conn != null){
            conn.close();
        }
    }
    
    public ArrayList<PostServiceDTO> getAll() throws Exception{
        ArrayList<PostServiceDTO> list = null;
        PostServiceDTO dto;
        
        int id;
        String title,content,picture;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Title,Content,Picture From PostServices";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                title = rs.getString("Title");
                content = rs.getString("Content");
                picture = rs.getString("Picture");
                
                dto = new PostServiceDTO(id, title, content, picture);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
