package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ServerSocket mioServerSocket = new ServerSocket(3000);
        Socket mioSocket = mioServerSocket.accept();
        System.out.println("Qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(),true);

        String stringaRicevuta;
        do
        {
            stringaRicevuta = in.readLine();
            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            if (!stringaMaiuscola.equals("!")) {
                out.println(stringaMaiuscola);
            }
            
        }while(!stringaRicevuta.equals("!"));

        
        mioServerSocket.close();
        System.out.println("Connessione interrotta");
    }
}