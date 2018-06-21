# Dynamic Programming

## Resources
* [Memoization and Fibonacci](https://www.youtube.com/watch?v=P8Xa2BitN3I)
* [Buy and Sell Stock to Maximize Profit](https://www.youtube.com/watch?v=JaosdXkUWTs)
* [Dynamic Programming: Coin Change](https://www.youtube.com/watch?v=jaNZ83Q3QGc)
* [Edit Distance](https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/)

#BigInteger and Memoization
Java integers only go up to a maximum value. Fibonacci numbers get very large
very quick! The normal Java `int` type won't store the large values we'll be
computing. Use the `BigInteger` class to work with very large numbers.

Notice that creating `BigInteger` instances is done by passing a String
representation to the constructor. There are also class constants on BigInteger
for `ZERO`, `ONE` and `TEN`. I'm not sure why `TEN` is a class constant, but
here we're showing `return BigInteger.TEN.subtract(new BigInteger("9"));`
to show how to `.subtract` `BigInteger` instances and how to create an
arbitrary BigInteger using strings like using `"9"` here.

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

