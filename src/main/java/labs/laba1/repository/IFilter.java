package labs.laba1.repository;

import labs.laba1.entity.IModel;

/**
 * Interface for lambda expressions
 * @param <T>
 */
public interface IFilter<T extends IModel> {
    /**
     * Getting the result of the execution
     * @param value The object for the condition
     * @return result
     */
    boolean getResult(T value);
}
