/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author ivanmjq
 */
public interface ListInterface<T> {
    
    public boolean isEmpty();
    public int getLength();
    public void clear();
    public void add(T item);
    public void remove(T item);
    public void display();    
    
}
