package Bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean extends HttpServlet{
    private String _usuario_verif;
    private String usuario;
    private String contra;
    private HttpServletRequest httpServerRequest;
    private FacesContext facesContext;
    
    public LoginBean() {        
    }

    public void verificar() throws IOException, ServletException{
        facesContext=FacesContext.getCurrentInstance();
        httpServerRequest=(HttpServletRequest)facesContext.getExternalContext().getRequest();                        
        FacesContext contex = FacesContext.getCurrentInstance();        
        
        _usuario_verif=(String) httpServerRequest.getSession().getAttribute("sessionUsuarioRe");
//        if(_usuario_verif==null){
//            setUsuario(usuario);
//            setContra(contra);
//            System.out.print("Usuario null error !!!");
//            System.out.print("usuario: "+ usuario);
//            System.out.print("Contraseña: "+contra);
//            httpServerRequest.getSession(true);
//            httpServerRequest.getSession().setAttribute("sessionUsuario", usuario);        
//            contex.getExternalContext().redirect("registro.xhtml");
//        }else {
            httpServerRequest.getSession(true);
            httpServerRequest.getSession().setAttribute("sessionUsuario", usuario);        
            contex.getExternalContext().redirect("registro.xhtml");
//        }
        
        
        
    }
    
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
