package br.ufpr.tcc.bean;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ManagedBean(name="loginController")
@RequestScoped
@Component
public class LoginController implements PhaseListener {

	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private String login;
	private String password;
	private ResourceBundle rb = ResourceBundle.getBundle("msg");
    
    /**
     *
     * Redirects the login request directly to spring security check.
     * Leave this method as it is to properly support spring security.
     * 
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String doLogin() throws ServletException, IOException {
       try{
    	   ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    	   
    	   RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
    			   .getRequestDispatcher("/j_spring_security_check");
    	   
    	   dispatcher.forward((ServletRequest) context.getRequest(),
    			   (ServletResponse) context.getResponse());
    	   
    	   
    	   FacesContext.getCurrentInstance().responseComplete();
    	   
    	   return null;
       
       }catch(Exception e){
    	   FacesContext.getCurrentInstance().addMessage("messageLogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("loginInvalid")));
    	   e.printStackTrace();
    	   return null;
       }
    }
    
    public String doLogout() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_logout");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
    }

    public void afterPhase(PhaseEvent event) {
    }

    public void beforePhase(PhaseEvent event) {
        Exception e = (Exception) FacesContext.getCurrentInstance().
          getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
 
        if (e instanceof BadCredentialsException) {
            logger.debug("Found exception in session map: "+e);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(null, 
              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Username or password not valid.", "Username or password not valid"));
        }
    }
    
    public void invalidLogin() {
    	FacesContext.getCurrentInstance().addMessage("messageLogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("loginInvalid")));
    }
    

    /* (non-Javadoc)
     * @see javax.faces.event.PhaseListener#getPhaseId()
     * 
     * In which phase you want to interfere?
     */
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
