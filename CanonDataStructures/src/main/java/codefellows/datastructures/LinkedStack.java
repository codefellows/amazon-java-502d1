package codefellows.datastructures;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedStack() {
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

    // Push a new value on top of the stack.
    // Insert it at the front of the list.
    @Override
    public void push(E value) {
        list.insert(0, value);
    }

    @Override
    public E pop() {
        if (!list.isEmpty()) {
            return list.removeAtIndex(0);
        }
        return null;
    }

    @Override
    public E peek() {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
