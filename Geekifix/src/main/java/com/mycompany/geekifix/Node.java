/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Node<T> {
    private final T data;
    private Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData(){
        return data;
    }
    
    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
