import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        try {
            Socket clientSocket = new Socket("localhost", 5000);
            PrintWriter scrittoreDelClient = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader lettoreDelClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.print("\nInserire messaggio da inviare al Server: ");
            String dallUtente = tastiera.nextLine();
            scrittoreDelClient.print(dallUtente);
            scrittoreDelClient.flush();
            System.out.print("\nRisposta del Server: " + lettoreDelClient.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}