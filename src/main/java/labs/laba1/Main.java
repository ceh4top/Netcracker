package labs.laba1;

import labs.laba1.entity.Person;
import labs.laba1.helper.Gender;
import labs.laba1.repository.IReposiory;
import labs.laba1.repository.PeronRepository;
import labs.laba1.sort.Sort;
import org.joda.time.LocalDate;

import java.util.Comparator;
import java.util.Random;

public class Main {
    private static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }

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

        Person[] personsArray = persons.get();
        printArray(Sort.quickSorting(personsArray, (p1, p2) -> p1.hashCode() - p2.hashCode()));

        System.out.println("--Sort--");
        Sort sort = new Sort();
        System.out.println("--BS_1--");
        printArray(Sort.quickSorting(personsArray));
        System.out.println("--BS_2--");
        printArray(Sort.quickSorting(personsArray, (p1, p2) -> { return p1.getAge() - p2.getAge(); }));

        System.out.println("--Filter_1--");
        printArray(persons.findElements(x -> x.getGender() == Gender.male));

    }
}
