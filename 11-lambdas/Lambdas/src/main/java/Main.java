import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person baby = new Person(2);
        Person teen = new Person(13);
        Person adult = new Person(32);
        Person old = new Person(94);

        // Old way using a class to implement a comparator
        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.age - b.age;
            }
        }

        Person[] people1 = {old, teen, baby, adult};
        Arrays.sort(people1, new PersonAgeComparator());
        System.out.println(Arrays.toString(people1));

        // New way to implement a small comparator using lambdas
        Person[] people2 = {old, teen, baby, adult};
        Arrays.sort(people2, (p1, p2) -> p1.age - p2.age);
        System.out.println(Arrays.toString(people2));
    }
}
