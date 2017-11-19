/* FILE NAME: GradSchoolsGUI.java
 * WHO: Xinhui Xu, Julia McDonald
 * WHAT: sets up GUI
 */

import javax.swing.JFrame;
import java.awt.*;

public class GradSchoolsGUI {
  
  public static void main (String[] args){
    JFrame frame = new JFrame("Grad Schools");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    GradSchools gs = new GradSchools();
    
    GradSchoolsPanel panel = new GradSchoolsPanel(gs);
    //    panel.setPreferredSize(new Dimension(600, 300));
    frame.setSize(600, 300);
    frame.getContentPane().add(panel);
    
    frame.pack();
    frame.setVisible(true);
  }
}
