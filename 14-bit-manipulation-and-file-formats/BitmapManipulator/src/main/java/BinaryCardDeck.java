public class BinaryCardDeck {
    public String[] suits = {"hearts", "diamonds", "clubs", "spades"};
    public String[] faces = {"jack", "queen", "king", "ace"};

    public static void main(String[] args) {
        BinaryCardDeck card = new BinaryCardDeck();
        System.out.println(card.toString());
    }

    byte data;
    public BinaryCardDeck() {
        int suit = (int) Math.floor(Math.random() * 4);
        int value = (int) Math.floor(Math.random() * 16);

        suit = suit << 4;
        this.data = (byte) (suit | value);
    }

    // "ace of hearts"
    // "2 of hearts"
    public String toString() {
        // use a mask to grab only the last four bits.
        byte valueMask = 0b1111;
        byte value = (byte) (this.data & valueMask);

        if (value == 0b0000 || value == 0b0001) {
            return "joker";
        } else if (value == 0b1011) {
           return "zero of cups";
        }

        // assume the face is just a number
        String face = "" + value;

        // detect if the value is over 10 and replace with
        // jack, queen, king, ace.
        if ((value & 0b1100) == 0b1100) {
            int index = value & 0b0011;
            face = faces[index];
        }

        int suitIndex = this.data >> 4;
        String suit = suits[suitIndex];

        String template = "%s of %s";
        return String.format(template, face, suit);
    }
}
