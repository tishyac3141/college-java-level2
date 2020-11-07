package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class demoServer {
    private ServerSocket server;

    public demoServer() {
        try {
            // Open server socket using port 9090 and URL Localhost
            this.server = new ServerSocket(9090, 0, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("The server is alive");
        // Keep the server running
        Socket clientSocket = null;
        while (true) {
            try {
                String inputLine;
                // Open a socket to handle clients requests
                clientSocket = server.accept();
                // Buffer client requests
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // PrintWriter sends server response to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Server - I got the message");
                // Print to the console the Clients message
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Server print client message (" + inputLine + ")");
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
        demoServer myServer = new demoServer();
        myServer.run();
    }

}
