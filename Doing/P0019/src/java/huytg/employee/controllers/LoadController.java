/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.employee.controllers;

import huytg.daos.EmpServiceDAO;
import huytg.daos.EmployeeDAO;
import huytg.dtos.EmpServiceDTO;
import huytg.dtos.EmployeeDTO;
import huytg.viewmodels.EmployeeDetailModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SE130226
 */
public class LoadController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "employee.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS;

        try {
            EmployeeDAO empDAO = new EmployeeDAO();
            EmpServiceDAO empSerDAO = new EmpServiceDAO();

            ArrayList<EmployeeDTO> listEmp = empDAO.getAll();
            ArrayList<EmployeeDetailModel> listView = new ArrayList<>();
            
            for (EmployeeDTO emp : listEmp) {
                ArrayList<EmpServiceDTO> listEmpService = empSerDAO.getByEmpId(emp.getId());
                listView.add(new EmployeeDetailModel(emp,listEmpService));
            }
            
            request.setAttribute("EMPLOYEES", listView);
        } catch (Exception e) {
            url = ERROR;
            log("Error at EmployeeLoadController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
