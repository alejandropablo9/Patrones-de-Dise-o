/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citas.control;

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
import mx.edu.itoaxaca.citas.modelo.Paciente;

/**
 *
 * @author antonio
 */
@WebServlet(name = "ListaPacientes", urlPatterns = {"/ListaPacientes"})
public class ListaPacientes extends HttpServlet {
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
        try{
            /* TODO output your page here. You may use following sample code. */
            emf = Persistence.createEntityManagerFactory("citasPacientesPU");
            PacienteJpaController cp = new PacienteJpaController(utx,emf);
            List<Paciente> lista = cp.findPacienteEntities();
            
            out.println("<table align='left' width='60%' border=1>");
            out.println("<tr><td class='datos'>ID</td>");
            out.println("<td class='datos'>Nombre</td>");
            out.println("<td class='datos'>Fecha Nacimiento</td>");
            out.println("<td class='datos'>Edad</td>");
            out.println("<td class='datos'>Estatura</td>");
            out.println("<td class='datos'>Sexo</td>");
            out.println("</tr>");
            
            int promedioEstatura = 0;
            int edades = 0;
            for(Paciente dato : lista){
                out.println("<tr>"+
                        "<td class='datos'>"+dato.getIdpaciente()+"</td>"+
                        "<td class='datos'>"+dato.getNombre()+"</td>"+
                        "<td class='datos'>"+dato.getFechana()+"</td>"+
                        "<td class='datos'>"+dato.getEdad()+"</td>"+
                        "<td class='datos'>"+dato.getEstatura()+"</td>"+
                        "<td class='datos'>"+dato.getSexo()+"</td>"+
                        "</tr>");
                promedioEstatura += dato.getEstatura(); 
                edades += dato.getEdad();
            }
            
            float prom = promedioEstatura/lista.size();
            float promEdad = edades/lista.size();
            out.println("<tr>"+
                        "<td class='datos'>Promedio:</td>"+
                        "<td class='datos'></td>"+
                        "<td class='datos'></td>"+
                        "<td class='datos'>"+promEdad +"</td>"+
                        "<td class='datos'>"+prom+"</td>"+
                        "</tr>");
            
            out.println("</table>");
            out.println("<br/>");
//            out.println("<a href\"index.jsp\">Regresar al Inicio </a>");
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
