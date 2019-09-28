/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.main.controller;

import huytg.daos.CourseDAO;
import huytg.daos.EmployeeDAO;
import huytg.daos.InfoDAO;
import huytg.daos.PostDAO;
import huytg.dtos.CourseDTO;
import huytg.dtos.EmployeeDTO;
import huytg.dtos.InfoDTO;
import huytg.dtos.PostDTO;
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
    private static final String SUCCESS = "index.jsp";

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
            //System.out.println("123");
            
            PostDAO postDao = new PostDAO();
            CourseDAO courseDao = new CourseDAO();
            EmployeeDAO empDao = new EmployeeDAO();
            InfoDAO infoDao = new InfoDAO();

            ArrayList<PostDTO> listPost = postDao.getAll();
            ArrayList<CourseDTO> listCourse = courseDao.getAll();
            EmployeeDTO empDTO = empDao.getFirst();
            InfoDTO infoDTO = infoDao.getInfo(1);

            request.setAttribute("POSTS", listPost);
            request.setAttribute("COURSES", listCourse);
            request.setAttribute("EMPLOYEE", empDTO);
            request.setAttribute("INFO", infoDTO);
        } catch (Exception e) {
            url = ERROR;
            log("Error at PostLoadController: " + e.getMessage());
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
