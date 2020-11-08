package networking.lesson10;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class TripClient {

    DataOutputStream dOutStream = null;
    DataInputStream dInputStream = null;
    private String state;

    public TripClient(){
        state = JOptionPane.showInputDialog("Please type in the state you would like to travel to. Be sure to type in the abbreviated version of your state.");
        System.out.println("after input dialog");
    }

    public void run() throws IOException {
        Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 9090);

        dOutStream = new DataOutputStream(clientSocket.getOutputStream());
        dOutStream.writeBytes(state + "\n");

        System.out.println("sent state to server; state = " + state);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String response = input.readLine();
        System.out.println("response = " + response);
        int cost = Integer.parseInt(response);
        
        System.out.println("cost = " + cost);
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
