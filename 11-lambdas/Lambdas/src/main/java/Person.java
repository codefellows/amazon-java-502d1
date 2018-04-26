public class Person {
    public int age;

    public Person(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("%d years old", this.age);
    }

    public static Person[] getPeople() {
        Person baby = new Person(2);
        Person teen = new Person(13);
        Person adult = new Person(32);
        Person old = new Person(94);

        Person[] people = {old, teen, baby, adult};
        return people;
    }
}
