package codefellows.datastructures;

public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E value);
    E pop();
    E peek();
}
