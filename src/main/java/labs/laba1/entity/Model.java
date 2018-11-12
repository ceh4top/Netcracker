package labs.laba1.entity;

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
}
