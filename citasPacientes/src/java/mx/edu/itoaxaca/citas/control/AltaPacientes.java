/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citas.control;

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
import mx.edu.itoaxaca.citas.modelo.Paciente;

/**
 *
 * @author antonio
 */
@WebServlet(name = "AltaPacientes", urlPatterns = {"/AltaPacientes"})
public class AltaPacientes extends HttpServlet {
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
        try (PrintWriter out = response.getWriter()) {
                      String nombrep = request.getParameter("nombrep");
          String fechan = request.getParameter("fechap");
          Integer Estatura = Integer.parseInt(request.getParameter("estaturap"));
          Character sexo = request.getParameter("sexop").toCharArray()[0];
        
          SimpleDateFormat formatoF= new SimpleDateFormat("yyyy-MM-dd");
          Date fe = new Date();
          try {
              fe = formatoF.parse(fechan);
          } catch(ParseException ex){
              System.out.println(ex);
          }
            
            Paciente paciente=new Paciente();
            paciente.setNombre(nombrep);
            paciente.setFechana(fe);
            paciente.setSexo(sexo);
            paciente.setEstatura(Estatura);
            
            emf = Persistence.createEntityManagerFactory("citasPacientesPU");
            PacienteJpaController control=new PacienteJpaController(utx,emf);
              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Pacientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos del paciente " + request.getContextPath() + "</h1>");
            out.println("<h2>Nombre :" + paciente.getNombre() + "</h2>");
            out.println("<h2>Fecha :" + paciente.getFechana()+ "</h2>");
            out.println("<h2>Estatura :" + paciente.getEstatura()+ "</h2>");
            out.println("<h2>Sexo :" + paciente.getSexo()+ "</h2>");
            out.println("</body>");
            out.println("</html>");
            try{
              control.create(paciente);
              response.sendRedirect("index.jsp");
            }
            catch(Exception e){
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al agregar paciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            }
            finally{
            out.close();
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
