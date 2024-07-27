/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class NodeBST<T extends Comparable<T>> {
    
    private T data;
    private NodeBST<T> leftChild;
    private NodeBST<T> rightChild;

    public NodeBST(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBST<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<T> rightChild) {
        this.rightChild = rightChild;
    }
    
}
