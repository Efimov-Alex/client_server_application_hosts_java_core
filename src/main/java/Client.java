import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8090;
        try (

                Socket clientSocket = new Socket(host, port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String message = in.readLine();

            System.out.println(message);

            String name = reader.readLine();

            out.println(name);

            String question = in.readLine();

            System.out.println(question);

            String answer = reader.readLine();

            out.println(answer);

            message = in.readLine();

            System.out.println(message);


        }
    }
}