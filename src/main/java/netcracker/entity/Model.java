package netcracker.entity;

import java.util.Objects;

/**
 * Abstract class model
 * @see IModel
 */
abstract class Model implements IModel {
    /** Model identifier **/
    protected int id;
    /** Model name */
    protected String name;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor model
     * @param id Model identifier
     * @param name Model name
     */
    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %d\", \"name\": %s}", this.getId(), this.getName());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;

        Person person = (Person) o;
        return this.getId() == person.getId()
                && this.getName().equals(person.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName());
    }

    @Override
    public int compareTo(IModel model) {
        return Integer.compare(this.getId(), model.getId());
    }
}
