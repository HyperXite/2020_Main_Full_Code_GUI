import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer; 
import java.nio.charset.Charset; 
import java.nio.charset.CharsetEncoder; 

public class hxClient2 {

    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";
        int portNumber = 5000;
        Socket firstSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(firstSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(firstSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
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
            out.println("c-2.25");
            System.out.println("recieved: "+in.readLine());;
            out.println("d-129.1245");
            System.out.println("recieved: "+in.readLine());;
            out.println("e-19.15");
            System.out.println("recieved: "+in.readLine());;
            out.println("j-IDLE");
            System.out.println("recieved: "+in.readLine());;
            out.println("k-24.1245");
            System.out.println("recieved: "+in.readLine());;
            out.println("l-0.35");
            System.out.println("recieved: "+in.readLine());;
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