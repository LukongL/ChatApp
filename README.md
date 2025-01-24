# ChatApp
A simple Java chat application with GUI for client-server communication.

## Features
- Server GUI to handle client connections and display logs.
- Client GUI for sending and receiving messages in real-time.
- Supports multiple clients.

## How to Run
1. Download the `ChatServerGUI.jar` and `ChatClientGUI.jar` files from this repository.
2. Run the server:
   ```bash
   java -jar ChatServerGUI.jar

## Example Usage - Communication in the Same Office Space

Network Setup

  *All devices (server and clients) should connected to the same local network (LAN) and java installed.

  The server should run on a local machine, and clients can connect using the server's local IP address and port.

Steps to Set It Up

  Start the server application (ChatServerGUI.jar) on one machine.

  Obtain the local IP address of the server machine (e.g., 192.168.x.x).

  Configure the client application (ChatClientGUI.jar) on other machines to connect to this IP address and port.

  Launch the client applications, and users in the same office space can chat.
