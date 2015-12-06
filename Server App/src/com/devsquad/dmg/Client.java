package com.devsquad.dmg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

final class Client {

	public static void main(String[] args) {

		try {
			Socket client = new Socket("192.168.1.3", 9000);

			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream())), true);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			
			out.write("My request...");
			
			String response = in.readLine();
			
			System.out.println("Server response " + response + ".");

			in.close();
			out.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
