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

public class DoublyLinkedList<T> implements ListInterface<T>, Serializable {
    
    private Node head;
    private Node tail;
    private int length; 
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    //check if the list is empty or not
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    //get the length of the list
    @Override
    public int getLength() {
        return length;
    }
    
    //clear all the record in the list
    @Override
    public void clear() {
        while (tail != null) {
            Node prevNode = tail.prev;
            tail.next = null;  
            tail.prev = null;  
            tail.data = null;  
            tail = prevNode;  
        }
        head = null;  
        length = 0;  // Reset length after full clearance
    }
    
    @Override
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    //remove 
    @Override
    public void remove(T item) {
        Node current = head;
        while (current != null) {
            //match the provided item with the item of the node
            if (current.data.equals(item)) {
                //check the node is head or not
                if (current.prev != null) { 
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                //check the node is tail or not
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                length--;
                return;
            }
            /*
                if the current node are not match, 
                assign the next node with current node 
            */
            current = current.next;
        }
    }
    
    // for testing
    @Override
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
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
        
        public Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
            this.next = null;
        }
        
        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }      

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
        
    }
    
}
