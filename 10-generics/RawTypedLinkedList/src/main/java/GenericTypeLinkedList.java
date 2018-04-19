public class GenericTypeLinkedList<E> {
    public class GenericTypeLinkedListNode {
        public E data;
        GenericTypeLinkedListNode next;

        GenericTypeLinkedListNode(E val) {
            this.data = val;
            this.next = null;
        }
    }

    public GenericTypeLinkedListNode root;

    public GenericTypeLinkedList() {
        this.root = null;
    }

    public E get(int index) {
        int ii = 0;

        GenericTypeLinkedListNode current = this.root;
        while (ii != index && current != null) {
            current = current.next;
            ii++;
        }

        return current.data;
    }

    public void prepend(E val) {
        GenericTypeLinkedListNode node = new GenericTypeLinkedListNode(val);
        if (this.root == null) {
            this.root = node;
        } else {
            node.next = this.root;
            this.root = node;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        GenericTypeLinkedListNode current = this.root;
        while (current != null) {
            builder.append(" " + current.data);
            current = current.next;
        }

        return builder.toString();
    }

}
