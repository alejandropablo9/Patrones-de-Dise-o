/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "CITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByIdcitas", query = "SELECT c FROM Citas c WHERE c.idcitas = :idcitas")
    , @NamedQuery(name = "Citas.findByFecha", query = "SELECT c FROM Citas c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Citas.findByHora", query = "SELECT c FROM Citas c WHERE c.hora = :hora")})
public class Citas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcita")
    private Collection<Consulta> consultaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCITAS")
    private Integer idcitas;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "PACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne
    private Paciente paciente;

    public Citas() {
    }

    public Citas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Integer getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public String getFecha() {
        return formatoDate(fecha, "yyyy-MM-dd");
    }
    
    public Date getFechaD() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return formatoDate(hora, "HH:mm:ss");
    }
    
    public Date getHoraD() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcitas != null ? idcitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idcitas == null && other.idcitas != null) || (this.idcitas != null && !this.idcitas.equals(other.idcitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.itoaxaca.citaspacientes.modelo.Citas[ idcitas=" + idcitas + " ]";
    }
    
    private String formatoDate(Date time, String formato) {
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(time);
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }
    
}
