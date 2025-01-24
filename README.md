# ChatApp
A real-time chat application built with Java, featuring WebSocket communication for instant messaging. Designed for desktop users with a clean Swing-based UI. It facilitates seamless text-based interaction between users, making it an ideal tool for small-scale environments like office spaces or local networks.

Real-Time Messaging:

Users can exchange messages in real time using the application.
Messages sent by one user are instantly delivered to all other connected users via the server.

Client-Server Architecture:

The server manages all client connections and ensures smooth message broadcasting or routing.
The clients connect to the server and send/receive messages through an intuitive GUI.

Multithreading for Concurrent Users:

The server supports multiple simultaneous connections, allowing a group of users to communicate effectively.

Graphical User Interface:

Both the client and server components feature user-friendly GUIs, making the application accessible for non-technical users.


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
