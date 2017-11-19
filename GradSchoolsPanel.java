/**
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GradSchoolsPanel extends JPanel {
  //instance vars
  private JTabbedPane tabbed_pane;
  private JButton addSchoolutton;
  private JLabel info, addSchoolInfo, evaluateInfo, schoolLabel, academicsLabel1, researchLabel1, pubsLabel1, 
    academicsLabel2, researchLabel2, pubsLabel2;
  private JPanel addSchoolPanel, aboutPanel, evaluatePanel;
  private JTextField schoolNameField;
  
  private GradSchools gs;
  
  /**
   * Constructor
   */
  public GradSchoolsPanel( GradSchools gs ) {
    this.gs = gs;
    tabbed_pane = new JTabbedPane();
    
    makeAboutPanel();
    tabbed_pane.addTab("About", aboutPanel);
    
    addSchoolPanel = new JPanel(false);
    tabbed_pane.addTab("Add School", addSchoolPanel);
    
    evaluatePanel = new JPanel(false);
    tabbed_pane.addTab("Evaluate", evaluatePanel);
    
    schoolNameField = new JTextField(10);
    tabbed_pane.setComponentAt(1, schoolNameField);
    
    add(tabbed_pane);
  }
  
  private void makeAboutPanel() {
    aboutPanel = new JPanel( new GridBagLayout() );
    
    info = new JLabel( "<html>Choose the Graduate School that fits you best!<br>" +
                      "The next killer app designed by JXIndustries, Inc.<br>" + 
                      "Select the Add School tab to add graduate schools.<br>" + 
                      "Then select the Evaluate tab to evaluate them.</html>" );
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    
    aboutPanel.add( info, gbc );
  }
  
  
}