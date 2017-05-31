/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import mx.edu.itoaxaca.citaspacientes.control.JPA.ConsultaJpaController;
import mx.edu.itoaxaca.citaspacientes.modelo.Citas;
import mx.edu.itoaxaca.citaspacientes.modelo.Consulta;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "EliminarCita", urlPatterns = {"/EliminarCita"})
public class EliminarCita extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;    
    @Resource
    private UserTransaction utx;  
    
    private CitasJpaController cc;
    private ConsultaJpaController co;
    
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
        cc = new CitasJpaController(utx, emf);
        co = new ConsultaJpaController(utx, emf);
        
        String _idcita = request.getParameter("idcita");
        Integer idcita = Integer.parseInt(_idcita);        
        Citas cita = cc.findCitas(idcita);
        
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarCita at " + request.getContextPath() + "</h1>");
            if(!getEstatus(cita)){
                cc.destroy(idcita);
                response.sendRedirect("ListCitas?idpaciente="+cita.getPaciente().getIdpaciente());
            }else{
                out.println("La cita ya tiene un diagnostico");
                out.println("<a href='ListCitas?idpaciente="+cita.getPaciente().getIdpaciente() +"'>Lista citas </a>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e){
            Logger.getLogger(EliminarCita.class.getName()).log(Level.SEVERE, null, e);
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
    
    private boolean getEstatus(Citas dato) {                
        List<Consulta> consultas = co.findConsultaEntities();
        
        consultas.removeIf(consulta -> !(consulta.getIdcita().equals(dato)));                
        System.out.println("size: " + consultas.size());        
        return (!consultas.isEmpty()); 
                
    }

}
