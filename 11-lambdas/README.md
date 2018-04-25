# ![CF](http://i.imgur.com/7v5ASc8.png) Lambdas 

## Resources
* [Java Tutorials: Lambdas](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
* [Jenkov: Lambdas](http://tutorials.jenkov.com/java/lambda-expressions.html) 

Java lambda expressions are new in Java 8. Java lambda expressions are Java's
first step into functional programming. A Java lambda expression is thus
a function which can be created without belonging to any class. A lambda
expression can be passed around as if it was an object and executed on demand.

A Lambda expression looks like this

```java
(oldState, newState) -> System.out.println("State changed")
```

Before Java 8 you would have to specify what interface to implement, when
making anonymous interface implementations. Here is the anonymous interface
implementation example from the beginning of this text:

```java
stateOwner.addStateListener(new StateChangeListener() {

    public void onStateChange(State oldState, State newState) {
        // do something with the old and new state.
    }
});
```

With lambda expressions the type can often be inferred from the surrounding
code. For instance, the interface type of the parameter can be inferred from
the method declaration of the addStateListener() method (the single method on
the StateChangeListener interface). This is called type inference. The compiler
infers the type of a parameter by looking elsewhere for the type - in this case
the method definition. Here is the example from the beginning of this text,
showing that the StateChangeListener interface is not mentioned in the lambda
expression:

```java
stateOwner.addStateListener(
    (oldState, newState) -> System.out.println("State changed")
);
```

## Lambda Syntax Variety
The syntax of lambda expressions supports many options. Consider all the
combinations of variations of what an expression can be: does it have zero,
or many parameters? Is it a short one-liner, or does it have a few lines?
Is anything returned from it? The variety in lambda syntax allows you to
mix and match to cover a wide variety of scenarios. For instance: you
don't have to write `return` if you write a short one-liner, but you
do have to write `return` if your lambda encompasses many lines.

* **Parameters** - does the lambda accept zero, one, or more than one
  parameter?
* **Body** - is the lambda on one line, or should it spread it self
  across multiple lines?
* **Return values** - does the lambda return anything?

```java
p1 -> System.out.println("one parameters here, without parenthesis");
(p1) -> System.out.println("one parameter here too, with parenthesis");

() -> System.out.println("zero parameters here, parenthesis required.");
(p1, p2) -> System.out.println("multiple parameters here, parenthesis required.");

(Car car) -> System.out.println("Sometimes you need to specifiy the type of a param");

(p1, p2) -> {
  System.out.println("Use curly braces");
  System.out.println("to create code blocks");
  System.out.println("across multiple lines");
}


(p1, p2) -> {
  System.out.println("Is it possible to return things?");
  return true;
}

() -> "if it's a one-liner like this then this String returns too!";
```
