package mb;

import br.com.chiquitto.aula.jdbcescola.vo.Cidade;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class CidadeCreateMb {
    
    private Cidade cidade = new Cidade();
    
    public Cidade getCidade() {
        return this.cidade;
    }

    public String salvar() {
        System.out.println("Salvar");
        System.out.println(this.cidade.getCidade());
        return "sucesso";
    }
}
