public class RawTypeLinkedList {
    public class RawTypeLinkedListNode {
        public Object data;
        RawTypeLinkedListNode next;

        RawTypeLinkedListNode(Object val) {
            this.data = val;
            this.next = null;
        }
    }

    public RawTypeLinkedListNode root;

    public RawTypeLinkedList() {
        this.root = null;
    }

    public void prepend(Object val) {
        RawTypeLinkedListNode node = new RawTypeLinkedListNode(val);
        if (this.root == null) {
            this.root = node;
        } else {
            node.next = this.root;
            this.root = node;
        }
    }

    public Object get(int index) {
        int ii = 0;

        RawTypeLinkedListNode current = this.root;
        while (ii != index && current != null) {
            current = current.next;
            ii++;
        }

        return current.data;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        RawTypeLinkedListNode current = this.root;
        while (current != null) {
            builder.append(" " + current.data);
            current = current.next;
        }

        return builder.toString();
    }

}
