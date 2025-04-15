/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author ivanmjq
 * @author WEI ZHENG
 */
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>, Serializable, Iterable<T> {

    private Node head;
    private Node tail;
    private int numberOfEntries;

    public DoublyLinkedList() {
        clear();
    }

    // Clear all the record in the list
    @Override
    public final void clear() {
        while (tail != null) {
            Node prevNode = tail.prev;
            tail.next = null;
            tail.prev = null;
            tail.data = null;
            tail = prevNode;
        }
        head = null;
        numberOfEntries = 0;  // Reset length after full clearance
    }

    // Add as last node into the list 
    @Override
    public boolean add(T newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        numberOfEntries++;
        return true;
    }

    // Replace the given node with new T data
    @Override
    public boolean replace(int givenPosition, T newData) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node current = head;
            for (int i = 0; i < givenPosition - 1; ++i) {
                current = current.next;
            }
            current.data = newData;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    // Remove node with given position
    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
                result = head.data;
                head = head.next;
            } else {
                Node choosenNode = head;
                for (int i = 0; i < givenPosition - 1; ++i) {
                    choosenNode = choosenNode.next;
                }
                result = choosenNode.data;
                // change next node
                if (choosenNode.next != null) {
                    choosenNode.next.prev = choosenNode.prev;
                    choosenNode.prev.next = choosenNode.next;
                } else {
                    tail = choosenNode.prev;
                    tail.next = null;
                }
            }
            numberOfEntries--;
        }
        return result; // Return rmemoved entry, or null for failed operations
    }

    // Get the data with the given entry
    @Override
    public T getData(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node current = head;
            for (int i = 0; i < givenPosition - 1; ++i) {
                current = current.next;
            }
            result = current.data;
        }
        return result;
    }

    @Override
    public T getLastData() {
        return tail.data;
    }

    // Get the Number Of Entries of the list
    @Override
    public int size() {
        return numberOfEntries;
    }

    // Check if the list is empty or not
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // For testing
    @Override
    public String displayForward() {
        String outputStr = "";
        Node current = head;
        while (current != null) {
            outputStr += current.data + "\n";
            current = current.next;
        }
        return outputStr;
    }

    @Override
    public String displayBackward() {
        String outputStr = "";
        Node current = tail;
        while (current != null) {
            outputStr += current.data + "\n";
            current = current.prev;
        }
        return outputStr;
    }

//    public ListInterface<T> getSortedList(Comparator<T> comparator) {
//        // Step 1: Clone the current list
//        ListInterface<T> sortedList = new DoublyLinkedList<>();
//        for (T data : this) {
//            sortedList.add(data); // shallow copy; assumes T doesn't need deep clone
//        }
//
//        // Step 2: Sort the cloned list using bubble sort
//        ((DoublyLinkedList<T>) sortedList).bubbleSort(comparator);
//
//        // Step 3: Return the sorted clone
//        return sortedList;
//    }

//    @Override
//    public void bubbleSort(Comparator<T> comparator) {
//        boolean swapped;
//        Node end = null;
//
//        do {
//            swapped = false;
//            Node<T> current = head;
//
//            while (current != null && current.next != end) {
//                if (comparator.compare(current.data, current.next.data) > 0) {
//                    T temp = current.data;
//                    current.data = current.next.data;
//                    current.next.data = temp;
//                    swapped = true;
//                }
//                current = current.next;
//            }
//            end = current;
//        } while (swapped);
//    }

    @Override
    public int indexOf(T data) {
        int index = 1;
        Node current = head;

        // Traverse the list from the head to the tail
        while (current != null) {
            if (current.data.equals(data)) {
                return index; // Return the index when the data is found
            }
            current = current.next;
            index++;
        }

        return -1; // Return -1 if the data is not found in the list
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private class Node {

        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

    }

}
