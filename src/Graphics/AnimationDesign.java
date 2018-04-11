/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import javax.swing.JPanel;

/**
 *
 * @author Hank
 */
public class AnimationDesign {
    
    public static void changePanel(JPanel p1, JPanel p2)
    {
       p1.removeAll();
       p1.add(p2);
       p1.revalidate();
       p1.repaint();
      
    }
}
