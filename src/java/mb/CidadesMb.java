package mb;

import br.com.chiquitto.aula.jdbcescola.dao.CidadeDao;
import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CidadesMb {

    private List<Cidade> cidades;
    
    public void delete(Cidade cidade) {
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.apagar(cidade);
        this.cidades = null;
    }

    public List<Cidade> getCidades() {
        if (this.cidades == null) {
            CidadeDao cidadeDao = new CidadeDao();
            this.cidades = cidadeDao.getAll();
        }
        return this.cidades;
    }
}
