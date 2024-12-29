import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Set; // Import for Set
import java.util.concurrent.ConcurrentHashMap; // Import for ConcurrentHashMap

public class ChatServerGUI {
    private JFrame frame;
    private JTextArea logArea;
    private JButton startButton;
    private ServerSocket serverSocket;
    private boolean running = false;
    private final Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet(); // Correct use of ConcurrentHashMap

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatServerGUI::new);
    }

    public ChatServerGUI() {
        frame = new JFrame("Chat Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        startButton = new JButton("Start Server");
        startButton.addActionListener(e -> toggleServer());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void toggleServer() {
        if (running) {
            stopServer();
        } else {
            startServer();
        }
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(22227);
            running = true;
            startButton.setText("Stop Server");
            logArea.append("Server started on port 22227\n");

            new Thread(() -> {
                while (running) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        logArea.append("Client connected: " + clientSocket.getInetAddress() + "\n");
                        ClientHandler handler = new ClientHandler(clientSocket, logArea); // Pass logArea here
                        clientHandlers.add(handler);
                        new Thread(handler).start();
                    } catch (IOException e) {
                        if (running) logArea.append("Error: " + e.getMessage() + "\n");
                    }
                }
            }).start();
        } catch (IOException e) {
            logArea.append("Failed to start server: " + e.getMessage() + "\n");
        }
    }

    private void stopServer() {
        try {
            running = false;
            if (serverSocket != null) {
                serverSocket.close();
            }
            startButton.setText("Start Server");
            logArea.append("Server stopped.\n");
        } catch (IOException e) {
            logArea.append("Error stopping server: " + e.getMessage() + "\n");
        }
    }
}
