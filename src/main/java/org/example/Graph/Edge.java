package org.example.Graph;

public class Edge {
    private String nodeOrigin, nodeDestine;
    public double weight;
    private static int edgeCount = 1;

    public Edge(double weight, String nodeOrigin, String nodeDestine){
        this.nodeOrigin = nodeOrigin;
        this.nodeDestine = nodeDestine;
        this.weight = weight;
    }

    public String getnodeOrigin() {
        return nodeOrigin;
    }

    public String getnodeDestine() {
        return nodeDestine;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString(){//mensaje que se muestra sobre la arista "ruta"
        return "("+nodeOrigin+"-"+nodeDestine+") distancia(km): "+weight;
    }

}
