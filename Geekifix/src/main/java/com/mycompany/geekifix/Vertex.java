/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Vertex<T> {
    private final T data;
    private boolean visited;    
    private List<Vertex<T>> neighbors = new LinkedList<>();

    public Vertex(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + '}';
    }
    
    public T getData(){
        return data;
    }
      
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex<T>> neighbors) {
        this.neighbors = neighbors;
    }
    
    
}
