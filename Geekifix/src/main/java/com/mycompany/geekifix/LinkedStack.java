/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class LinkedStack<T> implements Stack<T> {
    LinkedList<T> linkedStack = new LinkedList<>();
    int size = 0;
    
    @Override
    public void push(T data) {
        linkedStack.insert(data);
        size++;
    }

    @Override
    public T pop(){
        T temp = linkedStack.root.getData();
        linkedStack.remove(linkedStack.root.getData());
        size--;
        return temp;
        
    }

    @Override
    public T top() {
        return linkedStack.root.getData();
    }
    
    @Override
    public boolean isEmpty(){
        return (size==0);
    }
    
}
