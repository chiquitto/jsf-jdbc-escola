package mb;

import br.com.chiquitto.aula.jdbcescola.dao.CidadeDao;
import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CidadesMb {

    private List<Cidade> cidades;

    public List<Cidade> getCidades() {
        if (this.cidades == null) {
            CidadeDao cidadeDao = new CidadeDao();
            this.cidades = cidadeDao.getAll();
        }
        return this.cidades;
    }
}
