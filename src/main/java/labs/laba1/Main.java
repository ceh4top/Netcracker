package labs.laba1;

import labs.laba1.entity.Person;
import labs.laba1.helper.Gender;
import labs.laba1.repository.IReposiory;
import labs.laba1.repository.PeronRepository;
import org.joda.time.LocalDate;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IReposiory<Person> persons = PeronRepository.getInstance();

        String[][] names = new String[][] {
                {"Dima", "Sasha", "Pasha", "Artem", "Tihon"},
                {"Alina", "Vika", "Masha", "Dasha", "Lena"}
        };

        Random r = new Random();
        for (int i = 0; i < 30; ++i)  {
            int gender = r.nextInt(2);
            int name = r.nextInt(5);
            int y = 2018 - r.nextInt(90);
            int m = r.nextInt(12) + 1;
            int d = r.nextInt(28) + 1;

            Person person = new Person(names[gender][name], Gender.values()[gender], new LocalDate(y,m,d));
            persons.add(person);
        }

        for(Person p: persons.findElements(x -> x.getAge() < 30)) {
            System.out.println(p);
        }

        System.out.println("\n------------------------\n");

        persons.delete(persons.findElements(x -> x.getName().equals("Sasha")));

        for(Person p: persons.get()) {
            System.out.println(p);
        }

        System.out.println("\n------------------------\n");

        Person person = new Person(3, "Sasha", Gender.male, new LocalDate(1975, 12,20));
        persons.add(person);

        for(Person p: persons.sort()) {
            System.out.println(p);
        }

        System.out.println("\n------------------------\n");

    }
}
