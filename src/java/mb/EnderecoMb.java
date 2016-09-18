package mb;

import br.com.chiquitto.aula.jdbcescola.dao.EnderecoDao;
import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Endereco;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class EnderecoMb {
    private Usuario usuario = new Usuario();
    private List enderecos;

    public List<Endereco> getEnderecos() {
        if (enderecos == null) {
            EnderecoDao dao = new EnderecoDao();
            enderecos = dao.getAllByIdpessoa(usuario.getIdpessoa());
            
            System.out.println(enderecos.size());
        }
        return enderecos;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}
