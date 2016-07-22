package Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@ManagedBean
@SessionScoped
public class proveedor {
    private Date fecha_re_provee;
    private String fecha_re_provee_ac;
    private String nom_provee;
    private String contr_provee;
    private String Id_porvee;
    private String correo_provee;


    public proveedor() throws DatatypeConfigurationException {
        fecha_re_provee= new Date();
        fecha_re_provee_ac=fecha_x_comparar(fecha_re_provee);
    }        
    
    
    
    public String fecha_x_comparar(Date fecha) throws DatatypeConfigurationException{
        //fecha_actual= new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fecha);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar gc = date2.toGregorianCalendar();        
        fecha_re_provee_ac = sdf.format(gc.getTime());  
        return fecha_re_provee_ac;
    }
    
    //
    public String getId_porvee() {
        return Id_porvee;
    }

    public void setId_porvee(String Id_porvee) {
        this.Id_porvee = Id_porvee;
    }

    public String getContr_provee() {
        return contr_provee;
    }

    public void setContr_provee(String contr_provee) {
        this.contr_provee = contr_provee;
    }

    public Date getFecha_re_provee() {
        return fecha_re_provee;
    }

    public void setFecha_re_provee(Date fecha_re_provee) {
        this.fecha_re_provee = fecha_re_provee;
    }

    public String getNom_provee() {
        return nom_provee;
    }

    public void setNom_provee(String nom_provee) {
        this.nom_provee = nom_provee;
    }

    public String getFecha_re_provee_ac() {
        return fecha_re_provee_ac;
    }

    public void setFecha_re_provee_ac(String fecha_re_provee_ac) {
        this.fecha_re_provee_ac = fecha_re_provee_ac;
    }

    public String getCorreo_provee() {
        return correo_provee;
    }

    public void setCorreo_provee(String correo_provee) {
        this.correo_provee = correo_provee;
    }    
}
