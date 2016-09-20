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
public class EnderecoUpdateMb {
    private Usuario usuario;
    private Endereco endereco = new Endereco();
    private int idcidade;
    private List<Cidade> cidades;

    public Usuario getUsuario() {
        return usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }
    
    public List<Cidade> getCidades() {
        if (cidades == null) {
            cidades = (new CidadeDao()).getAll();
        }
        return cidades;
    }
    
    public void loadData() {
        EnderecoDao enderecoDao = new EnderecoDao();
        
        try {
            endereco = enderecoDao.getOne(endereco.getIdendereco());
        } catch (RowNotFoundException ex) {
            FacesMessage msg = new FacesMessage("Registro inexistente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        idcidade = endereco.getIdcidade();
        
        UsuarioDao usuarioDao = new UsuarioDao();
        
        try {
            usuario = usuarioDao.getOne(endereco.getIdpessoa());
        } catch (RowNotFoundException ex) {
            
        }
    }
    
    public String salvar() {
        endereco.setIdcidade(idcidade);
        
        (new EnderecoDao()).editar(endereco);
        
        return "sucesso";
    }
}
