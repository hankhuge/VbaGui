package HomeAutomation;

import java.io.*;
import java.net.*;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Server
{
    static Socket sock;
    OutputStream ostream;
    PrintWriter pwrite;
    InputStream istream;
    static BufferedReader receiveRead;
    
    private GpioPinDigitalOutput roomLight;
    private GpioPinDigitalOutput nightLight;
    private GpioPinDigitalOutput fan;
    private GpioPinDigitalOutput TV;
    
    public Server() 
    {
       // GpioController gpio = GpioFactory.getInstance();
        //roomLight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        //nightLight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
        //fan = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
        //TV = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
        
    }
    public void send( String sendMessage) throws IOException
    {
         pwrite.println(sendMessage);             
         pwrite.flush();
    }
    
    public void initialize() throws IOException
    {
        ServerSocket sersock = new ServerSocket(3000);
        System.out.println("Server  ready for chatting");
        sock = sersock.accept( ); 
        ostream = sock.getOutputStream(); 
        pwrite = new PrintWriter(ostream, true);
        
        istream = sock.getInputStream();
        receiveRead = new BufferedReader(new InputStreamReader(istream));
    }
    public void start() throws IOException
    {
       initialize();
       String receiveMessage;               
        
          while(true)
          {
           if((receiveMessage = receiveRead.readLine()) != null)  
           {
              if(receiveMessage.equals("I am Client"))
              {
                send("I am server");
              }
              else if(receiveMessage.contains("turn on"))
              {
                if(receiveMessage.endsWith("room light"))
                {
                    //roomLight.setState(PinState.HIGH);
                    send("room light turned ON");
                }
                else if(receiveMessage.endsWith("night light"))  
                {
                    //nightLight.setState(PinState.HIGH);
                    send("night light turned ON");
                }
                else if(receiveMessage.endsWith("fan")) 
                {
                    //fan.setState(PinState.HIGH);
                    send("fan turned ON");
                }
                else if(receiveMessage.endsWith("tv")) 
                {
                    //TV.setState(PinState.HIGH);
                    send("TV turned ON");
                }
              }
              else if(receiveMessage.contains("turn off"))
              {
                if(receiveMessage.endsWith("room light"))
                {
                     //roomLight.setState(PinState.LOW);
                     send("room light turned OFF");
                }
                else if(receiveMessage.endsWith("night light"))  
                {
                    //nightLight.setState(PinState.LOW);
                    send("night light turned OFF");
                }
                else if(receiveMessage.endsWith("fan")) 
                {
                    //fan.setState(PinState.LOW);
                    send("fan turned OFF");
                }
                else if(receiveMessage.endsWith("tv")) 
                { 
                    //TV.setState(PinState.LOW);
                    send("tv turned OFF");
                }
              }
        }         
      }               
    }
    public static void main(String[] args) 
    {
          Server svr = new Server();
          try {
            svr.start();
           } catch (Exception e) {
           }

    }                    
}                        