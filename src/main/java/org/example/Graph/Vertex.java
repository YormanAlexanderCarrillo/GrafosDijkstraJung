package org.example.Graph;

import java.util.ArrayList;

public class Vertex <T>{
    private T info;
    private ArrayList<Vertex<T>> adyacents;
    private boolean visited;

    public Vertex(T info){
        this.info = info;
        adyacents = new ArrayList<>();
        visited = false;
    }

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public boolean isVisited(){
        return visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public void addVertex(Vertex<T> vertex){
        adyacents.add(vertex);
    }

    public boolean isAdyacent(Vertex<T> vertex){
        return adyacents.contains(vertex);
    }

    public ArrayList<Vertex<T>> getAdyacents(){
        return (ArrayList<Vertex<T>>) adyacents.clone();
    }

    @Override
    public String toString() {
        return info.toString();
    }

}
