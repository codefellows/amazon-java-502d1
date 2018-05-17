import java.util.ArrayList;
import java.util.List;

public class Cribbage {
    public static void main(String[] args) {
        BinaryCard[] arr = new BinaryCard[5];
        for (int i = 0; i < arr.length; i++) {
            BinaryCard card = new BinaryCard();
            System.out.println(card.value() + " " + card);
            arr[i] = card;
        }

        int count = 0;
        while (count < Math.pow(2, arr.length - 1)) {
            int total = 0;
            List<BinaryCard> set = new ArrayList<>();

            if ((count & 0b00001) == 0b00001) {
                set.add(arr[0]);
                total += arr[0].value();
            }
            if ((count & 0b00010) == 0b00010) {
                set.add(arr[1]);
                total += arr[1].value();
            }
            if ((count & 0b00100) == 0b00100) {
                set.add(arr[2]);
                total += arr[2].value();
            }
            if ((count & 0b01000) == 0b01000) {
                set.add(arr[3]);
                total += arr[3].value();
            }
            if ((count & 0b10000) == 0b10000) {
                set.add(arr[4]);
                total += arr[4].value();
            }

            if (total == 15) {
                System.out.println("cribbage w/ " + set.toString());
            }
            count++;
        }
    }
}
