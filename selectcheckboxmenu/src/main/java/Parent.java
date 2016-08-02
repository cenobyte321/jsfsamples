import java.util.Objects;

/**
 * Created by anonymous on 8/2/16.
 */
public class Parent {

    int id;

    String name;

    public Parent(){

    }

    public Parent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Parent parent = (Parent) o;
        return id == parent.id &&
                Objects.equals(name, parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
