import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer; 
import java.nio.charset.Charset; 
import java.nio.charset.CharsetEncoder; 

public class hxClient2 {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        Socket firstSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(firstSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(firstSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput, userInput1;
        userInput = stdIn.readLine();
        
        /**
        // do this once to setup
        CharsetEncoder enc = Charset.forName("ISO-8859-1").newEncoder();
        // for each string
        int len = userInput.length();
        byte b[] = new byte[len + 1];
        ByteBuffer bbuf = ByteBuffer.wrap(b);
        enc.encode(CharBuffer.wrap(userInput), bbuf, true);
        // you might want to ensure that bbuf.position() == len
        b[len] = 0;
        //userInput1 = userInput + "\0";
        if (userInput != null) {
        	out.println(userInput);
            System.out.println("received: " + in.readLine());
        }
        **/
        
        
        try {
	        while ((userInput = stdIn.readLine()) != null) 
	        {
	        	//firstSocket.getOutputStream().write(b);
	            out.println(userInput);
	            System.out.println("received: " + in.readLine());
	        }
        } finally {
            in.close();
            stdIn.close();
        	firstSocket.close();
        }
        
        in.close();
        stdIn.close();
        firstSocket.close();

    }
}