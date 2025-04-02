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
    
    // Add node into the given position
    @Override
    public boolean add(int givenPosition, T newData) { // Out of memory error possible
        boolean isSuccessful = true;
        
        try{
            if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) { // If the list if empty
                Node newNode = new Node(newData);
            
                if (isEmpty() || (givenPosition == 1)) {
                    if (head != null) {
                        newNode.next = head;
                        head.prev = newNode;
                    }
                    head = newNode;
                    if (tail == null) { 
                        tail = newNode;
                    }
              
                }else if (givenPosition == numberOfEntries + 1) {
                       tail.next = newNode;
                       newNode.prev = tail;
                       tail = newNode;
                       
                }else {
                    Node nodeBefore = head;
                    
                    for (int i = 0; i < givenPosition - 1; ++i) {
                        nodeBefore = nodeBefore.next;
                    }
                    
                    newNode.prev = nodeBefore.prev;
                    nodeBefore.prev = newNode;
                    newNode.next = nodeBefore;
                    newNode.prev.next = newNode;
                }
                numberOfEntries++;
            } else {
                isSuccessful = false;
            }
        }catch (Exception e){
            e.printStackTrace();
            isSuccessful = false;
        }

        
        return  isSuccessful;       
    }
    
//    @Override
//    public boolean add(int givenPosition, T newData) { // Out of memory error possible
//        boolean isSuccessful = true;
//        
//        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) { // If the list if empty
//            Node newNode = new Node(newData);
//            
//            if (isEmpty() || (givenPosition == 1)) {
//                newNode.next = head;
//                head = newNode;
//            } else {
//                Node tempNode = head;
//                for (int i = 0; i < givenPosition - 1; ++i) {
//                    tempNode = tempNode.next;
//                }
//                newNode.prev = tempNode.prev;
//                tempNode.prev = newNode;
//                newNode.next = tempNode;
//                
//                if (newNode.prev != null) {
//                    newNode.prev.next = newNode;
//                } else {
//                    head = newNode;
//                }
//            }
//            numberOfEntries++;
//        } else {
//            isSuccessful = false;
//        }
//        
//        return  isSuccessful;       
//    }
    
    // Add few items into the list
    @Override
    @SafeVarargs
    public final String addAll(T... newDatas) {
        StringBuilder failedMessage = new StringBuilder("Failed to add : \n");
        int failedCounts = 0;
        
        for (T newData : newDatas) {
            boolean isSuccessful = add(newData);
            if (!isSuccessful) {          
                failedMessage.append(newData);
                failedMessage.append("\n");
                failedCounts++;
            }            
        }
        
        if (failedCounts == 0) {
            return null;
        } else {
            return failedMessage.toString();
        }
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
                }
            } 
            numberOfEntries--;
        }
        
        return result; // return rmemoved entry, or null for failed operations
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
