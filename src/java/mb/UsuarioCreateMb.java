package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

@ManagedBean
public class UsuarioCreateMb {

    private Usuario usuario = new Usuario();
    private Part foto;
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.cadastrar(usuario);
        
        return "/usuario/lista.xhtml";
    }
}
