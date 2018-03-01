package codefellows.datastructures;

public class LinkedQueue<E> implements Queue<E> {
    private LinkedList<E> list;

    public LinkedQueue() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E value) {
        list.append(value);
    }

    @Override
    public E dequeue() {
        if (!this.isEmpty()) {
            return list.removeAtIndex(0);
        }
        return null;
    }

    @Override
    public E peek() {
        if (!this.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
