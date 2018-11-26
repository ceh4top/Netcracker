package labs.laba1.repository;

import labs.laba1.entity.IModel;

import java.util.Arrays;
import java.util.function.Predicate;

abstract class Repository<T extends IModel> implements IReposiory<T> {
    /** Future item identifier */
    private static int id = 1;
    /**
     * Getting item ID
     * @return id: int - item identifier
     * */
    protected static int getNewId() {
        return Repository.id++;
    }

    /** Array of elements */
    protected T[] values;

    public T[] findElements(Predicate<T> filter) {
        T[] values = Arrays.copyOf(this.values, 0);
        for (T value: this.values) {
            if (value != null && filter.test(value)) {
                int index = values.length;
                values = Arrays.copyOf(values, index + 1);
                values[index] = value;
            }
        }
        return values;
    }
    public T findElement(Predicate<T> filter) {
        T[] values = findElements(filter);
        return values.length > 0 ? values[0] : null;
    }
    public T[] get() { return this.values; }
    public T get(int id) {
        return this.findElement(value -> value.getId() == id);
    }

    protected int indexOfById(int id) {
        for (int i = 0; i < values.length; ++i) {
            if (values[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void add(T value) {
        if (value.getId() != 0) {
            int index = indexOfById(value.getId());
            if (index >= 0) {
                values[index] = value;
                return;
            }
        } else {
            value.setId(getNewId());
        }

        int lenght = values.length;
        values = Arrays.copyOf(values, lenght + 1);
        values[lenght] = value;

        for (int i = lenght; i > 0; --i) {
            T v1 = values[i - 1];
            T v2 = values[i];
            if (v1.getId() > v2.getId()) {
                values[i - 1] = v2;
                values[i] = v1;
            }
        }
    }
    public void add(T[] values) {
        for (T value: values) {
            add(value);
        }
    }

    public void delete(IFilter<T> filter) {
        delete(findElements(filter));
    }
    public void delete(T[] values) {
        for (T value: values) {
            delete(value);
        }
    }
    public void delete(T value) {
        delete(value.getId());
    }
    public void delete(int id) {
        int index = indexOfById(id);
        if (index >= 0) {
            values[index] = null;
            for (;index < values.length - 1; ++index)
                values[index] = values[index + 1];
            values = Arrays.copyOf(values, values.length - 1);
        }
    }
}
