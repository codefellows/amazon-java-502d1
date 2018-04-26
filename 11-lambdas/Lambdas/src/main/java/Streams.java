import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Streams {
    public static void main (String[] args) {
        Person[] people = Person.getPeople();
        List<Integer> ages = Arrays.stream(people)
                .map(person -> person.age)
                .collect(Collectors.toList());
        System.out.println(ages);
    }
}
