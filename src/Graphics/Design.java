/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hank
 */
public class Design {
    
    public static void makeTransparentPanel(JPanel p)
    {
        p.setOpaque(false);
        p.setBackground(new Color(0,0,0,0));
    }
    public static void makeTrasparenttextField(JTextField tf)
    {
        tf.setOpaque(false);
        tf.setBackground(new Color(0,0,0,0));
        tf.setBorder(null);
    }
}
