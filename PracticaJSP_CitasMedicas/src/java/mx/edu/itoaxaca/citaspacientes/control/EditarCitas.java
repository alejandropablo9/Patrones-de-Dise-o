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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import mx.edu.itoaxaca.citaspacientes.control.JPA.PacienteJpaController;
import mx.edu.itoaxaca.citaspacientes.modelo.Citas;
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "EditarCitas", urlPatterns = {"/EditarCitas"})
public class EditarCitas extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;    
    @Resource
    private UserTransaction utx;   
    
    private PacienteJpaController cp;     
    private CitasJpaController cc;
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
        cc = new CitasJpaController(utx, emf);
        
        String idT = request.getParameter("idpaciente");       
        String diaselT = request.getParameter("diasel");                
        String idcitaT = request.getParameter("idcita");
        
        Integer id = 0;
        Integer diasel = 0;
        Integer idcita = 0;
        
        PrintWriter out = response.getWriter();
        
        if(idT != null)
            id = Integer.parseInt(idT);
        if(diaselT != null)
            diasel = Integer.parseInt(diaselT);
        if(idcitaT != null)
            idcita = Integer.parseInt(idcitaT);
        
        Paciente paciente = cp. findPaciente(id);                        
        Citas cita = cc.findCitas(idcita);
        
        Calendar calendar = Calendar.getInstance();
        calendar.getFirstDayOfWeek();
        
        try{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel='stylesheet' href='css/normalize.css' />");
            out.println("<link rel='stylesheet' href='css/blaze.min.css' />");         
            
            out.println("<title>Cita</title>");                                     
            out.println("</head>");
            out.println("<body>");
            out.println("<main class='o-container o-container--large u-pillar-box--small'>");
            out.println("<section class='u-letter-box--super'>");
            out.println("<div class='o-grid o-grid--xsmall-full o-grid--small-full o-grid--medium-full'>");            
            out.println("<div class='c-card'>");
            out.println("<div class='c-card__item'>");  
            out.println ("<h2 class='c-heading c-heading--medium'>Paciente</h2>");
            out.println(" <p class='c-paragraph'>");
            if(paciente != null){
                out.println("<h3 class='c-heading c-heading--medium'>"
                                            + paciente.getNombre() +
                                    "</h3>"); 
                out.println("<h4> Fecha de nacimiento: "+ paciente.getFechanac() +"</h4>");
                out.println("<h4> Estatura: "+ paciente.getEstatura() +"</h4>");
                out.println("<h4> Sexo: "+ paciente.getSexo() +"</h4>");
            } else{
                out.println("<h3 class='c-heading c-heading--medium'>Seleccione un paciente</h3>"); 
            }
            out.println("</p>");                       
            out.println("</div>");
            out.println("</div>");
            
            int yy = 0, mm = 0;

            Calendar c = Calendar.getInstance();
            //año
            yy = c.get(Calendar.YEAR);
            //mes
            mm = c.get(Calendar.MONTH);
            //formato fecha
            String ffecha = formatoDateString(formatoDate(yy+"-"+(mm+1)+"-"+diasel, "yyyy-MM-dd"), "yyyy-MM-dd");
            
            // dias de cada mes
            String meses[] = {
                "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
                "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
            };
            // dias de cada mes
            int dom[] = {
                31, 28, 31, 30,  
                31, 30, 31, 31, 
                30, 31, 30, 31 
            };
            int diassemanas = 0;           
            GregorianCalendar calendario = new GregorianCalendar(yy, mm,1); 
            //obtenermos los dias de la semana
            diassemanas = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        
            int daysInMonth = dom[mm];
            //validar si es bisiesto y si el mes el febrero 
            if (calendario.isLeapYear(calendar.get(Calendar.YEAR)) && mm == 1){
                daysInMonth++;
            }
            
            out.println("<div class=\"c-calendar c-calendar--higher\">");
            out.println("<button class=\"c-calendar__control\">‹</button>");
            out.println("<div class=\"c-calendar__header\">"+ yy +"</div>");
            out.println("<button class=\"c-calendar__control\">›</button>");
            out.println("<button class=\"c-calendar__control\">‹</button>");
            out.println("<div class=\"c-calendar__header\">" + meses[mm] + "</div>");
            out.println("<button class=\"c-calendar__control\">›</button>");
            
            out.println("<div class=\"c-calendar__day\">Dom</div>");
            out.println("<div class=\"c-calendar__day\">Lun</div>");
            out.println("<div class=\"c-calendar__day\">Mar</div>");
            out.println("<div class=\"c-calendar__day\">Mie</div>");            
            out.println("<div class=\"c-calendar__day\">Jue</div>");
            out.println("<div class=\"c-calendar__day\">Vie</div>");
            out.println("<div class=\"c-calendar__day\">Sab</div>");            
             //blanquear etiquetas
            for (int i = 0; i < diassemanas; i++) {
                out.println("<button class=\"c-calendar__date c-calendar__date--in-month\">&nbsp;</button>");
            }
            
            for (int i = c.get(Calendar.DAY_OF_MONTH); i <= daysInMonth; i++) {
                String estaFecha = yy+"-"+(mm+1)+"-"+ i;
                if(diaDisponible(formatoDate(estaFecha, "yyyy-MM-dd"))){
                    out.println("<a href='EditarsCita?idcita=" + idcita +"&idpaciente="+id+"&diasel=" + i + "' "
                        + "class=\"c-calendar__date c-calendar__date--in-month\">" + i +"</a>");
                }
                else{
                    out.println(""
                        + "<a href='EditarCitas?idcita=" + idcita +"&idpaciente="+id+"&diasel=" + i + "' "
                        + "class=\"c-calendar__date c-calendar__date--in-month c-calendar__date--selected\">" 
                            + i +"</a>");
                }
            }                        
            out.println("</div>"); 
            
            if(diaselT != null && paciente != null){
                out.println("<div class=\"o-container o-container--xsmall\">");
                    out.println("<form action='EditCita' metod='POST'>");
                    out.println("<div class=\"c-input-group c-input-group--stacked\">");
                    out.println("<h3>Datos de la cita</h3>");
                    out.println("<div class=\"o-field\">");      
                     out.println("<label for=\"idcita\">Fecha</label>");                
                    out.println("<input class=\"c-field\" name='idcita' value='"
                            +cita.getIdcitas()+"' type='hidden'>");
                    out.println("<label for=\"fecha\">Fecha</label>");                
                    out.println("<input class=\"c-field\" name='fecha' value='"
                            +ffecha+"' readonly>");                    
                    out.println("</div>"); 
                    out.println("<div class=\"o-field\">");   
                    out.println("<label for='hora'>Hora</label>");                 
                    out.println("<input class=\"c-field\" name='hora' type='time' value=\"10:00:00\" max=\"20:00:00\" min=\"10:00:00\" step=\"1\">"); 
                    out.println("</div>"); 
                    out.println("<div class=\"o-field\">"); 
                    out.println("<label for='paciente'>Paciente</label>"); 
                    out.println("<select class=\"c-field\" name=\"paciente\">");
                     out.println("<option value='"+ id +"'> "+ paciente.getNombre() +"</option>");         
                     out.println("</select>");                       
                    out.println("</div>"); 
                    out.println("<div class=\"o-field\">"); 
                    out.println("<button type=\"submit\" class=\"c-button c-button--info\">Guardar</button>");
                    out.println("</div>");    
                    out.println("</div>");
                    out.println("</form>");
                out.println("</div>");
            }
            out.println("</div>");
            out.println("</section>");
            out.println("</main>");
            out.println("</body>");
            out.println("</html>");
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

    private boolean diaDisponible(Date _fecha) {    
        List <Citas>citas = cc.findCitasEntities();
        
        Citas citaExiste = null; 
        for(Citas cita : citas){
            if (cita.getFechaD().equals(_fecha)){
                citaExiste = cita;
                break;
            }
        }
        return citaExiste == null;
    }    
    
    private Date formatoDate(String time, String formato) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(formato);
            return df.parse(time);
        } catch (ParseException ex) {
            Logger.getLogger(EditarCitas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private String formatoDateString(Date time, String formato) {
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(time);
    }

}
