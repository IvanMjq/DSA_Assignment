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
    
    public void clear();
    
    public boolean add(T newData);
    
    public boolean add(int givenPosition, T newData);
    
    public String addAll(T... newDatas);
    
    public boolean replace(int givenPosition, T newData);
    
    public T remove(int givenPosition);
    
    public T getEntry(int givenPosition);
    
    public int getNumberOfEntries();
    
    public boolean isEmpty();
    
    public String display();    
    
}
