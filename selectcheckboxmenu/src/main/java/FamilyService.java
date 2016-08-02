import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by anonymous on 8/2/16.
 */
@Singleton
public class FamilyService {

    List<Child> children = new ArrayList<>();
    List<Parent> parents = new ArrayList<>();

    @PostConstruct
    public void init(){
        children = new ArrayList<>();
        parents = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Parent p = new Parent(i, "Parent "+ i);
            parents.add(p);
            for (int j = 0; j < 5; j++) {
                String id = UUID.randomUUID().toString();
                Child ch = new Child(id,p, "Child "+ j + " Parent " + i);
                children.add(ch);
            }
        }
    }

    public Child findChildById(String id){
        List<Child> result = children.stream().filter(c -> c.getId().equals(id)).collect(Collectors.toList());
        if(result.isEmpty()){
            return new Child();
        }

        return result.get(0);
    }

    public Parent findParentById(int id){
        List<Parent> result = parents.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        if(result.isEmpty()){
            return new Parent();
        }

        return result.get(0);
    }

    public List<Parent> findParents(){
        return parents;
    }

    public List<Child> findChildrenByParent(Parent p){
        return children.stream().filter(c -> c.getParent().equals(p)).collect(Collectors.toList());
    }
}
