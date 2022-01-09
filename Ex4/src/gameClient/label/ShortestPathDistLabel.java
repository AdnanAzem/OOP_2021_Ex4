package gameClient.label;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// It's a class of button ShortestPathDist
public class ShortestPathDistLabel extends JFrame implements ActionListener {
    JTextField tf,tf1; JLabel l,l1,jl,l2; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public ShortestPathDistLabel(DirectedWeightedGraphAlgorithms algo){
        this.algo=algo;
        this.graph=this.algo.getGraph();
        tf=new JTextField();
        tf.setBounds(125,100, 150,20);
        tf1=new JTextField();
        tf1.setBounds(125,150, 150,20);
        l=new JLabel();
        l.setBounds(25,100, 300,20);
        l1=new JLabel();
        l1.setBounds(25,150, 300,20);
        l2=new JLabel();
        l2.setBounds(25,250, 300,20);
        jl=new JLabel();
        jl.setBounds(25,50, 300,20);
        b=new JButton("search");
        b.setBounds(150,200,100,30);
        b.addActionListener(this);
        jl.setText("To find the shortest path between 2 Nodes please insert 2 values:");
        l.setText("Insert Node Src:");
        l1.setText("Insert Node Dest:");
        add(b);add(tf);add(l);add(jl);add(l1);add(tf1);add(l2);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String host=tf.getText();
            String host1=tf1.getText();
            double sum=this.algo.shortestPathDist(Integer.parseInt(host),Integer.parseInt(host1));
            l2.setText("The shortest path sum from:"+Integer.parseInt(host)+" to:" + Integer.parseInt(host1)+" is:"+sum);
        }catch(Exception ex){System.out.println(ex);}
    }
}