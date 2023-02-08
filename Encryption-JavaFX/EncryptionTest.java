import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class EncryptionTest
{
   public static void main(String args[])
   {
      JFrame frame = new JFrame("Encryption");
      JLabel label = new JLabel("Enter data to be encrypted: ");
      System.out.printf("X: %f, Y: %f \n", label.getAlignmentX(), label.getAlignmentY());
      //label.setAlignmentX(50);
      //label.setAlignmentY(50);
      System.out.printf("X: %f, Y: %f \n", label.getAlignmentX(), label.getAlignmentY());
      //frame.add(label, BorderLayout.NORTH);
      
      EncryptionPanel ep = new EncryptionPanel();
      ep.add(label, BorderLayout.WEST);
      
      InvisibleTextField tf = new InvisibleTextField();
      tf.setText("Enter data here");
      tf.setLocation(100, 100);
      ep.add(tf);
      
      frame.add(ep);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 800);
      frame.setVisible(true);
   }
}

class EncryptionPanel extends JPanel implements ActionListener
{
   public Encryption e;
   public EncryptionPanel()
   {
      e = new Encryption();
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      
   }
   public void actionPerformed(ActionEvent actionEvent)
   {
      repaint();
   }
}