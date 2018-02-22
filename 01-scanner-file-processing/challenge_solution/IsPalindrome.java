public class IsPalindrome {
    public static final String ACCEPTABLE_CHARS = "qwertyuiopasdfghjklzxcvbnm0123456789";

    public static void main(String[] args) {
        checkPalindrome("");
        checkPalindrome("a");
        checkPalindrome("mom");
        checkPalindrome("racecar");

        checkPalindrome("ab");
        checkPalindrome("tractor");

        checkPalindrome("UFO tofu?");
        checkPalindrome("A man, a plan, a canal, Panama!");
        checkPalindrome("No 'x' in Nixon");
        checkPalindrome("Dennis, Nell, Edna, Leon, Nedra, Anita, Rolf, Nora, Alice, Carol, Leo, Jane, Reed, Dena, Dale, Basil, Rae, Penny, Lana, Dave, Denny, Lena, Ida, Bernadette, Ben, Ray, Lila, Nina, Jo, Ira, Mara, Sara, Mario, Jan, Ina, Lily, Arne, Bette, Dan, Reba, Diane, Lynn, Ed, Eva, Dana, Lynne, Pearl, Isabel, Ada, Ned, Dee, Rena, Joel, Lora, Cecil, Aaron, Flora, Tina, Arden, Noel, and Ellen sinned.\n");
    }

    public static void checkPalindrome(String s) {
        boolean result = isPalindrome(s);
        if (result) {
            System.out.println(" TRUE " + s);
        } else {
            System.out.println("FALSE " + s);
        }
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int startIndex, int endIndex) {
        if (s == null) {
            return false;
        } else if (s.length() < 2 || endIndex <= startIndex) {
            return true;
        } else {
            // ignore capitalization
            s = s.toLowerCase();

            // pick off the first and last letters
            char first = s.charAt(startIndex);
            char last = s.charAt(endIndex);

            // recurse without the first or last letters if they're not
            // in the alphabet.
            if (ACCEPTABLE_CHARS.indexOf(first) == -1) {
                return isPalindrome(s, startIndex + 1, endIndex);
            } else if (ACCEPTABLE_CHARS.indexOf(last) == -1) {
                return isPalindrome(s, startIndex, endIndex - 1);
            }

            // return false if the first and last characters don't match
            // since we already verified they are in the alphabet.
            if (first != last) {
                return false;
            }

            // finally, simply recurse on the middle of the string to make sure
            // everything else left over is a palindrome
            return isPalindrome(s, startIndex + 1, endIndex - 1);
        }
    }
}

