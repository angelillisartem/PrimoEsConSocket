import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            //Creazione del server socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.print("\nServer Attivo!");
            //Creazione del client
            Socket clientDelServer = serverSocket.accept();
            System.out.print("\nClient Connesso!");
            //Creazione di un metodo lettura scrittura
            PrintWriter scrittoreDelServer = new PrintWriter(clientDelServer.getOutputStream());
            BufferedReader lettoreDelServer = new BufferedReader(new InputStreamReader(clientDelServer.getInputStream()));
            //Lettura dal client
            String dalClientDelServer = lettoreDelServer.readLine();
            System.out.print("\nStringa Ricevuta " + dalClientDelServer);
            //Scrittura dal client
            scrittoreDelServer.print(dalClientDelServer.toUpperCase());
            scrittoreDelServer.flush();
            //Chiusura
            clientDelServer.close();
            System.out.print("\nNanna");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}