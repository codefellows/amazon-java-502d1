public class Thing {
    int[] data;

    public Thing() {
        // take up space!
        data = new int[10_000];
        //System.out.println("New object at: " + this);
    }

    protected void finalize() {
        //System.out.println("I don't feel so good. Garbage collecting at: " + this);
        GarbageCollection.hasCollected = true;
    }

}


