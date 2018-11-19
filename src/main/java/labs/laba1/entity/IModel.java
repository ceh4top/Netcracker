package labs.laba1.entity;

/**
 * Interface model
 */
public interface IModel extends Comparable<IModel> {
    /**
     * Method of getting a model's ID
     * @return id: int
     */
    int getId();
    /**
     * Method of setting a model's ID
     * @param id: int
     */
    void setId(int id);
    /**
     * Method of getting a model's name
     * @return name: String
     */
    String getName();
    /**
     * Method of setting a model's name
     * @param name: String
     */
    void setName(String name);
}
