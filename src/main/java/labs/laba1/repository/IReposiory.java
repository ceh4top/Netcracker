package labs.laba1.repository;

import labs.laba1.entity.IModel;

import java.util.function.Predicate;

public interface IReposiory<T extends IModel> {
    /**
     * The method of obtaining an array of elements suitable for the condition
     * @param filter: IFilter
     * @return values: T[]
     * @see Predicate
     */
    T[] findElements(Predicate<T> filter);
    /**
     * The method of obtaining the first element suitable under the condition
     * @param filter: IFilter
     * @return value: T
     * @see Predicate
     */
    T findElement(Predicate<T> filter);
    /**
     * Getting all items
     * @return values: T[]
     */
    T[] get();
    /**
     * Getting item by id
     * @param id: int
     * @return value: T
     */
    T get(int id);
    /**
     * Save item to repository
     * @param value: T
     */
    void add(T value);
    /**
     * Save items in the repository
     * @param values: T[]
     */
    void add(T[] values);
    /**
     * Deletion of elements suitable for the condition
     * @param filter: IFilter
     * @see IFilter
     */
    void delete(IFilter<T> filter);
    /**
     * Deleting array elements
     * @param values: T[]
     */
    void delete(T[] values);
    /**
     * Delete item
     * @param value: T
     */
    void delete(T value);
    /**
     * Deleting an item by id
     * @param id: int
     */
    void delete(int id);
}
