public class Person {
    public int age;

    public Person(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("%d years old", this.age);
    }
}
