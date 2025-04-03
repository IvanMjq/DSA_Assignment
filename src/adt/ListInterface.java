/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author ivanmjq
 */
public interface ListInterface<T> extends Iterable<T>{
    
    public void clear();
    
    public boolean add(T newData);
    
    public boolean add(int givenPosition, T newData);
    
    public String addAll(T... newDatas); //  ?????
    
    public boolean replace(int givenPosition, T newData);
    
    public T remove(int givenPosition);
    
    public T getData(int givenPosition);
    
//    public boolean contain(T dataEntry);
    
    public int size();
    
    public boolean isEmpty();
    
    public String displayForward();    
    
    public String displayBackward();   
}
