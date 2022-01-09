package gameClient.label;

import gameClient.Jframe;
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import gameClient.Jframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// It's a class of button ConnectNode
public class ConnectNodeLabel extends JFrame implements ActionListener {
    JTextField tf,tf1,tf2; JLabel l,l1,l2,jl; JButton b;
    DirectedWeightedGraph graph;
    DirectedWeightedGraphAlgorithms algo;
    public ConnectNodeLabel(DirectedWeightedGraphAlgorithms algo){
        setTitle("Connect Nodes");
        this.algo=algo;
        this.graph=this.algo.getGraph();
        tf=new JTextField();
        tf.setBounds(125,100, 150,20);
        l=new JLabel();
        l1=new JLabel();
        l2=new JLabel();
        jl=new JLabel();
        tf1=new JTextField();
        tf2=new JTextField();
        l.setBounds(25,100, 100,20);
        b=new JButton("Connect");
        b.setBounds(150,250,100,30);
        b.addActionListener(this);
        jl.setText("To connect 2 Nodes please insert 3 values:");
        l.setText("Insert Node Src:");
        l1.setText("Insert Node Dest:");
        l2.setText("Insert Wieght:");
        l1.setBounds(25,150, 100,20);
        l2.setBounds(25,200, 100,20);
        jl.setBounds(25,50, 350,20);
        tf1.setBounds(125,150, 150,20);
        tf2.setBounds(125,200, 150,20);
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
            this.graph.connect(Integer.parseInt(host),Integer.parseInt(host1),Double.parseDouble(host2));
            l.setText("Edge Number: "+host+host1+host2+" Connect");
            this.algo.init(this.graph);
            Jframe k=new Jframe(this.algo);
            k.setVisible(true);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}