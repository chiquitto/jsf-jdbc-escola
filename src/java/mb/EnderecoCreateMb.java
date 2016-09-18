package mb;

import br.com.chiquitto.aula.jdbcescola.dao.CidadeDao;
import br.com.chiquitto.aula.jdbcescola.dao.EnderecoDao;
import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import br.com.chiquitto.aula.jdbcescola.vo.Endereco;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class EnderecoCreateMb {
    private Usuario usuario = new Usuario();
    private Endereco endereco = new Endereco();
    private int idcidade = 0;

    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Cidade> getCidades() {
        CidadeDao dao = new CidadeDao();
        List<Cidade> cidades = dao.getAll();
        return cidades;
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
        endereco.setIdpessoa(usuario.getIdpessoa());
        endereco.setIdcidade(idcidade);
        
        EnderecoDao dao = new EnderecoDao();
        dao.cadastrar(endereco);
        
        return "sucesso";
    }
}
