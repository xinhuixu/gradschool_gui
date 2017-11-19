/**
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GradSchoolsPanel extends JPanel {
    //instance vars
    private JTabbedPane tabbed_pane;
    private JButton addSchoolButton;
    private JLabel info, addSchoolInfo, evaluateInfo, schoolLabel, academicsLabel1, researchLabel1, pubsLabel1, 
	academicsLabel2, researchLabel2, pubsLabel2;
    private JPanel addSchoolPanel, aboutPanel, evaluatePanel;
    private JTextField schoolField1, academicsField1,
	researchField1, pubsField1;
  
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
    
	evaluatePanel = new JPanel(false);
	tabbed_pane.addTab("Evaluate", evaluatePanel);
    
    
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
    
    private void makeAddSchoolPanel() {
	GridBagLayout gridbag = new GridBagLayout();
	addSchoolPanel = new JPanel(gridbag);
	//addSchoolPanel.setPreferredSize(new Dimension(600,300));
	addSchoolInfo = new JLabel("Fill in the info to add a school, then click 'Add School'");
	schoolLabel = new JLabel("School: ");
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
	addSchoolPanel.add(schoolLabel, gbc);
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
