/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AltaPaciente", urlPatterns = {"/AltaPaciente"})
public class AltaPaciente extends HttpServlet {
    
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
        String nombre = request.getParameter("nombre");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fechat = request.getParameter("fecha");      
        Date fecha = null;
        Integer estatura = Integer.parseInt(request.getParameter("estatura"));
        Character sexo = request.getParameter("sexo").toCharArray()[0];
        try {
            fecha = df.parse(fechat);            
        } catch (ParseException ex) {                
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */            
            Paciente paciente = new Paciente();
            paciente.setNombre(nombre);
            paciente.setFechanac(fecha);
            paciente.setSexo(sexo);
            paciente.setEstatura(estatura);
            emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");
            PacienteJpaController control = new PacienteJpaController(utx, emf);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaPaciente at " + request.getContextPath() + "</h1>");            
            out.println("<h2> Nombre:" + paciente.getNombre() + "</h2>");
            out.println("<h4> Feha de nacimiento :" + paciente.getFechanac() + "</h4>");
            out.println("<h4> Estatura: " + paciente.getEstatura() + "</h4>");
            out.println("<h4> Sexo: " + paciente.getSexo() + "</h4>");
            out.println("</body>");                        
            out.println("</html>");
            
            try {
                control.create(paciente);
                //response.sendRedirect("index.jsp");
            }catch(Exception e){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error al agregar paciente</h1>");                        
            out.println("</body>");                        
            out.println("</html>");
            }
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
