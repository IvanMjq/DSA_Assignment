/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author ivanmjq
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
    
    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }
    
    //clear the doubly linked list
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
        
    }
    
}
