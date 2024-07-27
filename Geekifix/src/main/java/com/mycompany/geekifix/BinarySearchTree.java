/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private NodeBST<T> root;
    
    @Override
    public Tree<T> insert(T data) {       
        if(isEmpty()){
            root = new NodeBST<>(data);
        }else{
            insert(data, root);
        }
        return this;
    }
    
    private void insert(T data, NodeBST<T> node){
        if(data.compareTo(node.getData()) < 0){
            if(node.getLeftChild() == null){
               NodeBST<T> newNode = new NodeBST<>(data);
               node.setLeftChild(newNode);
            }else{
               insert(data, node.getLeftChild());
            }       
        }else if(data.compareTo(node.getData()) > 0){
            if(node.getRightChild() == null){
               NodeBST<T> newNode = new NodeBST<>(data);
               node.setRightChild(newNode);
            }else{
               insert(data, node.getRightChild());
            }     
        }
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }
    
    private NodeBST<T> delete(T data, NodeBST<T> node){
        if(node == null){
            return null;
        }
        if(data.compareTo(node.getData())<0){
            node.setLeftChild(delete(data, node.getLeftChild()));
        }else if(data.compareTo(node.getData())>0){
            node.setRightChild(delete(data,node.getRightChild()));
        }else{
            if(node.getLeftChild()==null){
                return node.getRightChild();
            }else if(node.getRightChild()==null){
                return node.getLeftChild();
            }
            node.setData(getMax());
            node.setLeftChild(delete(node.getData(),node.getLeftChild()));
        }
        return node;
    }

    @Override
    public void traverse() {
        traverseinOrder(root);
    }
    
    private void traverseinOrder(NodeBST<T> node){
        if(node != null){
            traverseinOrder(node.getLeftChild());
            System.out.println(node.getData());
            traverseinOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if(isEmpty()){
            return null;
        }
        NodeBST<T> node = root;
        while(node.getRightChild() != null){
            node = node.getRightChild();
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if(isEmpty()){
            return null;
        }
        NodeBST<T> node = root;
        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node.getData();
    }
    

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    
    
}
