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
    private Vertex<Point> Medellin;
    private Vertex<Point> Bogota;
    private Vertex<Point> Cali;
    private Vertex<Point> Cartagena;
    private Vertex<Point> Barranquilla;
    private Vertex<Point> Bucaramanga;
    private Vertex<Point> Cucuta;
    private Vertex<Point> Pereira;
    private Vertex<Point> SantaMarta;
    private Vertex<Point> Villavicencio;
    private Vertex<Point> Manizales;
    private Vertex<Point> Pasto;
    private Vertex<Point> Buenaventura;

    private int seleccion, seleccion2;

    public Management() {
        initialize();
    }

    public void initialize() {
        graph = new SparseMultigraph<Vertex<Point>, Edge>();

        // damos info a los vertices
        Medellin = new Vertex<Point>(new Point("Medellin"));
        Bogota = new Vertex<Point>(new Point("Bogota"));
        Cali = new Vertex<Point>(new Point("Cali"));
        Cartagena = new Vertex<Point>(new Point("Cartagena"));
        Barranquilla = new Vertex<Point>(new Point("Barranquilla"));
        Bucaramanga = new Vertex<Point>(new Point("Bucaramanga"));
        Cucuta = new Vertex<Point>(new Point("Cucuta"));
        Pereira = new Vertex<Point>(new Point("Pereira"));
        SantaMarta = new Vertex<Point>(new Point("Santa Marta"));
        Villavicencio = new Vertex<Point>(new Point("Villavicencio"));
        Manizales = new Vertex<Point>(new Point("Manizales"));
        Pasto = new Vertex<Point>(new Point("Pasto"));
        Buenaventura = new Vertex<Point>(new Point("Buenaventura"));

        graph.addEdge(new Edge(509, "Bogota", "Medellin"), Bogota, Medellin);
        graph.addEdge(new Edge(466, "Bogota", "Cali"), Bogota, Cali);
        graph.addEdge(new Edge(124, "Bogota", "Villavicencio"), Bogota, Villavicencio);
        graph.addEdge(new Edge(871, "Medellin", "Barranquilla"), Medellin, Barranquilla);
        graph.addEdge(new Edge(640, "Medellin", "Cartagena"), Medellin, Cartagena);
        graph.addEdge(new Edge(212, "Medellin", "Pereira"), Medellin, Pereira);
        graph.addEdge(new Edge(199, "Bucaramanga", "Cucuta"), Bucaramanga, Cucuta);
        graph.addEdge(new Edge(884, "Cali", "Pasto"), Cali, Pasto);
        graph.addEdge(new Edge(214, "Pereira", "Cali"), Pereira, Cali);
        graph.addEdge(new Edge(52, "Pereira", "Manizales"), Pereira, Manizales);
        graph.addEdge(new Edge(162, "Cali", "Buenaventura"), Cali, Buenaventura);
        graph.addEdge(new Edge(122, "Cartagena", "Barranquilla"), Cartagena, Barranquilla);
        graph.addEdge(new Edge(505, "Buenaventura", "Bogota"), Buenaventura, Bogota);
        graph.addEdge(new Edge(398, "Bucaramanga", "Bogota"), Bucaramanga, Bogota);
        graph.addEdge(new Edge(266, "Santa Marta", "Cartagena"), SantaMarta, Cartagena);
        // Algortimo de Dijkstra
        Transformer<Edge, Double> wtTransformer = new Transformer<Edge, Double>() {
            public Double transform(Edge link) {
                return link.weight;
            }
        };

        alg = new DijkstraShortestPath(graph, wtTransformer);

        Collection<Vertex<Point>> coleccion = graph.getNeighbors(Bogota);

        coleccion = graph.getVertices();

        String msm = "";

        for (Iterator iterator = coleccion.iterator(); iterator.hasNext(); ) {
            Vertex<Point> vertex = (Vertex<Point>) iterator.next();
            System.out.println(vertex.getInfo().toString());
            msm += vertex.getInfo().toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, msm);

        Collection<Edge> edgeColelction = graph.getInEdges(Bogota);
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
                    new Object[]{"Bogota", "Medellin", "Cali", "Cartagena", "Barranquilla", "Bucaramanga", "Cucuta", "Pereira", "Santa Marta", "Villavicencio", "Manizales", "Pasto", "Buenaventura", "salir"}, "opcion 1");
            switch (seleccion) {

                case 0:
                    System.out.println("selecciono " + (seleccion) + " Bogota");
                    subMenu(Bogota);
                    break;
                case 1:
                    System.out.println("selecciono " + (seleccion) + " Medellin");
                    subMenu(Medellin);
                    break;
                case 2:
                    System.out.println("selecciono " + (seleccion) + " Cali");
                    subMenu(Cali);
                    break;
                case 3:
                    System.out.println("selecciono " + (seleccion) + " Cartagena");
                    subMenu(Cartagena);
                    break;
                case 4:
                    System.out.println("selecciono " + (seleccion) + " Barranquilla");
                    subMenu(Barranquilla);
                    break;
                case 5:
                    System.out.println("selecciono " + (seleccion) + " Bucaramanga");
                    subMenu(Bucaramanga);
                    break;
                case 6:
                    System.out.println("selecciono " + (seleccion) + " Cucuta");
                    subMenu(Cucuta);
                    break;
                case 7:
                    System.out.println("selecciono " + (seleccion) + " Pereira");
                    subMenu(Pereira);
                    break;
                case 8:
                    System.out.println("selecciono " + (seleccion) + " Santa Marta");
                    subMenu(SantaMarta);
                    break;
                case 9:
                    System.out.println("selecciono " + (seleccion) + " Villavicencio");
                    subMenu(Villavicencio);
                    break;

                case 10:
                    System.out.println("selecciono " + (seleccion) + " Manizales");
                    subMenu(Manizales);
                    break;
                case 11:
                    System.out.println("selecciono " + (seleccion) + " Pasto");
                    subMenu(Pasto);
                    break;
                case 12:
                    System.out.println("selecciono " + (seleccion) + " Buenaventura");
                    subMenu(Buenaventura);
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
                    new Object[]{"Bogota", "Medellin", "Cali", "Cartagena", "Barranquilla", "Bucaramanga", "Cucuta", "Pereira", "Santa Marta", "Villavicencio", "Manizales", "Pasto", "Buenaventura", "Volver"}, "opcion 1");
            switch (seleccion2) {

                case 0:
                    System.out.println("selecciono " + (seleccion2) + " Bogota");
                    way(origin, Bogota);
                    break;
                case 1:
                    System.out.println("selecciono " + (seleccion2) + " Medellin");
                    way(origin, Medellin);
                    break;
                case 2:
                    System.out.println("selecciono " + (seleccion2) + " Cali");
                    way(origin, Cali);
                    break;
                case 3:
                    System.out.println("selecciono " + (seleccion2) + " Cartagena");
                    way(origin, Cartagena);
                    break;
                case 4:
                    System.out.println("selecciono " + (seleccion2) + " Barranquilla");
                    way(origin, Barranquilla);
                    break;
                case 5:
                    System.out.println("selecciono " + (seleccion2) + " Bucaramanga");
                    way(origin, Bucaramanga);
                    break;
                case 6:
                    System.out.println("selecciono " + (seleccion2) + " Cucuta");
                    way(origin, Cucuta);
                    break;
                case 7:
                    System.out.println("selecciono " + (seleccion2) + " Pereira");
                    way(origin, Pereira);
                    break;
                case 8:
                    System.out.println("selecciono " + (seleccion2) + " Santa Marta");
                    way(origin, SantaMarta);
                    break;
                case 9:
                    System.out.println("selecciono " + (seleccion2) + " Villavicencio");
                    way(origin, Villavicencio);
                    break;
                case 10:
                    System.out.println("selecciono " + (seleccion2) + " Manizales");
                    way(origin, Manizales);
                    break;
                case 11:
                    System.out.println("selecciono " + (seleccion2) + " Pasto");
                    way(origin, Pasto);
                    break;
                case 12:
                    System.out.println("selecciono " + (seleccion2) + " Buenaventura");
                    way(origin, Buenaventura);
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
