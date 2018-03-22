package codefellows.datastructures;

public class LinkedList<E> implements List<E> {
    public class ListNode<E> {
        E value;
        ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public ListNode<E> root;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void append(E value) {
        if (this.root == null) {
            this.root = new ListNode<E>(value);
        } else {
            ListNode current = this.root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }

        this.size++;
    }

    @Override
    public void insert(int index, E value) {
        // Deal with adding things at the beginning of the list.
        if (index == 0) {
            ListNode node = new ListNode(value, this.root);
            this.root = node;
        } else {
            int count = 0;
            ListNode current = this.root;

            while (current.next != null && count < index) {
                current = current.next;
                count++;
            }

            ListNode node = new ListNode(value, current.next);
            current.next = node;
        }

        this.size++;
    }

    @Override
    public E get(int index) {
        int count = 0;
        ListNode<E> current = this.root;

        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public void set(int index, E value) {
        int count = 0;
        ListNode<E> current = this.root;

        while (count < index) {
            current = current.next;
            count++;
        }

        current.value = value;
    }

    @Override
    public boolean removeValue(E value) {
        int index = this.indexOf(value);
        if (index < 0) {
            return false;
        }

        this.removeAtIndex(index);
        return true;
    }

    @Override
    public E removeAtIndex(int index) {
        if (index >= this.size) {
            String messageFormat = "Tried to remove element at %d with only %d elements in the list.";
            String errorMessage = String.format(messageFormat, index, this.size);
            errorMessage += "\n" + this.toString();
            throw new IndexOutOfBoundsException(errorMessage);
        }

        // value to be returned at the end of all the different cases.
        E value;

        // front of the list
        if (index == 0) {
            value = this.root.value;
            this.root = this.root.next;
        } else if (index == this.size - 1) {
            // end of the list
            ListNode<E> current = this.root;
            while (current.next.next != null) {
                current = current.next;
            }

            value = current.next.value;
            current.next = current.next.next;
        } else {
            // middle of the list
            int count = 0;
            ListNode<E> current = this.root;

            while (current.next != null && (count + 1) < index) {
                current = current.next;
                index++;
            }
            value = current.next.value;
            current.next = current.next.next;
        }

        this.size--;
        return value;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = this.root;

        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }

        // Return -1 if this iterated through the entire list without
        // finding the value we're looking for.
        return -1;
    }

    // Returns true if the value is in the list.
    @Override
    public boolean contains(E value) {
        int index = this.indexOf(value);
        return index >= 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (this.size == 0) {
            return "[]";
        } else if (this.size == 1) {
            return "[" + this.root.value + "]";
        } else {
            ListNode<E> current = this.root.next;
            str.append("[" + this.root.value);

            while (current != null) {
                str.append("," + current.value);
                current = current.next;
            }
            str.append("]");
        }
        return str.toString();
    }

}
