import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    public class ListNode {
        E data;
        ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode root;

    public MyLinkedList() {
        this.root = null;
    }

    public void prepend(E data) {
        ListNode node = new ListNode(data);
        if (this.root == null) {
            this.root = node;
        } else {
            node.next = this.root;
            this.root = node;
        }
    }

    @Override
    public Iterator<E> iterator() {
        ListNode root = this.root;

        Iterator<E> iter = new Iterator<E>() {
            ListNode current = root;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
        return iter;
    }

}
