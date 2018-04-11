
import Youtube.Search;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hank
 */
public class Test{
    
    private final JFrame frame;
    
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    public Test() throws IOException {
         
         
         
        boolean found = new NativeDiscovery().discover();
        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setBounds(0, 0, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });
        
        //mediaPlayerComponent.mediaSubItemAdded(mediaPlayer, subItem);
        
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        
        mediaPlayerComponent.getMediaPlayer().setPlaySubItems(true);
        
        mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter()
        {
            @Override
            public void buffering(MediaPlayer mediaPlayer, float newCache) {
                //System.out.println("Buffering " + newCache);
            }

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
                
            }
            
            
        });
        
        
        
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
        frame.setContentPane(mediaPlayerComponent);
        frame.setVisible(true);  
        
        
        
     }
      
     public void play(String ID)
     {
          
          frame.setTitle(Search.TITLE);
          String URL = "https://www.youtube.com/watch?v="+ID; 
          //String URL=null;
          //URL = "E:\\Movies\\Dunkirk.2017.1080p.BluRay.H264.AAC-RARBG\\Dunkirk.2017.1080p.BluRay.H264.AAC-RARBG.mp4";   
          mediaPlayerComponent.getMediaPlayer().playMedia(URL);
          
          
          
         
      }

     
     
}
