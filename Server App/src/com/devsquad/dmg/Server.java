package com.devsquad.dmg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(9000);
			
			System.out.println("Server started on port 9000...");
			System.out.println("Waiting for clients...");
			
			while (true) {
				Socket client = server.accept();
				InetAddress address = client.getInetAddress();
				System.out.println("Client " + address.getHostName() + " connected.");
				
				new ClientHandleThread(client);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
