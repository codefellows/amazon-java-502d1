# ![CF](http://i.imgur.com/7v5ASc8.png) Streams 

## Resources
* [YouTube: Java 8 Streams Tutorial](https://www.youtube.com/watch?v=t1-YZ6bF-g0)

Streams can be created from COllections, Lists, Sets, ints, longs, double,
arrays, or lines of a file.

Stream operations are either intermediate or terminal:
* **Intermediate Operations** (filter, map, sort) return a stream and can chain
  together with more intermediate operations
* **Terminal Operations** (forEach, collect, reduce) are either void, or return
  a non-stream result.

* `.collect` saves the elements into a collection.
* Other common terminal operations:
  * count()
  * max()
  * min()
  * reduce()
  * summaryStatistics()

## Stream Examples

```java
IntStream
  .range(1, 10)
  .forEach(System.out::print);
```

```java
IntStream
  .range(1, 10)
  .skip(5)
  .forEach(x -> System.out.println(x);
```

```java
Stream.of("Ava", "Aneri", "Alberto")
  .sorted()
  .findFirst()
  ifPresent(System.out::println);
```

```java
String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika"};
Arrays.stream(names)
  .filter(x -> x.startsWith("S"))
  .sorted()
  .forEach(System.out::println);
```

```java
Arrays.stream(new int[] {2, 4, 6, 8, 10})
  .map(x -> x * x)
  .average()
  .ifPresent(System.out::println);
```

```java
List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika");
people.stream()
  .map(String::toLowerCase)
  .filter(x -> x.startsWith("a"))
  .forEach(System.out::println);
```

```java
Stream<String> bands = Files.lines(Paths.get("bands.txt"));
bands
  .sorted()
  .filter(x -> x.length() > 12)
  .forEach(System.out::println);
bands.close();
```

```java
Stream<String> rows = Files.lines(Paths.get("bands.txt"));
int rowCount = (int) rows.
  map(x -> x.split(","))
  .filter(x -> x.length == 3)
  .count();
rows.close();
```

```java
Stream<String> rows = Files.lines(Paths.get("data.txt"));
Map<String, Integer> map = new HashMap<>();
map = rows
  .map(x -> x.split(","))
  .filter(x -> x.length == 3)
  .filter(x -> Integer.parseInt(x[1]) > 15)
  .collect(Collectors.toMap(
    x -> x[0],
    x -> Integer.parseInt(x[1])));
rows.close();
```

```java
IntSummaryStatistics summary = IntStream.of(1, 23, 6, 4, 24, 45, 57, 56, 34, 23, 13, 34, 22)
  .summaryStatistics();
```

```java
List<Map.Entry<String, Integer>> top20 = result.entrySet().stream()
  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
  .limit(20)
  .collect(Collectors.toList());
```
