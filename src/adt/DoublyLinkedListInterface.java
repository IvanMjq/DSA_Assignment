/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author WEI ZHENG
 */
public interface DoublyLinkedListInterface<T> {
     void add(T item);
    void remove(T item);
    T search(String id);
    boolean isEmpty();
    int size();
    void display();
}
