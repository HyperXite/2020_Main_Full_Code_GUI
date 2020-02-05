// A Java program for a Server 
import DataPackage.allData;

import java.net.*;
import java.io.*; 
import java.util.*;
import java.util.logging.Handler;

public class HXServerJava 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null;
    private BufferedReader in;
    private PrintWriter out;
    private String line;
    private opcodeHandler handler = new opcodeHandler();
  
    // constructor with port 
    public HXServerJava(int port) {
        // starts server and creates a connection
        try {
            server = new ServerSocket(port);
            System.out.println("opened port");

            socket = server.accept();
            System.out.println("connection formed");

            //initialize readers and writers once a connection is made
            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            line = "";

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public boolean waitForConnection(int timeout, allData data) {
        //waits for a transmission until timeout in milliseconds
        //handles the operations if a transmission is received
        //returns true if communication happened false if failed


        try
        {
            int count = 0;
            while(count < timeout){
                Thread.sleep(1);
                count++;
            }
            //System.out.println("before client read");
            line = in.readLine();
            //System.out.println("after client read");
            if (line == null){
                return false;
            }
            System.out.println("incoming command: " + line);
            line = line.replaceAll("\\s",""); //trying to get rid of whitespace
            String[] command = line.split("-");
            handler.handleIncoming(command,data);
            out.println(""+handler.SUCCESS+"-"+0);
        }
        catch(IOException i)
        {
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }



    public void closeConnection() {
        //closes connection for ending the communication
        try {
            out.flush();
            socket.close();
            in.close();
            out.close();
        } catch(IOException i)
        {
            System.out.println(i);
        }
    }

}
