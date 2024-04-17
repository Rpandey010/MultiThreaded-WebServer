import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){

        // return new Consumer<Socket>() {
        //     @Override
        //     public void accept(Socket clienSocket){
        //         try {
        //             PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
        //             toClient.println("Hello from the Server");
        //             toClient.close();
        //             clientSocket.close();
    
        //         } catch (IOException e) {
        //             ex.printStackTrace();
        //         }
        //     }
        // };

        return (clientSocket)->{
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the Server");
                toClient.close();
                clientSocket.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(20000);
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();

                // crate and start a new thread for each client
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}