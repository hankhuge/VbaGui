
import Graphics.Design;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;




public class LogoForm extends javax.swing.JDialog {

    
    boolean checkFrameState = true;
    Recognizer reco ;
    
    public LogoForm(java.awt.Frame parent, boolean modal)  {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        //setAlwaysOnTop(true);
        setBackground(new Color(0,0,0,0));
        setLocation(525,200);
        Design.makeTransparentPanel(jPanel1);
        reco = new Recognizer();
        
    }

    
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Close = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseClicked(evt);
            }
        });

        Close.setText("close");
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseMousePressed(evt);
            }
        });
        jPopupMenu1.add(Close);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoFrame.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if( evt.getButton()== MouseEvent.BUTTON1)
        {
            if(checkFrameState)
            {
               jLabel1.setIcon(Images.logoFrameHover);
               try {  reco.recognise(); } 
               catch (IOException ex) {} 
               catch (LineUnavailableException ex) {}
               checkFrameState = false;
            }
            else
            {
                jLabel1.setIcon(Images.logoFrame);
                reco.close();
                checkFrameState = true;
            }
        }
        else if(evt.getButton() == MouseEvent.BUTTON3)
                jPopupMenu1.show(this, evt.getX(), evt.getY());
      
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPopupMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseClicked
        
    }//GEN-LAST:event_jPopupMenu1MouseClicked

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_CloseMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}