package gameClient.label;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import gameClient.Jframe;
import gameClient.Jframe;

import javax.swing.*;
import java.awt.event.*;
// It's a class of button RemoveNode
public class RemoveNodeLabel extends JFrame implements ActionListener{
    JTextField tf; JLabel l,l1; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public RemoveNodeLabel(DirectedWeightedGraphAlgorithms algo){
        this.algo=algo;
        this.graph=this.algo.getGraph();
        tf=new JTextField();
        tf.setBounds(125,125, 150,20);
        l=new JLabel();
        l.setBounds(25,50, 300,20);
        l1=new JLabel();
        l1.setBounds(25,125, 300,20);
        b=new JButton("Remove");
        b.setBounds(150,200,100,30);
        b.addActionListener(this);
        l.setText("To Remove Node please insert 1 value:");
        l1.setText("Insert Node Src:");
        add(b);add(tf);add(l);add(l1);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String host=tf.getText();
            this.graph.removeNode(Integer.parseInt(host));
            l.setText("Node Number: "+host+" Deleted");
            Jframe k=new Jframe(this.algo);
            k.setVisible(true);
        }catch(Exception ex){System.out.println(ex);}
    }
}