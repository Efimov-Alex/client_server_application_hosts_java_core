import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8090;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Write your name");

                out.println("Write your name");

                String name = in.readLine();
                System.out.println(name);

                System.out.println("Are you child? (yes/no)");

                out.println("Are you child? (yes/no)");

                String answer = in.readLine();
                System.out.println(answer);

                if (answer.equals("yes")) {
                    out.println("Welcome to the kids area, " + name + " Let's play!");
                } else if (answer.equals("no")) {
                    out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                } else {
                    out.println("Welcome to the area, " + name);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
