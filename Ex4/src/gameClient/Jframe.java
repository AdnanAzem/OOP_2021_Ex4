package gameClient;

import ex4_java_client.Client;
import gameClient.label.*;
import api.DirectedWeightedGraphAlgorithms;
//import GUI.label.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *This is a class that draws the graph.
 * It has a lot of buttons that each button has a class.
 * What implements the ActionListener interface
 */
public class Jframe extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu,editMenu;
    JMenuItem loadItem,saveItem,exitItem,RemoveNodeItem,RemoveEdgeItem,ConnectNodeItem,AddNodeItem,ShortestPathDistItem,
            ExplanationverticesItem,ShortestPathItem;
    Graphs g;
    private DirectedWeightedGraphAlgorithms Algo;
    private Client c;

    public Jframe(DirectedWeightedGraphAlgorithms algo,Client c){
        this.Algo=algo;
        this.c=c;
        initFrame();
        addMenu();
        initPanel();
    }

    public Jframe(DirectedWeightedGraphAlgorithms graph){
        this.Algo=graph;
        initFrame();
        addMenu();
        initPanel();
    }

    private void initPanel() {
        this.g=new Graphs(this.Algo);
        this.add(g);
    }

    private void addMenu() {
        //A button that contains them all
        menuBar = new JMenuBar();

        //Add a name to item label
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");

        //Add a name to item label
        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");
        exitItem = new JMenuItem("Exit");

        AddNodeItem=new JMenuItem("Add Node");
        ConnectNodeItem=new JMenuItem("Connect Nodes");
        RemoveNodeItem = new JMenuItem("Remove Node");
        RemoveEdgeItem = new JMenuItem("Remove Edge");
        ShortestPathItem=new JMenuItem("Shortest Path List");
        ShortestPathDistItem=new JMenuItem("Shortest path sum");

        ExplanationverticesItem=new JMenuItem("Vertex information");

        //Add secondary buttons to file
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);

        //Add secondary buttons to edit
        editMenu.add(AddNodeItem);
        editMenu.add(ConnectNodeItem);
        editMenu.add(RemoveNodeItem);
        editMenu.add( RemoveEdgeItem);
        editMenu.add(ShortestPathDistItem);
        editMenu.add(ShortestPathItem);


        //Add main buttons
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //Listen to the buttons
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        RemoveNodeItem.addActionListener(this);
        RemoveEdgeItem.addActionListener(this);
        ConnectNodeItem.addActionListener(this);
        AddNodeItem.addActionListener(this);

        ShortestPathDistItem.addActionListener(this);
        ExplanationverticesItem.addActionListener(this);
        ShortestPathItem.addActionListener(this);

        //Insert the button
        this.setJMenuBar(menuBar);
    }

    //Large screen
    private void initFrame() {
        this.setSize(1000,800);
        ImageIcon m = new ImageIcon("./DG.png");
        this.setIconImage(m.getImage());
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     *This method implements the ActionListener interface
     * Which listens to every button
     * @param e listen
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem) {
            JFileChooser fc=new JFileChooser();
            int i=fc.showOpenDialog(this);

            //load
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                try{
                    this.Algo.load(filepath);
                    Jframe k=new Jframe(this.Algo);
                    k.setVisible(true);
                }catch (Exception ex) {ex.printStackTrace();  }
            }
        }

        // sava
        if(e.getSource()==saveItem) {
            JFileChooser fc=new JFileChooser();
            int i=fc.showSaveDialog(this);
            if(i!=JFileChooser.SAVE_DIALOG){
                File f=fc.getSelectedFile();
                String filepath=f.getPath()+".json";
                try{
                    this.Algo.save(filepath);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        // exit
        if(e.getSource()==exitItem) {
            System.exit(0);
        }


        //Remove Node
        if(e.getSource()== RemoveNodeItem){
            new RemoveNodeLabel(this.Algo);
        }

        //Remove Edge
        if(e.getSource() == RemoveEdgeItem){
            new RemoveEdgeLabel(this.Algo);

        }

        //Connect Node
        if(e.getSource()==ConnectNodeItem){
            new ConnectNodeLabel(this.Algo);
        }

        //Add Node
        if(e.getSource()== AddNodeItem){
            new AddNodeLabel(this.Algo);
        }

        //Shortest Path Dist
        if(e.getSource()==ShortestPathDistItem){
            new ShortestPathDistLabel(this.Algo);
        }

        //Shortest Path
        if(e.getSource()==ShortestPathItem){
            new ShortestPathLabel(this.Algo);
        }
    }
}