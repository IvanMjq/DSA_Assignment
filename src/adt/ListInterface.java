/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Comparator;

/**
 *
 * @author ivanmjq
 * @param <T>
 */
public interface ListInterface<T> extends Iterable<T>{
    
    public void clear();
    
    public boolean add(T newData);
    
    public boolean replace(int givenPosition, T newData);
    
    public T remove(int givenPosition);
    
    public T getData(int givenPosition);
    
    public int size();
    
    public T getLastData();
    
    public boolean isEmpty();
    
    public String displayForward();    
    
    public String displayBackward();   

    public int indexOf(T data);
    
    public void bubbleSort(Comparator<T> comparator);
}
