import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            //Creazione del server socket
            ServerSocket serverSocket1 = new ServerSocket(5000);
            System.out.print("\nServer Attivo!");
            //Creazione del client
            Socket client1 = serverSocket1.accept();
            System.out.print("\nClient Connesso!");
            //Creazione di un metodo lettura scrittura
            PrintWriter scrittore1 = new PrintWriter(client1.getOutputStream());
            BufferedReader lettore1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            //Lettura dal client
            String dalClient1 = lettore1.readLine();
            System.out.print("\nStringa Ricevuta " + dalClient1);
            //Scrittura dal client
            scrittore1.print(dalClient1.toUpperCase());
            scrittore1.flush();
            //Chiusura
            client1.close();
            System.out.print("\nNanna");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}