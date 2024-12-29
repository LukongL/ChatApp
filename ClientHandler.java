import java.io.*;
import java.net.*;
import java.util.Set;
import javax.swing.JTextArea;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private JTextArea logArea; // You will need to pass this from the ChatServerGUI

    public ClientHandler(Socket socket, JTextArea logArea) {
        this.socket = socket;
        this.logArea = logArea;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while ((message = in.readLine()) != null) {
                logArea.append("Message from client: " + message + "\n");
                broadcastMessage(message);
            }
        } catch (IOException e) {
            logArea.append("Client disconnected: " + socket.getInetAddress() + "\n");
        }
    }

    private void broadcastMessage(String message) {
        // Implement broadcasting logic if needed, similar to the original ChatServerGUI
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}
