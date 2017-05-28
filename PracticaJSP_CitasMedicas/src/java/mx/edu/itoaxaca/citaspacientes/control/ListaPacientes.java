/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

/**
 *
 * @author alejandro
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
            double promedioEdad = 0;
            double promedioEstatura = 0;
            emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");
            PacienteJpaController cp = new PacienteJpaController(utx, emf);
            List<Paciente> lista = cp.findPacienteEntities(); 
            out.println("<table class='pure-table pure-table-bordered'>");         
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Edad (años)</th>");
            out.println("<th>Estatura (cm)</th>");
            out.println("<th>Sexo</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for(Paciente dato : lista){
                promedioEdad += this.getEdad(dato);
                promedioEstatura += dato.getEstatura();                
                out.println("<tr>");
                out.println("<td>" + dato.getIdpaciente() + "</td>");
                out.println("<td>" + dato.getNombre()   + "</td>");
                out.println("<td>" + this.getEdad(dato) +" </td>");
                out.println("<td>" + dato.getEstatura() +" cm </td>");
                out.println("<td>" + dato.getSexo() +"</td>");
                out.println("</tr>");
            }
            out.println("<tr>");
                out.println("<td>-</td>");                
                out.println("<td>Promedio:</td>");
                out.println("<td>" + (promedioEdad/lista.size()) +"</td>");
                out.println("<td>" + (promedioEstatura/lista.size()) +"</td>");
                out.println("<td>-</td>");
                out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("<br>");
            out.println("<a href=\"index.jsp\"> Inicio </a>");
            emf.close();           
        }catch(Exception e){            
        }
    }
    
    public int getEdad(Paciente dato){     
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(dato.getFechanac(), fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        //System.out.printf("Tu edad es: %s años, %s meses y %s días",
        //            periodo.getYears(), periodo.getMonths(), periodo.getDays());
        return periodo.getYears();
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
