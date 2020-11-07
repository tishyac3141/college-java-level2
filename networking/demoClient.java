package networking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class demoClient {
    
    DataOutputStream dOutStream = null;
	     DataInputStream dInputStream = null;

	     public void run() throws IOException {
		        //Open a socket using port 9090 and URL Localhost (The server URL)
		        Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 9090);
		        //OutStream used to send message to server
		        dOutStream = new DataOutputStream(clientSocket.getOutputStream());
		        dOutStream.writeBytes("Client - Sending data to the server\n");
		        //Buffer servers response and print to console
		        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		        String response = input.readLine();
		        System.out.println("Client print server message ("+response+")");
		        clientSocket.close();
	     }

	     public static void main(String[] args) {
		        demoClient client = new demoClient();
		        try {
			           client.run();
		        } catch (IOException e) {
			           e.printStackTrace();
		        }
	     }

}
