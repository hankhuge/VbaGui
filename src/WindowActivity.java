
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hank
 */
public class WindowActivity {
    
    LogoForm frame ;
    MainFrame mainFrame;
   
    public void showWindow()
    {
       frame = new LogoForm(new JFrame(), true);
       frame.setVisible(true);
    }
    
     public void expand() throws MalformedURLException, IOException, LineUnavailableException
    {
       System.err.println("inside expand");
       frame.reco.close();
       frame.dispose();
       mainFrame = new MainFrame();
       mainFrame.setVisible(true);
       mainFrame.reco.recognise();
    }
      
    
    public  void shrink() throws IOException, LineUnavailableException
    {
        System.err.println("inside shrink");
        mainFrame.reco.close();
        mainFrame.dispose();
        frame = new LogoForm(new javax.swing.JFrame(), true);
        frame.setVisible(true);
        frame.reco.recognise();
    }
}
