package netcracker.repository;

import netcracker.annotations.SortAnnotation;
import netcracker.entity.Person;
import netcracker.sort.ISort;
import netcracker.sort.QuickSort;

public class PersonRepository extends Repository<Person> {
    /** Future item identifier */
    private static int id = 1;

    @Override
    protected int getNewId() {
        return id++;
    }

    @Override
    protected void emptyId() { id = 1; }

    @SortAnnotation
    private ISort sort;

    @Override
    protected ISort sorting() {
        return sort;
    }

    /** PersonRepository Singleton */
    private static IReposiory<Person> instance;
    /** Get PersonRepository singleton */
    public static IReposiory<Person> getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

    /** PersonRepository class constructor */
    private PersonRepository() {
        this.values = new Person[0];
    }
}