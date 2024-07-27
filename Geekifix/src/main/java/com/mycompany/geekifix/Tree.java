/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public interface Tree<T extends Comparable<T>> {
    
    Tree<T> insert(T data);
    
    void delete(T data);
    
    void traverse();
    
    T getMax();
    T getMin();
    
    boolean isEmpty();
}
