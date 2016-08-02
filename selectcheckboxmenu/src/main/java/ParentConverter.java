import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Created by anonymous on 8/2/16.
 */
@ManagedBean
@RequestScoped
public class ParentConverter implements Converter{

    @Inject
    FamilyService service;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s == null || "".equals(s)){
            return null;
        }
        return service.findParentById(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return "";
        }
        return ((Parent) o).getId() + "";
    }
}
