public class NumberAdderLinkedList<E extends Number> {
    public class ListNode {
        E data;
        ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode root;

    public NumberAdderLinkedList() {
        this.root = null;
    }

    public void prepend(E val) {
        ListNode node = new ListNode(val);
        if (this.root == null) {
            this.root = node;
        } else {
            node.next = this.root;
            this.root = node;
        }
    }

    public double sum() {
        double sum = 0;

        ListNode current = this.root;
        while (current != null) {
            sum += current.data.doubleValue();
            current = current.next;
        }

        return sum;
    }
}
