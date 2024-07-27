/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class LinkedList<T> implements List<T>{
    public Node<T> root;
    int size = 0;

    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data,null);
        node.setNext(root);
        root = node;
        size++;
    }

    @Override
    public void remove(T data) {
        if(root.getData().equals(data)){
            root = root.getNext();
        } else{
            Node<T> prev = root;
            Node<T> curr = root.getNext();
            while(curr != null){
                if(curr.getData().equals(data)){
                    prev.setNext(curr.getNext());
                    break;
                }
                prev = curr;
                curr = curr.getNext();
            }
        }
        size--;
    }

    @Override
    public void traverse() {
        if(isEmpty()){
            System.out.println("List is empty");
        }
        traverse(root);
    }
    
    void traverse(Node<T> node){
        if (node == null){
            return;
        }
        System.out.print(node.getData()+" ");
        traverse(node.getNext());
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public int size() {
        return size;
    }
}
