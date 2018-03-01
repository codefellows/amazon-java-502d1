package codefellows.datastructures;

public class HashMap<V> {
    public static final int DEFAULT_NUM_BUCKETS = 7;

    public class HashedElement {
        public String key;
        public V value;

        public HashedElement(String key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + key + "->" + value + "}";
        }
    }

    // A fixed-size array of LinkedLists that contain HashedElements.
    public ArrayList<LinkedList<HashedElement>> buckets;

    // The total number of hashed elements stored in the HashMap.
    private int size;

    public HashMap() {
        this(DEFAULT_NUM_BUCKETS);
    }

    public HashMap(int numBuckets) {
        // Create the fixed-size array with the default number of buckets.
        buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.append(new LinkedList<>());
        }
    }

    public int size() {
       return this.size;
    }

    public void put(String key, V value) {
        int index = this.indexFromHash(key);

        HashedElement el = new HashedElement(key, value);
        buckets.get(index).append(el);
        this.size++;
    }

    public V get(String key) {
        // hash the key, get the index, and determine where it should appear in the array
        int index = this.indexFromHash(key);

        // Iterate through the bucket at the index and look for a HashedElement
        // with the key we're looking for.
        List<HashedElement> elements = buckets.get(index);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).key.equals(key)) {
                return elements.get(i).value;
            }
        }

        // No value found stored with key
        return null;
    }

    public boolean update(String key, V value) {
        // hash the key, get the index, and determine where it should appear in the array
        int index = this.indexFromHash(key);

        // Iterate through the bucket at the index and look for a HashedElement
        // with the key we're looking for.
        List<HashedElement> elements = buckets.get(index);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).key.equals(key)) {
                elements.get(i).value = value;
                return true;
            }
        }

        return false;
    }

    public int indexFromHash(String key) {
        int hash = this.getHashCode(key);
        int index = hash % this.buckets.size();
        return index;
    }


    public int getMultHashCode(String key) {
        int hash = 1;
        for (int i = 0; i < key.length(); i++) {
            hash *= (int) key.charAt(i);
        }
        return Math.abs(hash);
    }

    public int getHashCode(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += (int) key.charAt(i);
        }
        return hash;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.buckets.size(); i++) {
            LinkedList<HashedElement> bucket = buckets.get(i);
            str.append("Bucket " + i + ": " + bucket + "\n");
        }

        return str.toString();
    }
}
