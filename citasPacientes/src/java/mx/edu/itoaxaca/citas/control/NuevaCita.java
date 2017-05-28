/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
import mx.edu.itoaxaca.citas.modelo.Citas;
import mx.edu.itoaxaca.citas.modelo.Paciente;

/**
 *
 * @author antonio
 */
@WebServlet(name = "NuevaCita", urlPatterns = {"/NuevaCita"})
public class NuevaCita extends HttpServlet {
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
            String fecha = request.getParameter("fechap");
            System.out.println("Fecha recibida: "+fecha);
            String hora = request.getParameter("horap");
            String minuto = "00";//request.getParameter("minutop");
            String idPaciente = request.getParameter("pacientep");
            
            boolean EstatusPeticion = false;
            String Mensaje = "OK";
            
            if("".equals(fecha) || fecha == null){
                EstatusPeticion = true;  
                Mensaje = "Debe Seleccionar la fecha";
            }
            
            if("".equals(hora) || hora == null){
                EstatusPeticion = true;    
                Mensaje = "Debe Seleccionar la hora";          
            }
            
            if("".equals(minuto) || minuto == null){
                EstatusPeticion = true;        
                Mensaje = "Debe Seleccionar el minuto";      
            }
            
            SimpleDateFormat formatoF= new SimpleDateFormat("yyyy-MM-dd");
            Date fe = new Date();
            try {
                fe = formatoF.parse(fecha);
            } catch(ParseException ex){
                EstatusPeticion = true;        
                Mensaje = "Error en la fecha"; 
                System.out.println(ex);
            }
            fe.setHours(Integer.parseInt(hora));
            fe.setMinutes(Integer.parseInt(minuto));
            fe.setSeconds(Integer.parseInt("00"));            
            Timestamp timestamp = new Timestamp(fe.getTime());
            
            if("".equals(idPaciente) || idPaciente == null){
                EstatusPeticion = true;      
                Mensaje = "Debe Escribir el id de un paciente";        
            }
            System.out.println(timestamp+" "+idPaciente);
            System.out.println(Mensaje);
            
            
            
            emf = Persistence.createEntityManagerFactory("citasPacientesPU");
            int paciente = Integer.parseInt(idPaciente);
            if(ExistePaciente(paciente)){
                if(FechaValida(fe)){
                    if(HorarioDisponible(fe,Integer.parseInt(hora))){
                        Citas cita = new Citas();
                        cita.setFecha(fe);
                        cita.setHora(timestamp);                
                        cita.setIdpaciente(paciente);



                        emf = Persistence.createEntityManagerFactory("citasPacientesPU");
                        CitasJpaController control=new CitasJpaController(utx,emf);
    
                        try{
                          control.create(cita);
                          response.sendRedirect("index.jsp");
                        }
                        catch(Exception e){
    
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Error al agregar Cita</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Error " + request.getContextPath() + "</h1>");
                        out.println("</body>");
                        out.println("</html>");
    
                    }
                    finally{
                    out.close();
                    }               

                    }else{
                        EstatusPeticion = true;      
                        Mensaje = "EL horario NO esta disponible";                    
                    }                    
                }else{
                  EstatusPeticion = true;
                  Mensaje = "Fecha Invalida";
                }                                                          
            }else{
                EstatusPeticion = true;      
                Mensaje = "La referencia del paciente no existe";  
            }
            
            if(EstatusPeticion){
                out.println(
                "<head>"+
                "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"+
                    "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">"+
                   "<title>Nueva Cita</title>"+
               "</head>"+
               "<body>"+
                   "<h1>"+Mensaje+"</h1>"+
                   "<h1>Nueva Cita</h1>"+
                   "<form action=\"NuevaCita\" method=\"POST\">"+
                         "<div class=\"form-group row\">"+
                           "<label for=\"fechap\" class=\"col-sm-2 col-form-label col-form-label-sm\">Fecha</label>"+
                           "<div class=\"col-sm-10\">"+
                               "<input type=\"date\" class=\"form-control form-control-sm\" id=\"fechap\" name=\"fechap\" values="+ fecha +" required>"+
                           "</div>"+
                         "</div>"+
                         "<div class=\"form-group row\">"+
                           "<label for=\"horap\" class=\"col-sm-2 col-form-label col-form-label-sm\">Hora </label>"+
                           "<div class=\"col-sm-2\">"+
                               "<input type=\"number\" class=\"form-control form-control-sm\" min=\"9\" max=\"22\" id=\"fechap\" name=\"horap\" value="+ hora +" required>"+
                           "</div>"+
                           "<div class=\"col-sm-2\">"+
                               "<input type=\"number\" class=\"form-control form-control-sm\" max=\"60\" id=\"minutop\" name=\"minutop\" value="+ minuto +">"+
                           "</div>"+
                         "</div>"+
                         "<div class=\"form-group row\">"+
                           "<label for=\"pacientep\" class=\"col-sm-2 col-form-label col-form-label-sm\">Paciente </label>"+
                           "<div class=\"col-sm-10\">"+
                               "<input type=\"number\" class=\"form-control form-control-sm\" id=\"estaturap\" name=\"pacientep\" value="+ idPaciente +" required>"+
                           "</div>"+
                         "</div>"+
                         "<button type=\"submit\" class=\"btn btn-primary\">Submit</button>"+
                     "</form>"+
               "</body>");
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
    
    private boolean ExistePaciente(int id){
        EntityManagerFactory emf1;
        emf1 = Persistence.createEntityManagerFactory("citasPacientesPU");
        PacienteJpaController control2=new PacienteJpaController(utx,emf1);
        Paciente pac = control2.findPaciente(id);
        if(pac != null){
            System.out.println(pac.getNombre());
            return true;
        }else{
            System.out.println("Paciente no encontrado");
            return false;
        }        
    }
    
    private boolean HorarioDisponible(Date fecha,int hora){
        boolean Estado = true;
         EntityManagerFactory emf1;
        emf1 = Persistence.createEntityManagerFactory("citasPacientesPU");
        CitasJpaController control2=new CitasJpaController(utx,emf1);
        List <Citas>citas = control2.findCitasEntities();
        boolean estado = true;
        for(Citas dato : citas){
            Timestamp timestamp = new Timestamp(dato.getHora().getTime());
            int h = timestamp.getHours();
            
            System.out.println(dato.getHora());
            if(fecha.compareTo(dato.getFecha()) == 1){
                
                if(h == hora){
                    System.out.println("HAY UNA CITA EN ESE HORARIO"); 
                    Estado = false;
                }                  
            }          
        }
        return Estado;
    }
    private boolean FechaValida(Date fecha){
        boolean Estado = true;
        Date hoy = new Date();
        System.out.println(fecha.compareTo(hoy));
        if(fecha.compareTo(hoy) == -1){
            Estado = false;                       
        }       
        return Estado;
    }

}
