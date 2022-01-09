package gameClient.label;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import gameClient.Jframe;
import gameClient.Jframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// It's a class of button RemoveEdge
public class RemoveEdgeLabel extends JFrame implements ActionListener {
    JTextField tf,tf1; JLabel l,l1,jl; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public RemoveEdgeLabel(DirectedWeightedGraphAlgorithms algo){
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
        jl=new JLabel();
        jl.setBounds(25,50, 300,20);
        b=new JButton("Remove");
        b.setBounds(150,200,100,30);
        b.addActionListener(this);

        l.setText("Insert Node Src:");
        l1.setText("Insert Node Dest:");
        jl.setText("To Remove Edge please insert 2 values:");
        add(b);add(tf);add(l);add(l1);add(jl);add(tf1);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String host=tf.getText();
            String host1=tf1.getText();
            this.graph.removeEdge(Integer.parseInt(host),Integer.parseInt(host1));
            l.setText("Edge Number: "+host+" Deleted");
            Jframe k=new Jframe(this.algo);
            k.setVisible(true);
        }catch(Exception ex){System.out.println(ex);}
    }
}