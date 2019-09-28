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
public class InfoDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public InfoDAO() {

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

    public InfoDTO getById(int id) throws Exception {
        InfoDTO dto = null;

        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Address,Tel,Email,Picture From Info Where Id = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setInt(1, id);
            rs = preStm.executeQuery();

            if (rs.next()) {
                String address = rs.getString("Address");
                String tel = rs.getString("Tel");
                String email = rs.getString("Email");
                String picture = rs.getString("Picture");
                
                dto = new InfoDTO(id, address, tel, email, picture);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }
}
