package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioUpdateMb {

    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void loadData() {
        UsuarioDao dao = new UsuarioDao();
        try {
            usuario = dao.getOne(usuario.getIdpessoa());
        } catch (RowNotFoundException ex) {
            FacesMessage msg = new FacesMessage("Usuario inexistente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.editar(usuario);
        
        return "/usuario/lista.xhtml";
    }
}
