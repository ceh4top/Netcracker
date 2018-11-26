package labs.laba1.repository;

import labs.laba1.entity.Person;

import java.util.Arrays;

public class PeronRepository extends Repository<Person> {
    /** Future item identifier */
    private static int id = 1;

    @Override
    protected int getNewId() {
        return id++;
    }

    /** PersonRepository Singleton */
    private static IReposiory<Person> instance;
    /** Get PersonRepository singleton */
    public static IReposiory<Person> getInstance() {
        if (instance == null) {
            instance = new PeronRepository();
        }
        return instance;
    }

    /** PersonRepository class constructor */
    private PeronRepository() {
        this.values = new Person[0];
    }
}