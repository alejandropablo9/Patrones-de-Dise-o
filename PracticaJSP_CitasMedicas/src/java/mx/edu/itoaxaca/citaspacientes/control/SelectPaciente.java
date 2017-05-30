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
import mx.edu.itoaxaca.citaspacientes.control.JPA.PacienteJpaController;
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "SelectPaciente", urlPatterns = {"/SelectPaciente"})
public class SelectPaciente extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;    
    @Resource
    private UserTransaction utx;   
    
    private PacienteJpaController cp;   
    
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
        emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");                     
        cp = new PacienteJpaController(utx, emf);
        List<Paciente> lista = cp.findPacienteEntities();   
        
        try (PrintWriter out = response.getWriter()) {            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"css/normalize.css\" />");
            out.println("<link rel=\"stylesheet\" href=\"css/pure-min.css\" />");
            out.println("<title>Selecciona Paciente</title>");                         
            out.println("</head>");
            out.println("<body>");           
            out.println("<div class=\"content pure-g\">");
            out.println("<div class=\"content pure-u-5-6\">");
            out.println("<form class='pure-form pure-form-aligned' action = 'Calendario' method = 'post' >");
            out.println("<fieldset>");
            out.println("<h1>Selecciona paciente</h1>");
            out.println("<div class='pure-control-group'>");
            out.println("<label for='idpaciente'>Paciente</label>");
            out.println("<select name = 'idpaciente'>");            
            for(Paciente dato : lista){
                out.println("<option value = " + dato.getIdpaciente() + ">");
                out.println("" + dato.getNombre() + "");
                out.println("</option>");
            }            
            out.println("</select>");
            out.println("<div class=\"pure-controls\">");
            out.println("<button type=\"submit\" class=\"pure-button pure-button-primary\">Seleccionar</button>");
            out.println("</div>");           
            out.println("</fieldset>");
            out.println("</div>");     
            out.println("</div>");     
            out.println("</body>");
            out.println("</html>");
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
