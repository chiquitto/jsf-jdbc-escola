package phaseListener;

import java.util.Arrays;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AutenticacaoPhaseListener implements PhaseListener {

    // private static final String URL_NAO_PROTEGIDA = "^/login.xhtml";
    private final String[] URL_NAO_PROTEGIDA = new String[]{
        "/login.xhtml"
    };

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();

        // Boolean urlNaoProtegida = Pattern.matches(URL_NAO_PROTEGIDA, viewId);
        Boolean existe = Arrays.asList(URL_NAO_PROTEGIDA).contains(viewId);

        if (!existe) {
            Object usuario = context.getExternalContext().getSessionMap().get("usuario");

            if (usuario == null) {
                NavigationHandler nav = context.getApplication().getNavigationHandler();

                nav.handleNavigation(context, null, "login");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
