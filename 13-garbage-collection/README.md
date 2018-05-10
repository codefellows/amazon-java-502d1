# ![CF](http://i.imgur.com/7v5ASc8.png) Garbage Collection 

* [Java Garbage Collection](https://www.youtube.com/watch?v=YvlexZFqFBE)
* [The finalize() Method](https://www.youtube.com/watch?v=j3fRK7T1pQo)
* [Stack vs Heap](https://stackoverflow.com/a/80113/735468)
* [Wikipedia: Reference Counting](https://en.wikipedia.org/wiki/Reference_counting)
* [Garbage Collection in Java 9](https://www.youtube.com/watch?v=OhPGN2Av44E)
* [Garbage Collection Concepts](https://dev.to/thecodeboss/programming-concepts-garbage-collection)

Garbage collection is the process Java uses to run through memory used by your
program to determine what's not used any more. As your program runs it makes
objects, uses objects, and objects fall out of use and don't need to live in
memory anymore. Java keeps track of this all automatically and cleans up space
when it needs room to for other things.

Memory isn't free! The program has to allocate and deallocate memory as it
runs. Thankfully, Java allocates memory dynamically. Programming languages
like C and C++ manage memory manually. Part of the Java language specification
actually specifies that a garbage collector be available.

Programmers use system calls like `mallac()` and `free()` to "allocate memory"
and "free memoery." 

Programming memory is divided between "the stack" and "the heap." The stack is
responsible for keeping track of function calls, parameters and things like
that. The stack automatically grows and shrinks. The heap is part of memory
reserved for dynamic allocation. 

Read the Stack Overflow answer about [Stack vs Heap](https://stackoverflow.com/a/80113/735468)!

## The finalize() Method
Java offers one class method you can customize that's called when an object is
gabage collected.

```java
class MyObject {
  int[] data;

  public MyObject() {
    // take up space!
    data = new int[10_000];
    System.out.println("New object at: " + this);
  }

  protected void finalize() {
    System.out.println("I don't feel so good. Garbage collecting at: " + this);
  }

  public static void main(String[] args) {
    while (true) {
      new MyObject();
    }
  }
}
```

## Reference Counting
Reference Counting is a way to track what pieces of memory are still in use or
are safe to be deleted. Imagine a pointer to every variable that's in scope
when your program runs. Reference counting totals up the number of pointers
pointing to any object or piece of data in the program. If the number of
pointers to a piece of data ever drops to zero then that piece of data becomes
a candidate for garbage collection.

Consider how it's possible to lose reference to nodes in a manually-implemented
LinkedList. A piece of data becomes a candidate for garbage collection when the
number of references drops to zero because there's no way someone in the
program will be able to access it without a reference!

### Mark/Sweep/Compact
**Mark:** Start from the root of an application, walk the entire object graph, mark
any object it reaches as "live."

**Sweep:** delete any unreachable objects.

**Compact:** squish all the memory together by moving objects around to
defragment memory. (Like Windows 95 defrag tool). Without compacting memory
memory can end up porous with lots of small holes all over the place, but no
large continuous area to place data requiring one long stretch of memory.

## Generational Algorithms
Generational Garbage Collection takes concepts from copying algorithms, but
instead of copying all surviving members to a new memory region, it instead
splits up memory into generational regions based on how old the memory is. The
rationale behind generational GC is that normally, young memory is garbage
collected much more frequently than older memory – so therefore the younger
memory region is scanned to check for unreferenced memory much more frequently
than older memory regions. If done properly, this saves both time and CPU
processing because the goal is to scan only the necessary memory.

Older memory regions are certainly still scanned – but not as often as younger
memory regions. If a block of memory in a younger memory region continues to
survive, then it can be promoted to an older memory region and will be scanned
less often.

## Performance Concerns
Garbage Collection comes at a cost. C and C++ programmers may scoff at the idea
because they're used to managing these complexities themselves. Garbage
Collection absolutely takes time to run. It can lead to spurts of
unresponsiveness in your program, like if you've ever seen Microsoft Word lock
up while yo're in the middle of using it.

Java doesn't offer explicit control over when Garbage Collection runs. It's all
automatic. You can use `System.gc()` to request garbage collection, but it's
considered bad practice.

[Why is calling System.gc() bad practice?](https://stackoverflow.com/questions/2414105/why-is-it-bad-practice-to-call-system-gc/2414621#2414621)

##
* [Challenge: Graph Connectedness](https://www.codewars.com/kata/graph-operations-part-4-is-it-connected/java)
