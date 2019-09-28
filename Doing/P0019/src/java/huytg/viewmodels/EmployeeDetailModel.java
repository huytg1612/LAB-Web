/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.viewmodels;

import huytg.dtos.EmpServiceDTO;
import huytg.dtos.EmployeeDTO;
import java.util.ArrayList;

/**
 *
 * @author SE130226
 */
public class EmployeeDetailModel{
    public EmployeeDTO employee;
    public ArrayList<EmpServiceDTO> list;

    public EmployeeDetailModel(EmployeeDTO employee, ArrayList<EmpServiceDTO> list) {
        this.employee = employee;
        this.list = list;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ArrayList<EmpServiceDTO> getList() {
        return list;
    }

    public void setList(ArrayList<EmpServiceDTO> list) {
        this.list = list;
    }
    
    
}
