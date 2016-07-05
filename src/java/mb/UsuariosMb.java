package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuariosMb {
    private List<Usuario> usuarios;
    
    public void delete(Usuario usuario) {
        UsuarioDao dao = new UsuarioDao();
        dao.apagar(usuario);
        usuarios = null;
    }
    
    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            UsuarioDao dao = new UsuarioDao();
            usuarios = dao.getAll();
        }
        return usuarios;
    }
}
