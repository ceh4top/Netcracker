package netcracker.repository;

import netcracker.entity.IModel;
import netcracker.sort.ISort;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public abstract class Repository<T extends IModel> implements IReposiory<T> {
    private static final Logger logger = Logger.getLogger(Repository.class);

    /**
     * Getting item ID
     * @return id: int - item identifier
     * */
    protected abstract int getNewId();
    protected abstract void emptyId();

    protected abstract ISort sorting();

    /** Array of elements */
    protected T[] values;
    protected int indexOfById(int id) {
        for (int i = 0; i < values.length; ++i) {
            if (values[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public T[] findElements(Predicate<T> filter) {
        T[] values = Arrays.copyOf(this.values, 0);
        for (T value: this.values) {
            if (value != null && filter.test(value)) {
                int index = values.length;
                values = Arrays.copyOf(values, index + 1);
                values[index] = value;
            }
        }

        if (values.length == 0) {
            logger.warn("Ни одного объектна не найдено!");
        } else {
            logger.info("Объекты найдены!");
        }

        return values;
    }
    public T findElement(Predicate<T> filter) {
        for (T value: this.values) {
            if (value != null && filter.test(value)) {
                return value;
            }
        }

        logger.warn("Объект не найден!");
        return null;
    }

    public T[] get() { return this.values; }
    public T get(int id) {
        return this.findElement(value -> value.getId() == id);
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

    public void delete(Predicate<T> filter) {
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

    public void sort(Comparator<T> comparator) {
        sorting().sort(values, comparator);
    }

    public void truncate() {
        values = Arrays.copyOf(values, 0);
        emptyId();
    }
}
