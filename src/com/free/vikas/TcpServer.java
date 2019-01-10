package com.free.vikas;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		String message;
		String response;
		
		try {
			ServerSocket serverSocket = new ServerSocket(8081);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Connected to server");
				
				// Store data from client
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// out to client
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				message = br.readLine();
				System.out.println("Received message: " + message);
				
				// Converting the message to uppercase for response
				response = message.toUpperCase() + "\n";
				
				// Send response
				out.writeBytes(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
