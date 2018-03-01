package codefellows.datastructures;

public interface Queue<E> {
    int size();
    boolean isEmpty();
    void enqueue(E value);
    E dequeue();
    E peek();
}
