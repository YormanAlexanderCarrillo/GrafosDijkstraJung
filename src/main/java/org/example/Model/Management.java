package org.example.Model;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import org.apache.commons.collections15.Transformer;
import org.example.Graph.Edge;
import org.example.Graph.Vertex;

import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;

public class Management {


    private Graph<Vertex<Point>, Edge> graph;

    private DijkstraShortestPath<Vertex<Point>, Edge> alg;

    // creamos vertices
    private Vertex<Point> London;
    private Vertex<Point> Dover;
    private Vertex<Point> Southampton;
    private Vertex<Point> Plymouth;
    private Vertex<Point> Cardiff;
    private Vertex<Point> Swansea;
    private Vertex<Point> Birmingham;
    private Vertex<Point> Cambridge;
    private Vertex<Point> Felixstowe;
    private Vertex<Point> Sheffield;
    private Vertex<Point> Liverpool;
    private Vertex<Point> Manchester;
    private Vertex<Point> Grimsby;
    private Vertex<Point> Node1;
    private Vertex<Point> Node2;
    private Vertex<Point> Node3;
    private Vertex<Point> Node4;

    private int seleccion, seleccion2;

    public Management() {
        initialize();
    }

    public void initialize() {
        graph = new SparseMultigraph<Vertex<Point>, Edge>();

        // damos info a los vertices
        London = new Vertex<Point>(new Point("London"));
        Dover = new Vertex<Point>(new Point("Dover"));
        Southampton = new Vertex<Point>(new Point("Southampton"));
        Plymouth = new Vertex<Point>(new Point("Plymouth"));
        Cardiff = new Vertex<Point>(new Point("Cardiff"));
        Swansea = new Vertex<Point>(new Point("Swansea"));
        Birmingham = new Vertex<Point>(new Point("Birmingham"));
        Cambridge = new Vertex<Point>(new Point("Cambridge"));
        Felixstowe = new Vertex<Point>(new Point("Felixstowe"));
        Sheffield = new Vertex<Point>(new Point("Sheffield"));
        Liverpool = new Vertex<Point>(new Point("Liverpool"));
        Manchester = new Vertex<Point>(new Point("Manchester"));
        Grimsby = new Vertex<Point>(new Point("Grimsby"));
        Node1 = new Vertex<Point>(new Point("Node1"));
        Node2 = new Vertex<Point>(new Point("Node2"));
        Node3 = new Vertex<Point>(new Point("Node3"));
        Node4 = new Vertex<Point>(new Point("Node4"));

        graph.addEdge(new Edge(123, "London", "Dover"), London, Dover);
        graph.addEdge(new Edge(150, "London", "Felixstowe"), London, Felixstowe);
        graph.addEdge(new Edge(100, "London", "Cambridge"), London, Cambridge);
        graph.addEdge(new Edge(128, "London", "Southampton"), London, Southampton);
        graph.addEdge(new Edge(215, "London", "Node2"), London, Node2);
        graph.addEdge(new Edge(150, "London", "Node4"), London, Node3);
        graph.addEdge(new Edge(50, "Node3", "Birmingham"), Node3, Birmingham);
        graph.addEdge(new Edge(115, "Node3", "Cambridge"), Node3, Cambridge);
        graph.addEdge(new Edge(130, "Node3", "Sheffield"), Node3, Sheffield);
        graph.addEdge(new Edge(60, "Sheffield", "Node4"), Sheffield, Node4);
        graph.addEdge(new Edge(55, "Node4", "Grimsby"), Node4, Grimsby);
        graph.addEdge(new Edge(270, "Node4", "Cambridge"), Node4, Cambridge);
        graph.addEdge(new Edge(115, "Cambridge", "Felixstowe"), Cambridge, Felixstowe);
        graph.addEdge(new Edge(110, "Sheffield", "Manchester"), Sheffield, Manchester);
        graph.addEdge(new Edge(60, "Manchester", "Liverpool"), Manchester, Liverpool);
        graph.addEdge(new Edge(165, "Birmingham", "Liverpool"), Birmingham, Liverpool);
        graph.addEdge(new Edge(160, "Birmingham", "Node2"), Birmingham, Node2);
        graph.addEdge(new Edge(75, "Node2", "Cardiff"), Node2, Cardiff);
        graph.addEdge(new Edge(70, "Cardiff", "Swansea"), Cardiff, Swansea);
        graph.addEdge(new Edge(108, "Node2", "Node1"), Node2, Node1);
        graph.addEdge(new Edge(70, "Node1", "Plymouth"), Node1, Plymouth);
        graph.addEdge(new Edge(330, "Node1", "Southampton"), Node1, Southampton);
        graph.addEdge(new Edge(220, "Southampton", "Dover"), Southampton, Dover);
        // Algortimo de Dijkstra
        Transformer<Edge, Double> wtTransformer = new Transformer<Edge, Double>() {
            public Double transform(Edge link) {
                return link.weight;
            }
        };

        alg = new DijkstraShortestPath(graph, wtTransformer);

        Collection<Vertex<Point>> coleccion = graph.getNeighbors(London);

        coleccion = graph.getVertices();

        String msm = "";

        for (Iterator iterator = coleccion.iterator(); iterator.hasNext(); ) {
            Vertex<Point> vertex = (Vertex<Point>) iterator.next();
            System.out.println(vertex.getInfo().toString());
            msm += vertex.getInfo().toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, msm);

        Collection<Edge> edgeColelction = graph.getInEdges(London);
        System.err.println("-------------------------");

        edgeColelction = graph.getEdges();

        msm = "";

        for (Iterator iterator = edgeColelction.iterator(); iterator.hasNext(); ) {
            Edge edge = (Edge) iterator.next();
            msm += edge.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, msm);
        System.out.println(msm);

        System.err.println("-------------------------");


        do {

            System.out.println("Seleccion de ciudad de origen");

            seleccion = JOptionPane.showOptionDialog(null, "Seleccione una Ciudad de salida", "Seleccion Origen",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"London", "Dover", "Felixstowe", "Cambridge", "Southampton", "Plymouth", "Cardiff", "Swansea", "Birmingham", "Liverpool", "Manchester", "Sheffield", "Grimsby", "salir"}, "opcion 1");
            switch (seleccion) {

                case 0:

                    System.out.println("selecciono " + (seleccion) + " London");

                    subMenu(London);

                    break;

                case 1:

                    System.out.println("selecciono " + (seleccion) + " Dover");

                    subMenu(Dover);

                    break;

                case 2:

                    System.out.println("selecciono " + (seleccion) + " Felixstowe");

                    subMenu(Felixstowe);

                    break;

                case 3:

                    System.out.println("selecciono " + (seleccion) + " Cambridge");

                    subMenu(Cambridge);

                    break;
                case 4:

                    System.out.println("selecciono " + (seleccion) + " Southampton");

                    subMenu(Southampton);

                    break;

                case 5:

                    System.out.println("selecciono " + (seleccion) + " Plymouth");

                    subMenu(Plymouth);

                    break;

                case 6:

                    System.out.println("selecciono " + (seleccion) + " Cardiff");

                    subMenu(Cardiff);

                    break;

                case 7:

                    System.out.println("selecciono " + (seleccion) + " Swansea");

                    subMenu(Swansea);

                    break;

                case 8:

                    System.out.println("selecciono " + (seleccion) + " Birmingham");

                    subMenu(Birmingham);

                    break;

                case 9:

                    System.out.println("selecciono " + (seleccion) + " Liverpool");

                    subMenu(Liverpool);

                    break;

                case 10:

                    System.out.println("selecciono " + (seleccion) + " Manchester");

                    subMenu(Manchester);

                    break;
                case 11:

                    System.out.println("selecciono " + (seleccion) + " Sheffield");

                    subMenu(Sheffield);

                    break;

                case 12:

                    System.out.println("selecciono " + (seleccion) + " Grimsby");

                    subMenu(Grimsby);

                    break;

                case 13:

                    System.out.println("selecciono " + (seleccion) + " Salida");

                    int op = JOptionPane.showConfirmDialog(null, "�Esta seguro de salir?", "Alerta!", JOptionPane.YES_NO_OPTION);


                    if (op == 1) {
                        seleccion = 14;
                    }

                    break;
            }
        }

        while (seleccion != 13);


        System.err.println("-------------------------");


    }

    public void subMenu(Vertex<Point> origin) {
        do {

            System.out.println("Seleccion de ciudad de Destino");

            seleccion2 = JOptionPane.showOptionDialog(null, "Seleccione una Ciudad de Destino", "Seleccion Destino",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"London", "Dover", "Felixstowe", "Cambridge", "Southampton", "Plymouth", "Cardiff", "Swansea", "Birmingham", "Liverpool", "Manchester", "Sheffield", "Grimsby", "Volver"}, "opcion 1");
            switch (seleccion2) {

                case 0:

                    System.out.println("selecciono " + (seleccion2) + " London");

                    way(origin, London);

                    break;

                case 1:

                    System.out.println("selecciono " + (seleccion2) + " Dover");

                    way(origin, Dover);

                    break;

                case 2:

                    System.out.println("selecciono " + (seleccion2) + " Felixstowe");

                    way(origin, Felixstowe);

                    break;

                case 3:

                    System.out.println("selecciono " + (seleccion2) + " Cambridge");

                    way(origin, Cambridge);

                    break;
                case 4:

                    System.out.println("selecciono " + (seleccion2) + " Southampton");

                    way(origin, Southampton);

                    break;

                case 5:

                    System.out.println("selecciono " + (seleccion2) + " Plymouth");

                    way(origin, Plymouth);

                    break;

                case 6:

                    System.out.println("selecciono " + (seleccion2) + " Cardiff");

                    way(origin, Cardiff);

                    break;

                case 7:

                    System.out.println("selecciono " + (seleccion2) + " Swansea");

                    way(origin, Swansea);

                    break;

                case 8:

                    System.out.println("selecciono " + (seleccion2) + " Birmingham");

                    way(origin, Birmingham);

                    break;

                case 9:

                    System.out.println("selecciono " + (seleccion2) + " Liverpool");

                    way(origin, Liverpool);

                    break;

                case 10:

                    System.out.println("selecciono " + (seleccion2) + " Manchester");

                    way(origin, Manchester);

                    break;
                case 11:

                    System.out.println("selecciono " + (seleccion2) + " Sheffield");

                    way(origin, Sheffield);

                    break;

                case 12:

                    System.out.println("selecciono " + (seleccion2) + " Grimsby");

                    way(origin, Grimsby);

                    break;

                case 13:

                    System.out.println("selecciono " + (seleccion2) + " Volver");

                    break;
            }
        }

        while (seleccion2 != 13);
    }

    public void way(Vertex<Point> origin, Vertex<Point> destine) {

        System.err.println("-------------------------");

        //String msm = "";

        System.out.println("Para viajar de " + origin.getInfo().getName() + " hasta " + destine.getInfo().getName() + " Debe Seguir el siguiente recorrido");

        System.out.println(alg.getPath(origin, destine));

        System.out.println("La distancia es de " + alg.getDistance(origin, destine));

        JOptionPane.showMessageDialog(null, "Para viajar de " + origin.getInfo().getName() + " hasta " + destine.getInfo().getName() + " Debe Seguir el siguiente recorrido \n"
                + alg.getPath(origin, destine) + "\n" + "La distancia es de " + alg.getDistance(origin, destine));

        System.err.println("-------------------------");
    }


    public Graph getGraph() {
        return graph;
    }

}
