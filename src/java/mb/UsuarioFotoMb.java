package mb;

import br.com.chiquitto.aula.jdbcescola.dao.UsuarioDao;
import br.com.chiquitto.aula.jdbcescola.exception.RowNotFoundException;
import br.com.chiquitto.aula.jdbcescola.vo.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean
public class UsuarioFotoMb {
    private Usuario usuario = new Usuario();
    private Part foto;

    public Usuario getUsuario() {
        return usuario;
    }

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
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
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        String uploadDir = (String) context.getExternalContext().getInitParameterMap().get("UPLOAD_DIR");
        
        File output = new File(uploadDir, "foto" + usuario.getIdpessoa() + ".jpg");
        if (output.isFile()) {
            output.delete();
        }
        
        try {
            InputStream input = foto.getInputStream();
                        
            Files.copy(input, output.toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getFotoValue() {
        return "/upload/foto" + usuario.getIdpessoa() + ".jpg";
    }
}
