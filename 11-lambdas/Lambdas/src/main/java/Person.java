import java.util.function.Predicate;

public class Person {
    public int age;
    public String name;

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return String.format("%d years old", this.age);
    }

    public boolean isFriend(Person other, Predicate<Person> test) {
        return test.test(other);
    }

    public static Person[] getPeople() {
        Person baby = new Person(2, "Huey");
        Person teen = new Person(13, "Emo Lucas");
        Person adult = new Person(32, "Robert");
        Person old = new Person(94, "Gretchen");

        Person[] people = {old, teen, baby, adult};
        return people;
    }
}
