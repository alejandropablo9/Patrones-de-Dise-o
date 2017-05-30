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
import mx.edu.itoaxaca.citaspacientes.modelo.Citas;
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;
/**
 *
 * @author alejandro
 */
@WebServlet(name = "NuevaCita", urlPatterns = {"/NuevaCita"})
public class NuevaCita extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    private CitasJpaController cc;
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
        PrintWriter out = response.getWriter();
        emf = Persistence.createEntityManagerFactory("PracticaJSP_CitasMedicasPU");             
        cc = new CitasJpaController(utx, emf);
        cp = new PacienteJpaController(utx, emf);
        try {                        
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            Integer idpaciente = Integer.parseInt(request.getParameter("paciente"));
            Date _fecha = formatoDate(fecha, "yyyy-MM-dd");            
            Date _hora = formatoDate(hora, "HH:mm:ss");
            
            String mensaje = "";            
            Citas citas = new Citas();            
            Paciente paciente = encuentraPaciente(idpaciente);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NuevaCita</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(paciente != null){
                if(horarioDisponible(_fecha, _hora)){                    
                    citas.setFecha(_fecha);
                    citas.setHora(_hora);            
                    citas.setPaciente(paciente);                         
                    out.println("<h1>Servlet AltaPaciente at " + request.getContextPath() + "</h1>");
                    out.println("<h4> Feha:" +  citas.getFecha() + "</h4>");
                    out.println("<h4> Hora: " + citas.getHora() + "</h4>");
                    out.println("<h4> Paciente: " + citas.getPaciente() + "</h4>");
                    try {
                        cc.create(citas);                
                    }catch(Exception e){
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Error</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Error al agregar cita </h1>");
                        out.println("<h1>" + e + "</h1>");                        
                        out.println("</body>");                        
                        out.println("</html>");
                    }
                }else{
                    mensaje = "el horario no esta disponible";
                }
            }else{
                mensaje = "el paciente no esta registrado";
            }
            out.println("<h4>" + mensaje + "</h4>");
            out.println("<a href = 'nuevaCita.jsp' > Nueva cita </a> ");
            out.println("</body>");
            out.println("</html>"); 
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
    
    private Date formatoDate(String _date, String formato) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat(formato);
        Date date = null;
        date = df.parse(_date);
        return date;
    }
    
    private Paciente encuentraPaciente(int id){                      
        return cp.findPaciente(id);
    }
    
    private boolean horarioDisponible(Date _fecha, Date _hora){      
        List <Citas>citas = cc.findCitasEntities();
        
        Citas citaExiste = null; 
        for(Citas cita : citas){
            if (cita.getFechaD().equals(_fecha) &&
            cita.getHoraD().equals(_hora)){
                citaExiste = cita;
                break;
            }
        }
        return citaExiste == null;
    }

}
