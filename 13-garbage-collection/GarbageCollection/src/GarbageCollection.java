import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GarbageCollection {
    public static int totalBeforeCollection = 0;
    public static boolean hasCollected = false;

    public static void main(String[] args) {
        List<Thing> objects = new LinkedList<>();

        while (true) {
            totalBeforeCollection++;
            Thing thing = new Thing();
            objects.add(thing);
            if (hasCollected) {
                System.out.println("Created " + totalBeforeCollection + " before garbage collection");
                System.exit(0);
            }
        }
    }
}
