import java.math.BigInteger;

public class MainGenericExtendsNumber {
    public static void main(String[] args) {
        NumberAdderLinkedList<Number> ints = new NumberAdderLinkedList<>();
        ints.prepend(42);
        ints.prepend(.54222f);
        ints.prepend(999999999999999999L);
        ints.prepend(.02346456789102349876278);

        System.out.println(ints.sum());
    }
}
