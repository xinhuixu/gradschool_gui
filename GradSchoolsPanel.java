/**
 * Sets up the GUI panel for Grad Schools
 * @authors Xinhui Xu and Julia McDonald
 * @date Nov 19, 2017
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
    academicsLabel2, researchLabel2, pubsLabel2, newSchoolAddedLabel, topSchoolLabel;
  private JPanel addSchoolPanel, aboutPanel, evaluatePanel;
  private JTextField schoolNameField;
  private JSlider acadSlider, resSlider, pubsSlider;
  private JComboBox academicsField1, researchField1, pubsField1;
  
  private int acadWeight, resWeight, pubsWeight;
  private GradSchools gs;
  
  /**
   * Constructor, primarily makes the three tabs before using helper methods
   * @param gs - GradSchools object
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
  
  /**
   * Makes the panel that describes the project
   */
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
  
  /**
   * Makes an evaluate panel that has three slider bars and shows the top school based on user's weighting
   */
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
    acadSlider.setSnapToTicks(true);
    
    
    researchLabel2 = new JLabel( "Research: " );
    
    
    pubsLabel2 = new JLabel( "Publications: " );
    
    
    resSlider = new JSlider(JSlider.HORIZONTAL, min, max, min);
    resSlider.addChangeListener( this );
    
    //Turn on labels at major tick marks.
    resSlider.setMajorTickSpacing(5);
    resSlider.setMinorTickSpacing(1);
    resSlider.setPaintTicks(true);
    resSlider.setPaintLabels(true);
    resSlider.setSnapToTicks(true);
    
    pubsLabel2 = new JLabel( "Publications: " );
    
    pubsSlider = new JSlider(JSlider.HORIZONTAL, min, max, min);
    pubsSlider.addChangeListener( this );
    
    //Turn on labels at major tick marks.
    pubsSlider.setMajorTickSpacing(5);
    pubsSlider.setMinorTickSpacing(1);
    pubsSlider.setPaintTicks(true);
    pubsSlider.setPaintLabels(true);
    pubsSlider.setSnapToTicks(true);
    
    topSchoolLabel = new JLabel( "Top School will appear here" );
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0; 
    gbc.anchor = GridBagConstraints.WEST;
    
    gbc.gridwidth = 3;
    gbc.weightx = 0.0;
    evaluatePanel.add( evaluateInfo, gbc );
    
    
    gbc.gridy++;
    gbc.weightx = 0.5;
    gbc.gridwidth = 1;
    evaluatePanel.add( academicsLabel2, gbc );
    gbc.gridx++;
    evaluatePanel.add( acadSlider, gbc );
    gbc.gridx++;
    evaluatePanel.add( researchLabel2, gbc );
    gbc.gridx++;
    evaluatePanel.add( resSlider, gbc );
    gbc.gridx++;
    evaluatePanel.add( pubsLabel2, gbc );
    gbc.gridx++;
    evaluatePanel.add( pubsSlider, gbc );
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 4;
    evaluatePanel.add( topSchoolLabel, gbc );
  }
  
  
  /**
   * Interprets the values of the sliders and shows the top school
   */
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
      
      if( source == acadSlider ){
        acadWeight = source.getValue();
      }
      if( source == resSlider ){
        resWeight = source.getValue();
      }
      if( source == pubsSlider ){
        pubsWeight = source.getValue();
      }
      gs.computeRatings( acadWeight, resWeight, pubsWeight );
      gs.rankSchools( "Overall" );
      topSchoolLabel.setText( gs.getTop().toString());
      System.out.println( "The top school is " + gs.getTop().toString() + " and the weights are Academics: " 
                           + acadWeight + " Research: " + resWeight + " Pubs: " + pubsWeight);
    }
  }  
  
  /**
   * Makes the add school panel in which schools can be added through a text box and three drop down menus
   * Shows a school when it is added
   */
  private void makeAddSchoolPanel() {
    GridBagLayout gridbag = new GridBagLayout();
    addSchoolPanel = new JPanel(gridbag);
    //addSchoolPanel.setPreferredSize(new Dimension(600,300));
    addSchoolInfo = new JLabel("Fill in the info to add a school, then click 'Add School'");
    schoolLabel1 = new JLabel("School: ");
    schoolNameField = new JTextField(10);
    
    academicsLabel1 = new JLabel("Academics: ");
    String[] rank = {"1","2","3","4","5"}; 
    academicsField1 = new JComboBox(rank);
    
    researchLabel1 = new JLabel("Research: ");
    researchField1 = new JComboBox(rank);
    pubsLabel1 = new JLabel("Pubs: ");
    pubsField1 = new JComboBox(rank);
    
    addSchoolButton = new JButton("Add school");
    addSchoolButton.addActionListener(new ButtonListener());
    
    newSchoolAddedLabel = new JLabel( "Last school added will appear here." );
    
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
    addSchoolPanel.add(schoolNameField, gbc);
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
    gbc.gridwidth = 4;
    gbc.gridx = 0;
    gbc.gridy++;
    addSchoolPanel.add( newSchoolAddedLabel, gbc );
  }
  
  
  /**
   * Responds to button push events
   */
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == addSchoolButton){
        System.out.println("add school pushed");
        String name = schoolNameField.getText();
        int aca = Integer.parseInt((String)academicsField1.getSelectedItem());
        int res = Integer.parseInt((String)researchField1.getSelectedItem());
        int pub = Integer.parseInt((String)pubsField1.getSelectedItem());
        gs.addSchool(name, aca, res, pub);
        System.out.println("Added new school\n"+gs);
        
        School s = new School( name, aca, res, pub );
        newSchoolAddedLabel.setText( s.toString() );
      }
      
    }
  }
}


