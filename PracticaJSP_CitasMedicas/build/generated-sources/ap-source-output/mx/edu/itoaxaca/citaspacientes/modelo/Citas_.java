package mx.edu.itoaxaca.citaspacientes.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.edu.itoaxaca.citaspacientes.modelo.Consulta;
import mx.edu.itoaxaca.citaspacientes.modelo.Paciente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-30T19:03:30")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, Date> fecha;
    public static volatile CollectionAttribute<Citas, Consulta> consultaCollection;
    public static volatile SingularAttribute<Citas, Integer> idcitas;
    public static volatile SingularAttribute<Citas, Date> hora;
    public static volatile SingularAttribute<Citas, Paciente> paciente;

}