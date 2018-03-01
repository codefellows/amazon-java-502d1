package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.Assert.*;

public class HashMapTest {
    // verbose System.out.println output options.
    private static boolean SEE_DEFAULT_HASH_MAP = true;
    private static boolean SEE_LARGE_HASH_MAP = true;

    private HashMap<Integer> zipCodes;
    private HashMap<Integer> manyBucketHashMap;

    @Before
    public void createZipCodes() {
        zipCodes = new HashMap<>();
        populateZipCodes(zipCodes);

        manyBucketHashMap = new HashMap(99);
        populateZipCodes(manyBucketHashMap);
    }
    @Test
    public void testSize() {
        assertEquals(28, zipCodes.size());
    }

    @Test
    public void testToString() {
        // Just make sure to print it out and it should be longer than 100
        String str = zipCodes.toString();
        assertTrue(str.length() > 100);

        if (SEE_DEFAULT_HASH_MAP) {
            System.out.println(str);
        }
    }

    @Test
    public void testHashCodes() {
        String key1 = "Renton";
        String key2 = "Downtown";
        String key3 = "Redmond";

        int hash1 = zipCodes.getHashCode(key1);
        int hash2 = zipCodes.getHashCode(key2);
        int hash3 = zipCodes.getHashCode(key3);

        assertEquals(630, hash1);
        assertEquals(864, hash2);
        assertEquals(713, hash3);

        int index1 = zipCodes.indexFromHash(key1);
        int index2 = zipCodes.indexFromHash(key2);
        int index3 = zipCodes.indexFromHash(key3);

        assertEquals(0, index1);
        assertEquals(3, index2);
        assertEquals(6, index3);
    }

    @Test
    public void testLargeBucketHashMap() {
        // it should have the same number of entries
        assertEquals(28, manyBucketHashMap.size());

        String key1 = "Renton";
        String key2 = "Downtown";
        String key3 = "Redmond";

        int hash1 = manyBucketHashMap.getHashCode(key1);
        int hash2 = manyBucketHashMap.getHashCode(key2);
        int hash3 = manyBucketHashMap.getHashCode(key3);

        assertEquals(630, hash1);
        assertEquals(864, hash2);
        assertEquals(713, hash3);

        int index1 = manyBucketHashMap.indexFromHash(key1);
        int index2 = manyBucketHashMap.indexFromHash(key2);
        int index3 = manyBucketHashMap.indexFromHash(key3);

        assertEquals(36, index1);
        assertEquals(72, index2);
        assertEquals(20, index3);

        if (SEE_LARGE_HASH_MAP) {
            System.out.println(manyBucketHashMap);
        }
    }

    @Test
    public void testHashCollissions() {
        String key1 = "Pioneer Square";
        String key2 = "Alki Beach";
        String key3 = "U District";

        int hash1 = manyBucketHashMap.getHashCode(key1);
        int hash2 = manyBucketHashMap.getHashCode(key2);
        int hash3 = manyBucketHashMap.getHashCode(key3);

        // The hashing algorithm is basically the "sum" of each letter in a String
        // Where A=1, B=2, C=3   (although A is really equal to 97, or something)
        // "cab" hashes to 3 + 1 + 2 = 6
        // "bac" hashes to 2 + 1 + 3 = 6
        // "cad" hashes to 3 + 1 + 4 = 8
        // "cab" and "bac" collide because they have the same hash value

        // None of these keys hash to the same value
        assertNotEquals(hash1, hash2);
        assertNotEquals(hash1, hash3);
        assertNotEquals(hash2, hash3);

        // But when they're modded by the number of buckets it's possible
        // they might end up as the same index
        int index1 = manyBucketHashMap.indexFromHash(key1);
        int index2 = manyBucketHashMap.indexFromHash(key2);
        int index3 = manyBucketHashMap.indexFromHash(key3);

        System.out.println("HASHED: " + key1 + "= " + hash1);
        System.out.println("HASHED: " + key2 + "= " + hash2);
        System.out.println("HASHED: " + key3 + "= " + hash3);
        System.out.println();

        System.out.println("INDEX: " + key1 + "= " + index1);
        System.out.println("INDEX: " + key2 + "= " + index2);
        System.out.println("INDEX: " + key3 + "= " + index3);
        System.out.println();

        // key1 and key2 ultimately "collide" at the same index
        // after their hash codes are modded by the number of buckets
        assertEquals(index1, index2);
        assertNotEquals(index1, index3);
    }

    // Utility method to populate a given map with a collection of known zip-codes
    private void populateZipCodes(HashMap map) {
        map.put("Bellevue",98005);
        map.put("Kirkland",98033);
        map.put("Lynnwood",98037);
        map.put("Mercer Island",98040);
        map.put("Redmond",98052);
        map.put("Renton",98055);
        map.put("Seattle",98101);
        map.put("Downtown",98101);
        map.put("Capital Hill",98102);
        map.put("Greenwood",98103);
        map.put("Freemont",98103);
        map.put("Greenlake",98103);
        map.put("International District",98104);
        map.put("Pioneer Square",98104);
        map.put("University District",98105);
        map.put("Laurelhurst",98105);
        map.put("Ballard",98107);
        map.put("South Lake Union",98109);
        map.put("Queen Anne",98109);
        map.put("Bainbridge Island",98110);
        map.put("Madrona",98110);
        map.put("West Seattle",98116);
        map.put("Alki Beach",98116);
        map.put("Columbia City",98118);
        map.put("Belltown",98121);
        map.put("Northgate",98125);
        map.put("Mount Baker",98144);
        map.put("Magnolia",98199);
    }

    @Test
    public void testMultHashCode() {
        String key1 = "Pioneer Square";
        String key2 = "Alki Beach";
        String key3 = "U District";

        int hash1 = manyBucketHashMap.getMultHashCode(key1);
        int hash2 = manyBucketHashMap.getMultHashCode(key2);
        int hash3 = manyBucketHashMap.getMultHashCode(key3);

        int index1 = hash1 % manyBucketHashMap.buckets.size();
        int index2 = hash2 % manyBucketHashMap.buckets.size();
        int index3 = hash3 % manyBucketHashMap.buckets.size();

        System.out.println("MULT HASHED: " + key1 + "= " + hash1);
        System.out.println("MULT HASHED: " + key2 + "= " + hash2);
        System.out.println("MULT HASHED: " + key3 + "= " + hash3);
        System.out.println();

        System.out.println("MULT INDEX: " + key1 + "= " + index1);
        System.out.println("MULT INDEX: " + key2 + "= " + index2);
        System.out.println("MULT INDEX: " + key3 + "= " + index3);
        System.out.println();
    }

}