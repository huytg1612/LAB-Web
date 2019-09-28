/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.daos;

import huytg.conn.MyConnection;
import huytg.dtos.ScheduleDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class ScheduleDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public ScheduleDAO(){
        
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
    
    public ArrayList<ScheduleDTO> getByInfoId(int infoId) throws Exception{
        ArrayList<ScheduleDTO> list = null;
        
        ScheduleDTO dto;
        
        int id;
        String weekDay,openAt,closeAt;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Id,Weekday,OpenAt,CloseAt From Schedules Where InfoId = ?";
            preStm = conn.prepareStatement(sql);
            
            preStm.setInt(1, infoId);
            rs = preStm.executeQuery();
            
            list = new ArrayList();
            while(rs.next()){
                id = rs.getInt("Id");
                weekDay = rs.getString("WeekDay");
                openAt = rs.getString("OpenAt");
                closeAt = rs.getString("CloseAt");
                
                dto = new ScheduleDTO(id, weekDay, openAt, closeAt, infoId);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        
        return list;
    }
}
