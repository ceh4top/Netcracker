package labs.laba1.repository;

import labs.laba1.entity.Person;

import java.util.Arrays;

public class PeronRepository extends Repository<Person> {

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