import java.util.Set;

public class SetUtil {
    public static int numberInCommon(Set<?> s1, Set<?> s2) {
        int count = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                count++;
            }
        }
        return count;
    }
}
