import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
public class BackingBean {

    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private List<Child> selectedChildren = new ArrayList<>();



    private List<Child> globalSelectedChildren = new ArrayList<>();
    private Parent selectedParent = new Parent();

    @Inject
    FamilyService service;

    @PostConstruct
    public void init(){
        parents = service.findParents();
    }


    public void parentChanged(){
        children = new ArrayList<>();
        if(getSelectedParent() == null){
            return;
        }

        children = service.findChildrenByParent(getSelectedParent());
        selectedChildren = globalSelectedChildren.stream().filter(c -> c.getParent().equals(selectedParent)).collect(Collectors.toList());
        System.out.println(selectedChildren.size());
    }

    public void selectedSonChanged(){
        System.out.println(selectedChildren.size());
        globalSelectedChildren = globalSelectedChildren.stream().filter(c -> !c.getParent().equals(selectedParent)).collect(Collectors.toList());
        globalSelectedChildren.addAll(selectedChildren);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Child> getSelectedChildren() {
        return selectedChildren;
    }

    public void setSelectedChildren(List<Child> selectedChildren) {
        this.selectedChildren = selectedChildren;
    }

    public Parent getSelectedParent() {
        return selectedParent;
    }

    public void setSelectedParent(Parent selectedParent) {
        this.selectedParent = selectedParent;
    }

    public List<Child> getGlobalSelectedChildren() {
        return globalSelectedChildren;
    }

    public void setGlobalSelectedChildren(List<Child> globalSelectedChildren) {
        this.globalSelectedChildren = globalSelectedChildren;
    }
}