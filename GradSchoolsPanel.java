/**
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class GradSchoolsPanel extends JPanel implements ChangeListener {
  //instance vars
  private JTabbedPane tabbed_pane;
  private JButton addSchoolButton;
  private JLabel info, addSchoolInfo, evaluateInfo, schoolLabel1, academicsLabel1, researchLabel1, pubsLabel1, 
    academicsLabel2, researchLabel2, pubsLabel2;
  private JPanel addSchoolPanel, aboutPanel, evaluatePanel;
  private JTextField schoolNameField;
  private JSlider acadSlider;
  
  private JTextField schoolField1, academicsField1, researchField1, pubsField1;
  
  
  private GradSchools gs;
  
  /**
   * Constructor
   */
  public GradSchoolsPanel( GradSchools gs ) {
    this.gs = gs;
    tabbed_pane = new JTabbedPane();
    
    makeAboutPanel();
    tabbed_pane.addTab("About", aboutPanel);
    
    makeAddSchoolPanel();
    tabbed_pane.addTab("Add School", addSchoolPanel);
    
    makeEvaluatePanel();
    tabbed_pane.addTab("Evaluate", evaluatePanel);
    
    add(tabbed_pane);
  }
  
  
  private void makeAboutPanel() {
    //we were just testing out GridBagLayout as practice for makeEvaluatePanel() and 
    //makeAddSchoolPanel(). We realize it is not necessary.
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
  
  private void makeEvaluatePanel() {
    evaluatePanel = new JPanel( new GridBagLayout() );
    
    evaluateInfo = new JLabel( "Fill in the information to add a school, then click \"Add School\"" );
    
    academicsLabel2 = new JLabel( "Academics: " );
    
    int min = 0;
    int max = 5;
    
    acadSlider = new JSlider(JSlider.HORIZONTAL, min, max, min);
    acadSlider.addChangeListener( this );
    
    //Turn on labels at major tick marks.
    acadSlider.setMajorTickSpacing(5);
    acadSlider.setMinorTickSpacing(1);
    acadSlider.setPaintTicks(true);
    acadSlider.setPaintLabels(true);
    
    researchLabel2 = new JLabel( "Research: " );
    
    pubsLabel2 = new JLabel( "Publications: " );
    
    GridBagConstraints gbc = new GridBagConstraints();
    aboutPanel.add( evaluateInfo, gbc );
    gbc.gridx++;
    aboutPanel.add( academicsLabel2, gbc );
    gbc.gridy++;
    aboutPanel.add( acadSlider, gbc );
  }
  
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
      int rating = (int)source.getValue();
    }
  }
  
  
  private void makeAddSchoolPanel() {
    GridBagLayout gridbag = new GridBagLayout();
    addSchoolPanel = new JPanel(gridbag);
    //addSchoolPanel.setPreferredSize(new Dimension(600,300));
    addSchoolInfo = new JLabel("Fill in the info to add a school, then click 'Add School'");
    schoolLabel1 = new JLabel("School: ");
    schoolField1 = new JTextField(10);
    academicsLabel1 = new JLabel("Academics: ");
    academicsField1 = new JTextField(10);
    researchLabel1 = new JLabel("Research: ");
    researchField1 = new JTextField(10);
    pubsLabel1 = new JLabel("Pubs: ");
    pubsField1 = new JTextField(10);
    addSchoolButton = new JButton("Add school");
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0; 
    gbc.anchor = GridBagConstraints.WEST;
    
    gbc.gridwidth = 3;
    gbc.weightx = 0.0;
    addSchoolPanel.add(addSchoolInfo, gbc);
    
    gbc.gridy++;
    gbc.weightx = 0.5;
    gbc.gridwidth = 1;
    addSchoolPanel.add(schoolLabel1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(schoolField1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(researchLabel1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(researchField1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(pubsLabel1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(pubsField1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(academicsLabel1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(academicsField1, gbc);
    gbc.gridx++;
    addSchoolPanel.add(addSchoolButton, gbc);
  }
  
//respond to button push events
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == addSchoolButton){
        System.out.println("add school pushed");
        
      }
    }
  }
}

