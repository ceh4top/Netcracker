package labs.laba1.entity;

import labs.laba1.helper.Gender;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Comparator;
import java.util.Objects;

/**
 * Person model
 * @see Model
 */
public class Person extends Model {
    /** Full name **/
    private String fullName;
    /** Gender **/
    private Gender gender;
    /** Date of Birth **/
    private LocalDate brithday;

    /**
     * Constructor person model
     * @param id Person ID
     * @param fullName Person full name
     * @param gender Person gender
     * @param brithday Person date of birth
     */
    public Person(int id, String fullName, Gender gender, LocalDate brithday) {
        super(id, "Person");
        this.fullName = fullName;
        this.gender = gender;
        this.brithday = brithday;
    }
    /**
     * Constructor person model
     * @param fullName Person full name
     * @param gender Person gender
     * @param brithday Person date of birth
     */
    public Person(String fullName, Gender gender, LocalDate brithday) {
        super(0, "Person");
        this.fullName = fullName;
        this.gender = gender;
        this.brithday = brithday;
    }

    /**
     * Method of getting a person's full name
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Method of setting a person's full name
     * @param fullName Person full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method of getting a person's gender
     * @return gender
     * @see Gender
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * Method of setting a person's gender
     * @param gender Person gender
     * @see Gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Method of getting a person's date of birth
     * @return brithday
     * @see LocalDate
     */
    public LocalDate getBrithday() {
        return brithday;
    }
    /**
     * Method of setting a person's date of birth
     * @param brithday Person date of birth
     * @see LocalDate
     */
    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    /**
     * Method of getting a person's age
     * @return age: int
     */
    public int getAge() {
        return Years.yearsBetween(brithday, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("{\"id\": %d, \"fullName\": \"%s\", \"gender\": \"%s\", \"age\": %d}",
                this.getId(), this.getFullName(), this.getGender(), this.getAge());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;

        Person person = (Person) o;
        return this.getId() == person.getId()
                && this.getName().equals(person.getName())
                && this.getFullName().equals(person.getFullName())
                && this.getGender().equals(person.getGender())
                && this.getBrithday() == person.getBrithday();
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getFullName(), this.getGender(), this.getBrithday());
    }

    public static Comparator<Person> comparatorById = (value1, value2) -> (value1.id < value2.id) ? -1 : (value1.id == value2.id ? 0 : 1);
    public Comparable<Person> comparableById = (value1) -> this.id == value1.id ? 0 : 1;
}
