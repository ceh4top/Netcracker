package netcracker;

import netcracker.annotations.SortAnnotationAnalyzer;
import netcracker.entity.Person;
import netcracker.helper.Gender;
import netcracker.repository.IReposiory;
import netcracker.repository.PersonRepository;
import org.joda.time.LocalDate;
import java.util.Random;

public class Main {
    private static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        IReposiory<Person> persons = PersonRepository.getInstance();
        SortAnnotationAnalyzer.analyze(persons);

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

        persons.sort((p1, p2) -> p1.hashCode() - p2.hashCode());
        printArray(persons.get());

        System.out.println("--Sort--");
        System.out.println("--QS_1 ID--");
        persons.sort((p1, p2) -> p1.getId() - p2.getId());
        printArray(persons.get());
        System.out.println("--QS_2 AGE--");
        persons.sort((p1, p2) -> p1.getAge() - p2.getAge());
        printArray(persons.get());

        System.out.println("--Filter_1--");
        printArray(persons.findElements(x -> x.getGender() == Gender.male));

    }
}
