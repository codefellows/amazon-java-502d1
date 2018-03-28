# ![CF](http://i.imgur.com/7v5ASc8.png) Threads, Joins, 

## Resources
* [The Java Tutorials: Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
* [Deadlock](https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html)
* [Atomic Access](https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html)
* [What is test-and-set used for?](https://stackoverflow.com/a/120999/735468)

## Learning Objectives
* Students will learn more Java constructs to help them deal with concurrency
* Students will learn how concurrent programs can jam themselves in "deadlock"

## Test and Set
* [What is test-and-set used for?](https://stackoverflow.com/a/120999/735468)

Say two threads execute a = a + 1. Say a starts with the value 100. If both
threads are running at the same time (multi-core), both would load a as 100,
increment to 101, and store that back in  a. Wrong!

With test-and-set, you are saying "Set a to 101, but only if it currently has
the value 100." In this case, one thread will pass that test but the other will
fail. In the failure case, the thread can retry the entire statement, this time
loading a as 101. Success.

This is generally faster than using a mutex because:

1. Most of the time there isn't a race condition, so the update happens without
   having to acquire some sort of mutex.
2. Even during collision, one thread isn't blocked at all, and it's faster for
   the other thread to just spin and retry than it would be to suspend itself
   in line for some mutex.

## Deadlock
* [Deadlock](https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html)

Deadlock occurs when two threads in a program are waiting for something that's
mutually exclusive. Someone on Twitter explains deadlock with this succinct
situation:

```
Interviewer: Explain deadlock and we'll hire you.
  Candidate: Hire me and I'll explain deadlock.
```

* The interviewer won't hire the candidate until they explain deadlock.
* The candidate won't explain deadlock until they're hired.
* They will be stuck waiting for each other forever.

Deadlock can happen in programs. It happens especially often in concurrenct
programs. Consider the following.

Alphonse and Gaston are friends, and great believers in courtesy. A strict rule
of courtesy is that when you bow to a friend, you must remain bowed until your
friend has a chance to return the bow. Unfortunately, this rule does not
account for the possibility that two friends might bow to each other at the
same time. This example application, Deadlock, models this possibility:

```java
public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                + "  has bowed to me!%n",
                this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
```
