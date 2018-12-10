package netcracker.repository;

import netcracker.annotations.SortAnnotationAnalyzer;
import netcracker.entity.Person;
import netcracker.helper.Gender;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IReposioryPersonTest {

    static IReposiory<Person> reposiory;

    @BeforeEach
    void initAll() {
        reposiory = PersonRepository.getInstance();
        SortAnnotationAnalyzer.analyze(reposiory);
        reposiory.add(new Person("Дмитрий Васильев", Gender.male, new LocalDate(1996, 3, 17)));
        reposiory.add(new Person("Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6)));
        reposiory.add(new Person("Петя Пупнов", Gender.male, new LocalDate(1975, 10, 20)));
        reposiory.add(new Person("Генадий Чебурашкинов", Gender.male, new LocalDate(1999, 5, 5)));
        reposiory.add(new Person("Алла Пугачева", Gender.fmale, new LocalDate(1900, 12, 12)));
        reposiory.add(new Person("Катя Новорожденная", Gender.fmale, LocalDate.now()));
    }

    @AfterEach
    void close() {
        reposiory.truncate();
    }

    @Test
    void findElements() {
        Person[] persons = new Person[] {
                new Person(2,"Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6)),
                new Person(5, "Алла Пугачева", Gender.fmale, new LocalDate(1900, 12, 12)),
                new Person(6, "Катя Новорожденная", Gender.fmale, LocalDate.now())
        };
        Person[] personsFind = reposiory.findElements(x -> x.getGender() == Gender.fmale);
        assertArrayEquals(persons, personsFind);
    }

    @Test
    void findElement() {
        Person person = new Person(2,"Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6));
        Person personFind = reposiory.findElement(x -> x.getId() == 2);
        assertEquals(person, personFind);
    }

    @Test
    void get() {
        Person person = new Person(2,"Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6));
        Person personFind = reposiory.get(2);
        assertEquals(person, personFind);
    }

    @Test
    void getAll() {
        Person[] persons = new Person[] {
                new Person(1,"Дмитрий Васильев", Gender.male, new LocalDate(1996, 3, 17)),
                new Person(2,"Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6)),
                new Person(3,"Петя Пупнов", Gender.male, new LocalDate(1975, 10, 20)),
                new Person(4,"Генадий Чебурашкинов", Gender.male, new LocalDate(1999, 5, 5)),
                new Person(5, "Алла Пугачева", Gender.fmale, new LocalDate(1900, 12, 12)),
                new Person(6, "Катя Новорожденная", Gender.fmale, LocalDate.now())
        };
        Person[] personsGet = reposiory.get();
        assertArrayEquals(persons, personsGet);
    }

    @Test
    void add() {
        Person person = new Person(9, "Девять Девятого", Gender.male, new LocalDate(1999, 5,5));
        reposiory.add(person);
        assertEquals(person, reposiory.get(9));
    }

    @Test
    void addArray() {
        Person[] persons = new Person[] {
                new Person(10,"10", Gender.male, new LocalDate(1910, 10, 10)),
                new Person(11,"11", Gender.fmale, new LocalDate(1911, 11, 11)),
        };
        reposiory.add(persons);
        assertArrayEquals(persons, reposiory.findElements(x -> x.getId() > 9 && x.getId() < 12));
    }

    @Test
    void delete() {
        Person person = new Person(1,"Дмитрий Васильев", Gender.male, new LocalDate(1996, 3, 17));
        reposiory.delete(person);
        assertNull(reposiory.get(1));
    }

    @Test
    void deleteArray() {
        Person[] persons = new Person[] {
                new Person(3,"Петя Пупнов", Gender.male, new LocalDate(1975, 10, 20)),
                new Person(4,"Генадий Чебурашкинов", Gender.male, new LocalDate(1999, 5, 5)),
                new Person(5, "Алла Пугачева", Gender.fmale, new LocalDate(1900, 12, 12)),
                new Person(6, "Катя Новорожденная", Gender.fmale, LocalDate.now())
        };
        reposiory.delete(persons);
        assertNull(reposiory.findElement(x -> x.getId() > 2 && x.getId() < 7));
    }

    @Test
    void deleteFind() {
        reposiory.delete(x -> x.getId() == 4);
        assertNull(reposiory.get(4));
    }

    @Test
    void deleteById() {
        reposiory.delete(3);
        assertNull(reposiory.get(3));
    }

    @Test
    void sort() {
        Person[] persons = new Person[] {
                new Person(6, "Катя Новорожденная", Gender.fmale, LocalDate.now()),
                new Person(4,"Генадий Чебурашкинов", Gender.male, new LocalDate(1999, 5, 5)),
                new Person(2,"Алина Попова", Gender.fmale, new LocalDate(1997, 1, 6)),
                new Person(1,"Дмитрий Васильев", Gender.male, new LocalDate(1996, 3, 17)),
                new Person(3,"Петя Пупнов", Gender.male, new LocalDate(1975, 10, 20)),
                new Person(5, "Алла Пугачева", Gender.fmale, new LocalDate(1900, 12, 12))
        };
        reposiory.sort((p1, p2) -> p1.getAge() - p2.getAge());
        assertArrayEquals(persons, reposiory.get());
    }
}