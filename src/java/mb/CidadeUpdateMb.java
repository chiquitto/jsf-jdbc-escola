package mb;

import br.com.chiquitto.aula.jdbcescola.dao.CidadeDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CidadeUpdateMb implements Serializable {

    private Cidade cidade = new Cidade();

    public Cidade getCidade() {
        return cidade;
    }
    
    public void loadData() {
        CidadeDao cidadeDao = new CidadeDao();
        try {
            cidade = cidadeDao.getOne(cidade.getIdcidade());
        } catch (RowNotFoundException ex) {
            FacesMessage msg = new FacesMessage("Cidade inexistente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String salvar() {
        CidadeDao cidadeDao = new CidadeDao();
        
        try {
            cidadeDao.editar(cidade);
            return "sucesso";
        }
        catch (Exception e) {
            FacesMessage msg = new FacesMessage("Falha para salvar o registro");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "falha";
        }
    }
}
