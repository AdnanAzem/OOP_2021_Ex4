package ex4_java_client; /**
 * @author AchiyaZigi
 * A trivial example for starting the server and running all needed commands
 */
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgo;
import api.DirectedWeightedGraphAlgorithms;
import api.DirectedWeightedGraphAlgorithmsAlgo;
import gameClient.GFrame;
import gameClient.Jframe;

import java.io.IOException;
import java.util.Scanner;

public class StudentCode {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1",6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DirectedWeightedGraphAlgorithms g = new DirectedWeightedGraphAlgorithmsAlgo();
        String graphStr = client.getGraph();
        g.load(graphStr);
        System.out.println(graphStr);
        client.addAgent("{\"id\":0}");
        String agentsStr = client.getAgents();
        System.out.println(agentsStr);
        String pokemonsStr = client.getPokemons();
        System.out.println(pokemonsStr);
        String isRunningStr = client.isRunning();
        System.out.println(isRunningStr);

        Jframe jf = new Jframe(g);
        jf.setVisible(true);
        client.start();

        while (client.isRunning().equals("true")) {
            client.move();
            System.out.println(client.getAgents());
            System.out.println(client.timeToEnd());

            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter the next dest: ");
            int next = keyboard.nextInt();
            client.chooseNextEdge("{\"agent_id\":0, \"next_node_id\": " + next + "}");
            jf = new Jframe(g);
            jf.setVisible(true);

        }
    }

}