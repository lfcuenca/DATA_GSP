package Bean;

import java.io.IOException;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class RegistroBean {
    private int aux1;
    private int aux2;        
    private Date fecha;
    private String _usuario;
    private HttpServletRequest httpServerRequest;
    private FacesContext facesContext; 

    public RegistroBean() throws IOException {
        fecha = new Date();        
        facesContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)facesContext.getExternalContext().getRequest();                                       
        try{
            _usuario=(String) httpServerRequest.getSession().getAttribute("sessionUsuario");
            if(_usuario == null){
                FacesContext contex = FacesContext.getCurrentInstance();
                contex.getExternalContext().redirect("index.xhtml");
            }
        }catch(Exception e){
            System.out.print(e);
            //salirsession();            
        }                
        //httpServerRequest.getSession().setAttribute("sessionUsuarioRe", _usuario);                
        //System.out.print("Nombre de usuario: "+ _usuario);
        //System.out.print("Fecha de ingreso: "+ fecha);
    }
    
    public void registrar(){
        facesContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)facesContext.getExternalContext().getRequest();
        //httpServerRequest.getSession().setAttribute("sessionUsuarioRe", _usuario);
        _usuario=(String) httpServerRequest.getSession().getAttribute("sessionUsuario");
        System.out.print("Nombre de usuario: "+ _usuario);
        System.out.print("Fecha de ingreso: "+ fecha);
        System.out.print("Resultado de la suma: " + ((aux1)+(aux2)));
    }
    
     public void salirsession() throws IOException{
         facesContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)facesContext.getExternalContext().getRequest();                               
        // Se intenta obtener la sesion y si no existe NO SE CREA UNA NUEVA
        HttpSession lo_session = httpServerRequest.getSession(false);
        if (lo_session != null){ // si la sesion existe
            System.out.println("Sesion Borrada");
            lo_session.invalidate();// Se invalida la sesion (Logout)
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("index.xhtml");
        }
        else{
            System.out.println("No hay Sesion");
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("index.xhtml");
        }      
    }

    public String getUsuario() {
        return _usuario;
    }

    public void setUsuario(String _usuario) {
        this._usuario = _usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAux1() {
        return aux1;
    }

    public void setAux1(int aux1) {
        this.aux1 = aux1;
    }

    public int getAux2() {
        return aux2;
    }

    public void setAux2(int aux2) {
        this.aux2 = aux2;
    }
    
}
