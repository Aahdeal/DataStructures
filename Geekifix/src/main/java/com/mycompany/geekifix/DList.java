/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public interface DList<T> {
    void insertFront(T data);
    void insertBack(T data);
    void remove(T data);
    void traverseF();
    void traverseB();
    void reverse();
    boolean isEmpty();
}
