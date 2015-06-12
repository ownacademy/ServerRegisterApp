/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverregisterapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ivan
 */
public class ServerRegisterApp {

    public static void main(String[] args)  {
        try {

        ServerSocket ss = new ServerSocket(8000);
        for (;;) {
          Socket client = ss.accept();

          BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
          PrintWriter out = new PrintWriter(client.getOutputStream());

          //Request link
          //http://145.24.222.146:8000/id=<id>&serverName=<name>&ip=<IP address>&dockerStatus=<status>
          
          // Start sending our reply, using the HTTP 1.1 protocol
          //out.print("HTTP/1.1 200 \r\n"); // Version & status code
          //out.print("Content-Type: text/plain\r\n"); // The type of data
          //out.print("Connection: close\r\n"); // Will close stream
          //out.print("\r\n"); // End of headers


          String line;
          String getParams = "";
          while ((line = in.readLine()) != null) {
            if (line.length() == 0)
              break;
            //out.print(line + "\r\n");
            
            if(line.contains("GET")){
                getParams = line;
            }
          }//End of while
          
          System.out.println(getParams);
          ServerData data = ServerData.EXTRACT_DATA(getParams);         

          if(Database.INSERT_SERVER_DATA(data)){
              out.print("HTTP/1.1 200 \r\n");
          } else {
              out.print("HTTP/1.1 400 \r\n");
          }
          
          
          out.close(); 
          in.close(); 
          client.close(); 
        } 
      }
      catch (Exception e) {
        System.err.println(e);
        System.err.println("Usage: java HttpMirror <port>");
      }
    }//end main
       
}
