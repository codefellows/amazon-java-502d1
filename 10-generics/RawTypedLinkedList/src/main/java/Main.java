public class Main {
    public static void main(String[] args) {
        RawTypeLinkedList ints = new RawTypeLinkedList();
        ints.prepend(42);
        ints.prepend(11);
        ints.prepend(9);
        ints.prepend(7);

        RawTypeLinkedList strings = new RawTypeLinkedList();
        strings.prepend("Christina");
        strings.prepend("Elizabeth");
        strings.prepend("Castro");
        strings.prepend("Kyle");
        strings.prepend("Jessica");
        strings.prepend("Steve");

        System.out.println(ints.toString());
        System.out.println(strings.toString());
        System.out.println();

        int secondInt = (int) ints.get(1);
        String secondStr = (String) strings.get(1);

        System.out.println("Second int: " + secondInt);
        System.out.println("Second str: " + secondStr);
        System.out.println();

        int lieeeees = (int) strings.get(1);
        System.out.println("LIES!! " + lieeeees);
    }
}
