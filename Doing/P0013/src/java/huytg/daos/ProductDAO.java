/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class ProductDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public ProductDAO(){
        
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
    
    public boolean insert(ProductDTO product) throws Exception{        
        boolean isValid;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Insert into Products(Name,Pictrue,Description,Price) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            
            preStm.setString(1, product.getName());
            preStm.setString(2, product.getPicture());
            preStm.setString(3, product.getDescription());
            preStm.setFloat(4, product.getPrice());
            
            isValid = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return isValid;
    }
    
    public ArrayList<ProductDTO> getAll() throws Exception{
        ArrayList<ProductDTO> list;
        ProductDTO dto;
        
        int id;
        String name,picture,description;
        float price;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Name,Picture,Description From Products";
            preStm = conn.prepareStatement(sql);
            
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            
            while(rs.next()){
                id = rs.getInt("Id");
                name = rs.getString("Name");
                picture = rs.getString("Picture");
                description = rs.getString("Description");
                
                dto = new ProductDTO(id, name, picture, description);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
