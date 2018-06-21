#BigInteger and Memoization

```java
import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    System.out.println(fib(1));
    System.out.println(fib(15));
    System.out.println(fib(25));
    System.out.println(fib(35));
    System.out.println(fib(40));
    System.out.println(fib(200));
  }

  public static BigInteger fib(int n) {
    return fib(n, new HashMap<Integer, BigInteger>());
  }

  public static BigInteger fib(int n, Map<Integer, BigInteger> memo) {
    if (n <= 2) {
      return BigInteger.TEN.subtract(new BigInteger("9"));
    } else if (!memo.containsKey(n)) {
      memo.put(n, fib(n-1, memo).add(fib(n-2, memo)));
    }
    return memo.get(n);
  }
}
```
