/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class DoublyLinkedList<T> implements DList<T> {
    class Node<T>{
         private final T data;
         private Node<T> prev;
         private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
         
         public T getData(){
             return data;
         }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

     }
    
    int size;
    private Node<T> head;
    private Node<T> tail;
    
    @Override
    public void insertBack(T data) {
        Node<T> node = new Node(data,null,null);
        if(isEmpty()){
            head=tail=node;
        }else{
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
    }
    
    @Override
    public void remove(T data){
        if(isEmpty()){
            System.out.println("list is empty");
        }
        else{
            Node<T> curr = head;
            while(curr!=null){
                if (curr.getData() == data){
                    curr.getPrev().setNext(curr.getNext());
                    curr.getNext().setPrev(curr.getPrev());
                    curr=null;
                }
                else{
                    curr = curr.getNext();
                }
            }
        }
    }

    @Override
    public void traverseF() {
        if(isEmpty()){
            System.out.println("list is empty");
        }
        else{Node<T> curr = head;
        while(curr != null){
            System.out.print(curr.getData()+" ");
            curr = curr.getNext();
        }
        System.out.println();}
    }

    @Override
    public void traverseB() {
        if(isEmpty()){
            System.out.println("list is empty");
        }
        else{Node<T> curr = tail;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr = curr.getPrev();
        }
        System.out.println();}
    }

    @Override
    public void reverse() {
        System.out.println();
    }
    
    @Override
    public boolean isEmpty(){
        return (size==0);
    }
 
    @Override
    public void insertFront(T data) {
        Node<T> node = new Node(data,null,null);
        if(isEmpty()){
            head = node;
            tail = head;
        }
        else{
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
    } 
}
