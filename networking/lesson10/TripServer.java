package networking.lesson10;

import java.io.*;
import java.net.*;

/**
 * @author Tishya Chhabra
 * Date: 11/7/2020
 * 
 * Server-side for this program! It takes the state that is passed by the client, and depending on what it is,
 * provides the cost of a round-trip to that state; if the user typed in a state that is not in the databse, then
 * 0 is passed as the cost.
 * When trying this program, be sure to run thiis first, then TripClient.java
 */

public class TripServer {

    private ServerSocket server = null;

    private String[] states = new String[3];
    private int[] costs = new int[3];

    public TripServer() {
        states = new String[]{"AZ", "NY", "UT"};
        costs = new int[]{500, 600, 300};
        try {
            // Open server socket using port 9090 and URL Localhost
            this.server = new ServerSocket(9090, 0, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCost(String state){
        for(int i = 0; i < states.length; i++){
            if(state.equals(states[i])) return costs[i];
        }
        return 0;
    }

    public void run() {
        System.out.println("the server is alive");
        // Keep the server running
        Socket clientSocket = null;
        while (true) {
            try {
                String state;
                // Open a socket to handle clients requests
                clientSocket = server.accept();
                System.out.println("server: connection established");

                BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(
                    clientSocket.getOutputStream(), true);
                
                int cost;
                state = br.readLine();

                while(state != null){
                    cost = getCost(state);
                    //System.out.println("state = " + state + "  cost = " + cost);

                    pw.println(Integer.toString(cost) + "\n");
                    state = br.readLine();
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TripServer myServer = new TripServer();
        myServer.run();
    }
    
}
