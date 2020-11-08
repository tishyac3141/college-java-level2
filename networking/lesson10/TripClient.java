package networking.lesson10;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 * @author Tishya Chhabra
 * Date: 11/7/2020
 * 
 * The client-side for this program! It asks the user for what state they woudl like information on, and then 
 * takes the cost that is passed from the server and shows that to the user.
 * Be sure to run this class after running TripServer first.
 */

public class TripClient {

    DataOutputStream dOutStream = null;
    DataInputStream dInputStream = null;
    private String state;

    public TripClient(){
        state = JOptionPane.showInputDialog("Please type in the state you would like to travel to. Be sure to type in the abbreviated version of your state.");
    }

    public void run() throws IOException {
        Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 9090);

        dOutStream = new DataOutputStream(clientSocket.getOutputStream());
        dOutStream.writeBytes(state + "\n");
        
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String response = input.readLine();
        int cost = Integer.parseInt(response);

        if(cost == 0){
            JOptionPane.showMessageDialog(null, "We're sorry! We don't have the information for that state!");
        } else {
            JOptionPane.showMessageDialog(null, "The round-trip cost for traveling to that state is $" + cost);
        }

        clientSocket.close();
    }

    public static void main(String[] args) {
        TripClient client = new TripClient();
        try {
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
