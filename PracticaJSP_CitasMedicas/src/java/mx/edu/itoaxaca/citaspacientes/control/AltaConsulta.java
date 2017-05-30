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
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "AltaConsulta", urlPatterns = {"/AltaConsulta"})
public class AltaConsulta extends HttpServlet {
    
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
                
        Integer idcita = Integer.parseInt(request.getParameter("idcita"));
            
        emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU"); 
        
        cc = new CitasJpaController(utx, emf);
        co = new ConsultaJpaController(utx, emf);       
        
        Citas cita = cc.findCitas(idcita);
        Paciente paciente = cita.getPaciente();
        
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
            
            out.println("<div class='u-center-block'>");
            out.println("<div class='u-center-block__content u-center-block__content--horizontal'>");    
                                    
            out.println("<div class='c-card u-highest'>");
            out.println("<div class='c-card__item c-card__item--info'>Consulta</div>");            
            out.println("<div class='c-card__item'>");
            
            out.println("<p class=\"c-paragraph\">"
                    + "<h3> Paciente: " + paciente.getNombre() + "</h3>"
                    + "<h4> Fecha de la cita: " + cita.getFecha() + "</h4>"
                    + "<h4> Hora de la cita: " + cita.getHora() + "</h4>"
                    + "</p>");
            
            Consulta cons = getEstatus(cita);
            
            if(cons == null){
                out.println("<form action='AltaConsulta' method='POST'>");
                out.println("<input type='hidden' class=\"c-field\" type=\"text\" name='idpaciente'"
                            + "value='"+paciente.getIdpaciente()+"'"
                            + "display=none>");
                out.println("<input type='hidden' class=\"c-field\" type=\"text\" name='idcita'"
                            + "value='"+cita.getIdcitas()+"'"
                            + " display='none'>");
                out.println("<label class=\"c-label o-form-element\">\n" +
                            "  Diagnostico:\n" +
                            "  <textarea class=\"c-field c-field--label\" name='diagnostico' "
                                + "placeholder=\"Diagnostico\">\n" 
                                + "</textarea> \n"
                            + "</label>");
                out.println("<button type='submit' class=\"c-button c-button--info\">Guardar</button>");
                out.println("</form>");  
            }else{
                out.println("<label class=\"c-label o-form-element\">\n" +
                            "  Diagnostico:\n" +
                            "  <textarea class=\"c-field c-field--label\" name='diagnostico' "
                                + "placeholder=\"Diagnostico\">\n" 
                                + cons.getDiagnostico() +"</textarea> \n"
                            + "</label>");
            }
            out.println("</div>");
            out.println("</div>");
                                                                      
            
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
        //processRequest(request, response);
        //Integer idpaciente = Integer.parseInt(request.getParameter("idpaciente"));
        
        if(request.getParameter("idcita") != null){
            Integer idcita = Integer.parseInt(request.getParameter("idcita"));
            String diagnostico = request.getParameter("diagnostico");

            System.out.println(" d :" + diagnostico);        
            System.out.println(" c :" + idcita);

            emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");                             

            cc = new CitasJpaController(utx, emf);
            co = new ConsultaJpaController(utx, emf);

            Citas cita = cc.findCitas(idcita);                
            Consulta consulta = new Consulta();        
            consulta.setDiagnostico(diagnostico);
            consulta.setIdcita(cita);

            try {
                co.create(consulta);
            } catch (Exception ex) {
                Logger.getLogger(AltaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect("ListCitas?idpaciente=" + cita.getPaciente().getIdpaciente());
        }else{
            response.sendError(404);
        }
        
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
    
    private Consulta getEstatus(Citas dato){              
        List<Consulta> consultas = co.findConsultaEntities();
        
        consultas.removeIf(consulta -> !(consulta.getIdcita().equals(dato)));                
        System.out.println("size: " + consultas.size());        
        
        if(consultas.size() > 0 )
            return consultas.get(0);
        return null;                     
    }

}
