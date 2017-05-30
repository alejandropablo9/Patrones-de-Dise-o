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
import mx.edu.itoaxaca.citaspacientes.control.JPA.PacienteJpaController;
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "BuscarPaciente", urlPatterns = {"/BuscarPaciente"})
public class BuscarPaciente extends HttpServlet {
    
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
        
        String nombrepaciente = request.getParameter("nombrepaciente");                 
        
        if(nombrepaciente != null)
            nombrepaciente = !(nombrepaciente.equals(""))? nombrepaciente: null;
        
        List<Paciente> lista = null;
        
        if(nombrepaciente != null){
            lista = cp.findPacienteWithName(nombrepaciente);
        }else{
            lista = cp.findPacienteEntities();
        }
                
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel='stylesheet' href='css/normalize.css' />");
            out.println("<link rel='stylesheet' href='css/blaze.min.css' />");         
            
            out.println("<title>Cita</title>");                                     
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='o-container o-container--xlarge o-grid o-grid--wrap o-grid--top o-grid--small-full o-grid--medium-full'>");    
            out.println("<main class='o-grid__cell o-grid__cell--width-80'>");
            out.println("<section>");
            out.println("<h1 class='c-heading c-heading--medium'> Pacientes</h1>");
            
            out.println("<form action='BuscarPaciente' method='GET'>");
            out.println("<div class=\"c-input-group\">");
            out.println("<div class=\"o-field o-field--icon-right\">");
            out.println("<input class=\"c-field\" name='nombrepaciente' type=\"text\" placeholder='Nombre'>");
             out.println("<i class=\"fa fa-fw fa-search c-icon\"></i>");
            out.println("</div>");
            out.println("<button type='submit' class=\"c-button c-button--info\">Buscar</button>");
            out.println("</div>");
            out.println("</form>");
                        
            out.println("<table class='c-table c-table--striped'>");
            out.println("<thead class='c-table__head'>");
            out.println("<tr class='c-table__row c-table__row--heading'>");
            out.println("<th class='c-table__cell'> ID </th>");
            out.println("<th class='c-table__cell'> NOMBRE </th>");
            out.println("<th class='c-table__cell'> CUMPLEAÑOS </th>");
            out.println("<th class='c-table__cell'> EDAD </th>");
            out.println("<th class='c-table__cell'> ESTATURA </th>");
            out.println("<th class='c-table__cell'> SEXO </th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody class='c-table__head' >");

            for(Paciente dato : lista){
                out.println("<tr class='c-table__row'>");
                out.println("<td class='c-table__cell'>" + dato.getIdpaciente() + "</td>");
                out.println("<td class='c-table__cell'>" + dato.getNombre()  + "</td>");
                out.println("<td class='c-table__cell'>" + dato.getFechanac()  + " </td>");
                out.println("<td class='c-table__cell'>" + getEdad(dato) + " </td>");
                out.println("<td class='c-table__cell'>" + dato.getEstatura() +" cm </td>");
                out.println("<td class='c-table__cell'>" + dato.getSexo() +"</td>");
                out.println("</tr>");                                      
            }
            
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("</section>");
            out.println("</main>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
