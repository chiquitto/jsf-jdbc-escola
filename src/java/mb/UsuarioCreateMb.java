package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }

    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.cadastrar(usuario);
        
        FacesContext context = FacesContext.getCurrentInstance();
        String uploadDir = (String) context.getExternalContext().getInitParameterMap().get("UPLOAD_DIR");

        try {
            InputStream input = foto.getInputStream();
            File saida = new File(uploadDir, "foto" + usuario.getIdpessoa() + ".jpg");
            
            System.out.println(saida.toPath());

            Files.copy(input, saida.toPath());
            
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return "sucesso";

    }
}
