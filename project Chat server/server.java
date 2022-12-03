/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ChatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // this is my server
        //Define the  socket
        ServerSocket ss =new ServerSocket(2000);
        //accept connection from client
        Socket sk = ss.accept();
        BufferedReader cin = new BufferedReader (new InputStreamReader(sk.getInputStream()));
        PrintStream cout = new  PrintStream (sk.getOutputStream());
         BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        // which data will be store
        String s;
        Scanner sc = new Scanner(System.in);
        while(true){
            //read from the socket
            s = cin.readLine();
            //print data from the client
            System.out.println("Client "+s+"\n");
             System.out.println("Server : ");
             s=sc.nextLine();
             if(s.equalsIgnoreCase("BYE")){
                 System.out.println("Connection is ended by server");
                 break;  //exit
             }
               cout.println(s);
             }
             ss.close();
             sk.close();
             cin.close();
             cout.close();
             stin.close();
        }
    }
    

