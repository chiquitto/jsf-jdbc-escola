package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginMb {
    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String login() {
        UsuarioDao dao = new UsuarioDao();
        
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        
        try {
            usuario = dao.getByEmailSenha(usuario);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            
            return "/index.xhtml";
        } catch (RowNotFoundException ex) {
            // informacoes incorretas
            FacesMessage msg = new FacesMessage("Email e/ou Senha incorretos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            return null;
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
        return "/login?faces-redirect=true";
    }
}
