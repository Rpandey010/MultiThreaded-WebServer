// package SingleThreadedWebserver;
import java.io.BufferedReader;
// import java.io.BufferedWriter; // Removed as it's not used
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    public void run() throws UnknownHostException, IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Message from server: Sab marr jayenge, sirf Pandey bachega");
        String line = fromSocket.readLine(); 
        System.out.println("Response from the socket is : "+line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    
    public static void main(String[] args) {
        // Client singleThreadedWebServer_Client = new Client();
        try{
            Client client = new Client();
            client.run();
            // singleThreadedWebServer_Client.run();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}