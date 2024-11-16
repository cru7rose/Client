import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9876;

        try (
                Socket socket = new Socket(host, port);
                PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Server connected");
            Scanner scanner = new Scanner(System.in);

            String message;
            while (true) {
                System.out.println("something");
                message = scanner.nextLine();

                write.println(message);

                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Server exited");
                    break;
                }

                String respond = read.readLine();
                System.out.println(respond);
            }
            scanner.close();
        } catch (IOException ex) {
            System.out.println("Io error: " + ex.getMessage());
        }
    }
}