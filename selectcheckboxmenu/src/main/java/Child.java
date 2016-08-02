import java.util.Objects;

/**
 * Created by anonymous on 8/2/16.
 */
public class Child {

    String id;

    Parent parent;

    String name;

    public Child(){

    }

    public Child(String id, Parent parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id) &&
                Objects.equals(parent, child.parent) &&
                Objects.equals(name, child.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, name);
    }
}
