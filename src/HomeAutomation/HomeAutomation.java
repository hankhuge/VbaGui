package HomeAutomation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HomeAutomation {
    
     private final String serverAddress = "192.168.1.88";
     Socket sock;
     BufferedReader keyRead;
     OutputStream ostream;
     PrintWriter pwrite;
     InputStream istream;
     BufferedReader receiveRead;
     private String receiveMessage, sendMessage;
     
     public HomeAutomation() 
     {
         try{
           checkConnection();
         }
         catch(Exception e)
         {}
     }
     public void intialize() throws Exception
     {
        sock = new Socket(serverAddress, 3000);
        keyRead = new BufferedReader(new InputStreamReader(System.in));
        ostream = sock.getOutputStream();
        pwrite = new PrintWriter(ostream, true);
        istream = sock.getInputStream();
        receiveRead = new BufferedReader(new InputStreamReader(istream));
     }
     
     public boolean checkConnection() throws Exception
     {
        intialize();
        sendMessage = "I am Client";  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        pwrite.flush();
        
        if((receiveMessage = receiveRead.readLine()) != null) //receive from server
          if(receiveMessage.equals("I am server"))
          {
            System.out.println("Connection established");// displaying at DOS prompt
            return true;
          }
          else
          {
              System.err.println("Connection Failure to the Server. Check Server is runnimg or not...");
              return false;
          }
        else
        {
              System.err.println("Connection Failure toserver");
              return false;
        }
     }
     public void send(String message)
     {
        pwrite.println(message);       
        pwrite.flush();
     }
     
     public void decideTurnON(String s) throws Exception
     {
        if(s.endsWith("room light"))
        {
            send("turn on room light");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("night light"))
        {
            send("turn on night light");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("fan"))
        {
            send("turn on fan");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("tv"))
        {
            send("turn on tv");
            System.err.println(receiveRead.readLine());
        }
     }
     
     public void decideTurnOFF(String s) throws Exception
     {
        if(s.endsWith("room light"))
        {
            send("turn off room light");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("night light"))
        {
            send("turn off night light");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("fan"))
        {
            send("turn off fan");
            System.err.println(receiveRead.readLine());
        }
        else if(s.endsWith("tv"))
        {     
            send("turn off tv");
            System.err.println(receiveRead.readLine());
        }
     }
     
}