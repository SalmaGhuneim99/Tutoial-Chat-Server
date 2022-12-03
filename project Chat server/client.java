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
import java.net.Socket;

/**
 *
 * @author HP
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //create socket with IP address and port number for transfer the socket
        Socket sk = new Socket("127.0.0.1",2000);
        // input stream on socket
        BufferedReader sin = new BufferedReader (new InputStreamReader(sk.getInputStream()));
        PrintStream sout = new  PrintStream (sk.getOutputStream());
        //this buffer to get input from the user
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        // which data will be store
        String s; 
        while(true){
            System.out.print("Client :");
             s = stin.readLine();
             sout.println(s);
             // if client say bye
             if(s.equalsIgnoreCase("BYE")){
                 System.out.println("Connection is ended by client");
                 break;  //exit
             }
             
            //reading the data
            s=sin.readLine();
            System.out.println("Server " +s+"\n");
             
        }
         sk.close();
             sin.close();
             sout.close();
             stin.close();
    }
}
