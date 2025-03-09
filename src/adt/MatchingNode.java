/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author WEI ZHENG
 */
public class MatchingNode<T> {
  T data;
    MatchingNode<T> next;
    MatchingNode<T> prev;

    public MatchingNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() { // ✅ Getter for data
        return data;
    }

    public MatchingNode<T> getNext() { // ✅ Getter for next node
        return next;
    }

    public MatchingNode<T> getPrev() { // ✅ Getter for previous node
        return prev;
    }
}

