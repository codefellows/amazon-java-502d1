public class MakeChange {
    public static void main(String[] args) {
       makeChange(973, 1000); 
    }

    private static void makeChange(int cost, int paid) {
        int[] value = {2000, 1000, 500, 100, 25, 10, 5, 1};
        String[] name = {"twenty", "ten", "five", "dollar", "quarter", "dime", "nickel", "penny"};
        String[] namePlural = {"twenties", null, null, null, null, null, null, "pennies"};

        int change = paid - cost;

        int index = 0;
        while (change > 0) {
            String currency = name[index];
            int numCoins = change / value[index];

            currency = pluralize(numCoins, currency, namePlural[index]);

            if (numCoins > 0) {
                String template = "Give %d %s";
                String message = String.format(template, numCoins, currency);
                System.out.println(message);
            }

            change = change % value[index];
            index++;
        }
    }

    private static String pluralize(int amount, String singular, String plural) {
       if (amount == 1) {
           return singular;
       } else if (plural == null) {
           return singular + 's';
       } else {
           return plural;
       }
    }
}
