package gameClient.label;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;
import api.NodeDataAlgo;
import gameClient.Jframe;
import gameClient.Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// It's a class of button AddNode
public class AddNodeLabel extends JFrame implements ActionListener {
    JTextField tf,tf1,tf2; JLabel l,jl,l1,l2; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public AddNodeLabel(DirectedWeightedGraphAlgorithms algo){
        setBackground(new Color(248, 0, 0));
        setTitle("Add Node");
        this.algo=algo;
        this.graph=this.algo.getGraph();
        l=new JLabel();
        l1=new JLabel();
        l2=new JLabel();
        jl=new JLabel();
        tf=new JTextField();
        tf1=new JTextField();
        tf2=new JTextField();
        l.setBounds(25,100, 350,20);
        l1.setBounds(25,150, 100,20);
        l2.setBounds(25,200, 100,20);
        jl.setBounds(25,50, 350,20);
        tf.setBounds(125,100, 150,20);
        tf1.setBounds(125,150, 150,20);
        tf2.setBounds(125,200, 150,20);
        b=new JButton("Add");
        b.setBounds(150,250,100,30);
        b.addActionListener(this);
        l.setText("Insert Src:");
        l1.setText("Insert x:");
        l2.setText("Insert y:");
        jl.setText("To add Node please insert 3 Values:");
        b.setBackground(new Color(115, 115, 115));
        add(b);add(tf);add(l);add(jl);add(tf1);add(tf2);add(l1);add(l2);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String host=tf.getText();
            String host1=tf1.getText();
            String host2=tf2.getText();
            NodeData node = new NodeDataAlgo(Integer.parseInt(host),Double.parseDouble(host1),Double.parseDouble(host2));
            this.graph.addNode(node);
            l.setText("Node Number: "+host+host1+host2+" Add");
            Jframe k=new Jframe(this.algo);
            k.setVisible(true);
        }catch(Exception ex){System.out.println(ex);}
    }
}