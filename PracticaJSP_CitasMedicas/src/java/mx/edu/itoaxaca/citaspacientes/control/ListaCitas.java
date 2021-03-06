/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.citaspacientes.modelo.Citas;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "ListaCitas", urlPatterns = {"/ListaCitas"})
public class ListaCitas extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;    
    @Resource
    private UserTransaction utx;
    
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
        PrintWriter out = response.getWriter();
        try {
            emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");
            CitasJpaController control = new CitasJpaController(utx, emf);
            List<Citas> lista = control.findCitasEntities();

            out.println("<table class='pure-table pure-table-bordered'>");         
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Fecha</th>");
            out.println("<th>Hora</th>");
            out.println("<th>Paciente</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for(Citas dato : lista){
                out.println("<tr>");
                out.println("<td>" + dato.getIdcitas() + "</td>");
                out.println("<td>" + dato.getFecha()  + "</td>");
                out.println("<td>" + dato.getHora()  + " </td>");
                out.println("<td>" + dato.getPaciente().getNombre() +"</td>");                
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("<br>");
            out.println("<a href=\"index.jsp\"> Inicio </a>");
            emf.close();           
        }catch(Exception e){            
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
