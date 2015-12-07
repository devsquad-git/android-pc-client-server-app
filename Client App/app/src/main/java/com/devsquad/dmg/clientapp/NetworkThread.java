package com.devsquad.dmg.clientapp;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkThread implements Runnable {
    private String address;

    public NetworkThread(String hostAddress) {
        address = hostAddress;
    }

    public void run() {
        try {

             // Connecting to server with port 9000.
            Socket client = new Socket(address, 9000);

            BufferedReader in = new BufferedReader(new InputStreamReader
                    (client.getInputStream()));

            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream())), true);

            // Sending request... We can send string and handle it on server...
            out.println("Our request.");
            out.flush();

            in.close();
            out.close();
            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}