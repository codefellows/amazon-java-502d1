package codefellows.datastructures;

public class ArrayList<E> implements List<E> {
    // Define the default beginning size of any codefellows.datastructures.ArrayList.
    // ArrayLists will start at this size, then double whenever they fill up.
    private static final int DEFAULT_SIZE = 10;

    // Data and size are private so users can't manipulate the internal structure
    // of the list without using the approved public methods.
    private E[] data;
    private int size;

    // Create an codefellows.datastructures.ArrayList with codefellows.datastructures.ArrayList.DEFAULT_SIZE.
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    // Create an codefellows.datastructures.ArrayList with a custom initial size
    public ArrayList(int size) {
        this.data = (E[]) new Object[size];
        this.size = 0;
    }

    // Returns the number of elements in the list.
    // Wrapping this.size around a getter like this ensures users can't
    // modify the actual value of this.size inside the class.
    @Override
    public int size() {
        return this.size;
    }

    // Returns true if there is nothing in the list.
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Appends the value to the end of the list
    @Override
    public void append(E value) {
        checkSize();

        // Add the value at the end of the list.
        this.data[this.size] = value;
        // Increase the total size of the list.
        this.size++;
    }

    // Inserts the value at the specified index.
    // Shifts all other values right to make room for the new value.
    @Override
    public void insert(int index, E value) {
        checkSize();

        // Shift all elements after the index one spot right to
        // make room for the new value.
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        // Write the new value at the index.
        this.data[index] = value;
        this.size++;
    }

    // Returns the element at the specified index position in the list.
    @Override
    public E get(int index) {
        return this.data[index];
    }

    // Searches for the first occurrence of a value and removes it from
    // the list. Elements after the value will shift left to fill the gap
    // left by it.
    // Returns true if the value was found and removed.
    @Override
    public boolean removeValue(E value) {
        // See if the value exists in the list.
        int index = this.indexOf(value);
        if (index < 0) {
            return false;
        }

        // Remove the value.
        this.removeAtIndex(index);
        return true;
    }

    // Removes the value at the specified index.
    // Returns the value at the index.
    // Shifts all elements after the value left to fill the gap left by
    // removing the value.
    @Override
    public E removeAtIndex(int index) {
        this.size--;

        // Save the value that was at the index.
        E value = this.data[index];

        // Shift elements left to fill the spot left by the removed element.
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        // Return the value that was at that index.
        return value;
    }

    // Return the index of the first occurrence of a value in the list.
    // Return -1 if the value doesn't exist.
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == value) {
                return i;
            }
        }

        // Return -1 if the value isn't found.
        return -1;
    }

    // Returns true if the list contains the value.
    @Override
    public boolean contains(E value) {
        int index = this.indexOf(value);
        return index >= 0;
    }

    // Utility method that checks to see if the list is full.
    // If the list is full it executes the expand() method to double the size of the list.
    private void checkSize() {
        if (this.size == this.data.length) {
            expand();
        }
    }

    // Doubles the size of the internal fixed-size array so more elements
    // can be added to the list.
    private void expand() {
        // Create a new array twice the size of the old array.
        E[] doubled = (E[]) new Object[this.data.length * 2];

        // Copy all the data from the original list into the double list.
        for (int i = 0; i < this.data.length; i++) {
            doubled[i] = this.data[i];
        }

        // Replace the old, full array with the new doubled array.
        this.data = doubled;
    }
}
