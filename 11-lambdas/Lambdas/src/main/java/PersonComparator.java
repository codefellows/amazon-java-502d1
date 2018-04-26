import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonComparator {
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
        // public static <T> void sort(T[] a, Comparator<? super T> c)
        // Comparator requires method: compare(T o1, T o2)
        Person[] people2 = {old, teen, baby, adult};
        Arrays.sort(people2, (p1, p2) -> p1.age - p2.age);
        System.out.println(Arrays.toString(people2));

        Person[] people3 = {old, teen, baby, adult};
        Arrays.sort(people3, (p2, p1) -> p1.age - p2.age);
        System.out.println(Arrays.toString(people3));
        System.out.println();

        // people are friends if their ages are within 20 years of each other.
        for (Person p1 : people1) {
            for (Person p2 : people1) {
                if (p1 != p2) {
                    if (p1.isFriend(p2,
                        other -> Math.abs(p1.age - other.age) < 20)) {
                        System.out.println(p1 + " and " + p2 + " are friends.");
                    }
                }
            }
        }
        System.out.println();

        // no one is friends with a teenager
        for (Person p1 : people1) {
            for (Person p2 : people1) {
                if (p1 != p2) {
                    if (p1.isFriend(p2,
                            other -> other.age < 13 || other.age > 19)) {
                        System.out.println(p1 + " and " + p2 + " are friends.");
                    }
                }
            }
        }
        System.out.println();

        Person[] people4 = Person.getPeople();
        Map<Integer, String> namestoAge =
                Arrays.stream(people4).collect(Collectors.toMap(
                p -> p.age,
                p -> p.name
        ));
        System.out.println(namestoAge);
        System.out.println();
    }
}
