/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author WEI ZHENG
 */
public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {
  private MatchingNode<T> head, tail;
    private int size;

    public void add(T data) {
        MatchingNode<T> newNode = new MatchingNode<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public MatchingNode<T> getHead() { // ✅ Added getter method
        return head;
    }

    public void remove(T item) {
        MatchingNode<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        MatchingNode<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public T search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
