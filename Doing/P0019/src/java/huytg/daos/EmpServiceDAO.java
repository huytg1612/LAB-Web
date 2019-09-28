/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.EmpServiceDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class EmpServiceDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public EmpServiceDAO(){
        
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
    
    public ArrayList<EmpServiceDTO> getByEmpId(int id) throws Exception{
        ArrayList<EmpServiceDTO> list = null;
        EmpServiceDTO dto;
        
        int serviceId;
        String serviceName;
        
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select ServiceId,ServiceName From Emp_Service Where EmployeeId = ?";
            preStm = conn.prepareStatement(sql);
            
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            
            list = new ArrayList<>();
            while(rs.next()){
                serviceId = rs.getInt("ServiceId");
                serviceName = rs.getString("ServiceName");
                
                dto = new EmpServiceDTO(id, serviceId, serviceName);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
