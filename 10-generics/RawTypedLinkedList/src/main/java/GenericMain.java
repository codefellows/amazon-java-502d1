import java.math.BigInteger;

public class GenericMain {
    public static void main(String[] args) {
        GenericTypeLinkedList<Integer> ints = new GenericTypeLinkedList<>();
        ints.prepend(42);
        ints.prepend(11);
        ints.prepend(9);
        ints.prepend(7);

        GenericTypeLinkedList<String> strings = new GenericTypeLinkedList<>();
        strings.prepend("Christina");
        strings.prepend("Elizabeth");
        strings.prepend("Castro");
        strings.prepend("Kyle");
        strings.prepend("Jessica");
        strings.prepend("Steve");

        System.out.println(ints.toString());
        System.out.println(strings.toString());
        System.out.println();

        int secondInt = ints.get(1);
        String secondStr = strings.get(1);

        System.out.println("Second int: " + secondInt);
        System.out.println("Second str: " + secondStr);
        System.out.println();
    }
}
