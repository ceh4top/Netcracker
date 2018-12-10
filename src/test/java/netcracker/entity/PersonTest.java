package netcracker.entity;

import netcracker.helper.Gender;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getAge() {
        Person person = new Person(5, "New Person", Gender.male, new LocalDate(1994,12,11));
        LocalDate now = LocalDate.now();
        assertEquals(person.getAge(), Years.yearsBetween(person.getBrithday(), now).getYears());
    }

    @Test
    void equals() {
        Person person1 = new Person(5, "New Person", Gender.male, new LocalDate(1994,12,11));
        Person person2 = new Person(5, "New Person", Gender.male, new LocalDate(1994,12,11));
        assertTrue(person1.equals(person2));
    }

    @Test
    void notEquals() {
        Person person1 = new Person(5, "New Person", Gender.male, new LocalDate(1994,12,11));
        Person person2 = new Person(5, "Now Person", Gender.male, new LocalDate(1994,12,10));
        assertFalse(person1.equals(person2));
    }
}