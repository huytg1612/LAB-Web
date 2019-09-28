/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.dtos;

import java.io.Serializable;

/**
 *
 * @author SE130226
 */
public class EmployeeDTO implements Serializable{
    private int id;
    private String name,picture,description;

    public EmployeeDTO(int id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public EmployeeDTO(int id, String name, String picture, String description) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.description = description;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
