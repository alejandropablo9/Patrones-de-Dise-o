/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import mx.edu.itoaxaca.citaspacientes.modelo.Citas;
/**
 *
 * @author alejandro
 */
@WebServlet(name = "ListCitas", urlPatterns = {"/ListCitas"})
public class ListCitas extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;    
    @Resource
    private UserTransaction utx;   
    private PacienteJpaController cp;   
    private CitasJpaController cc;
    private List<Citas> lista;
    private List<Citas> filtrada;
    
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
        cp = new PacienteJpaController(utx, emf);
        
        String idpacienteparam = request.getParameter("idpaciente");
        int idpaciente = 0;
        Paciente paciente = null;
        PrintWriter out = response.getWriter();
        lista = cc.findCitasEntities();
        
        if(idpacienteparam != null){
            idpaciente = Integer.parseInt(idpacienteparam);
            paciente = cp.findPaciente(idpaciente);
            filtrarCitasxPaciente(paciente);
        }
                                
        
        try {
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
            out.println("<h1 class='c-heading c-heading--medium'> Citas</h1>");
            out.println("<h2 class='c-heading c-heading--medium'> Paciente: "
                    + paciente.getNombre() + " </h2>");
                        
            out.println("<table class='c-table c-table--striped'>");
            out.println("<thead class='c-table__head'>");
            out.println("<tr class='c-table__row c-table__row--heading'>");
            out.println("<th class='c-table__cell'> ID </th>");
            out.println("<th class='c-table__cell'> Fecha </th>");
            out.println("<th class='c-table__cell'> HORA </th>");
            out.println("<th class='c-table__cell'> Paciente </th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody class='c-table__head' >");
                        
            for(Citas dato : lista){
                out.println("<tr class='c-table__row'>");
                out.println("<td class='c-table__cell'>" + dato.getIdcitas() + "</td>");
                out.println("<td class='c-table__cell'>" + dato.getFecha()  + "</td>");
                out.println("<td class='c-table__cell'>" + dato.getHora()  + " </td>");
                out.println("<td class='c-table__cell'>" + dato.getPaciente().getNombre() +"</td>");  
                out.println("</tr>");
            }                        
            
            out.println("</tbody>");
            out.println("</table>");
            
            out.println("</section>");
            out.println("</main>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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

    private void filtrarCitasxPaciente(Paciente paciente) {        
        lista.removeIf(cita -> (!cita.getPaciente().equals(paciente)));
    }    

}
