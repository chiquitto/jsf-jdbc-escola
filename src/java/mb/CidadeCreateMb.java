package mb;

import br.com.chiquitto.aula.jdbcescola.dao.CidadeDao;
import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CidadeCreateMb {

    private Cidade cidade = new Cidade();

    public Cidade getCidade() {
        return this.cidade;
    }

    public String salvar() {
        CidadeDao cidadeDao = new CidadeDao();
        try {
            cidadeDao.cadastrar(cidade);
            return "sucesso";
        } catch (Exception e) {
            e.printStackTrace();
            
            FacesMessage msg = new FacesMessage("Falha para inserir o registro");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "";
    }
}
