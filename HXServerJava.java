// A Java program for a Server 
import java.net.*; 
import java.io.*; 
  
public class HXServerJava 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    // constructor with port 
    public HXServerJava(int port) 
    { 
        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            String line = ""; 
  
            // reads message from client until "over" is sent 
            while (!line.equals("exit")) 
            { 
                try
                { 
                	int commandFlag = 0;
                    line = in.readLine(); 
                    System.out.println("line before is: " + line);
                    line = line.replaceAll("\\s",""); //trying to get rid of whitespace
                    System.out.println("line after is: " + line);
                    if ((line != null && line.equals("hi")==true)) {
                    	commandFlag = 1;
                    	out.print("Welcome by server\n");
                        out.flush();
                        //out.close();
                    }
                    if ((line != null && line.equals("command1")==true)) {
                    	commandFlag = 1;
                    	out.print("first command executed\n");
                        out.flush();
                        //out.close();
                    }
                    if ((line != null && line.equals("exit")==true)) {
                    	commandFlag = 1;
                    	out.print("exiting, closing socket\n");
                        out.flush();
                        //out.close();
                    }
                    
                    if (line != null && commandFlag == 0){
                    	out.print("command not recognized!\n");
                        out.flush();
                    }
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
            out.print("exit\n");
            out.flush();
            // close connection 
            socket.close(); 
            in.close(); 
            out.close();
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        HXServerJava server = new HXServerJava(5000); 
    } 
} 