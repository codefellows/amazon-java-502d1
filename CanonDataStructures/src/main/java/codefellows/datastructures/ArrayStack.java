package codefellows.datastructures;

public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> list;

    public ArrayStack() {
        list = new ArrayList<>();
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
        list.append(value);
    }

    @Override
    public E pop() {
        if (!list.isEmpty()) {
            return list.removeAtIndex(list.size() - 1);
        }
        return null;
    }

    @Override
    public E peek() {
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        return null;
    }
}
