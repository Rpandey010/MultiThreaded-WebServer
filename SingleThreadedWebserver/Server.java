// package SingleThreadedWebserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
// import java.net.UnknownHostException;

public class Server {

    public void run() throws IOException {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);
        while (true) {
            try {
                System.out.println("Server is listening on port: " +port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connected to " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Message from server: Sab marr jayenge, sirf Pandey bachega");
                toClient.close();
                fromClient.close();
                // socket.close();
                acceptedConnection.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

