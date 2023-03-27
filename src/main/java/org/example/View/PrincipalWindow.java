package org.example.View;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import org.example.Model.Management;

import javax.swing.*;
import java.awt.*;

public class PrincipalWindow extends JFrame {
    private Management management;
    private Layout<Integer, String> layout;
    private BasicVisualizationServer<Integer, String> view;

    public PrincipalWindow() {
        initialice();
        assign();
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initialice() {

        management = new Management();

        layout = new CircleLayout(management.getGraph());//las margenes seran circulares, esta margenes contendran lo que retorne management.getGraph(), es decir el grafo
        layout.setSize(new Dimension(1280,720));

        view = new BasicVisualizationServer<Integer, String>(layout);//dimensiones
        view.setPreferredSize(new Dimension(1280,720));

        view.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());//configuracion renderizado Vertices
        view.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);//los labels se ubican centrados del vertice

        view.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());//configuracion renderizado Aristas "rutas"
        view.getRenderContext().getEdgeLabelRenderer().setRotateEdgeLabels(false);//los labels se ubican centrados del Aristas "rutas"
    }

    private void assign() {
        add(view);
    }
}
