import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GradSchoolsPanel extends JPanel {

    private GradSchools grads;
    protected JTextField schoolNameField;
    private final static String NEW_LINE = "\n";
    
    public GradSchoolsPanel(GradSchools gs){	
	super(new GridBagLayout());
	grads = gs;
	
	JTabbedPane tabbed_pane = new JTabbedPane();

	JComponent panel1 = makeTextPanel("Choose the Grad School that fits you best!The next killer app designed by JXIndustries, Inc. Select the Add School tab to add schools. Then select the Evaluate tab to evaluate them.");
	tabbed_pane.addTab("About", panel1);
	
	JComponent panel2 = makeTextPanel("Add school");
	tabbed_pane.addTab("Add School", panel2);

	JComponent panel3 = makeTextPanel("Evaluate");
	tabbed_pane.addTab("Evaluate", panel3);	

	schoolNameField = new JTextField(10);
	tabbed_pane.setComponentAt(1, schoolNameField);

	add(tabbed_pane);
    }

     protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
	//        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridBagLayout());
        panel.add(filler);
        return panel;
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        //Add content to the window.
        frame.add(new GradSchoolsPanel(new GradSchools()), BorderLayout.CENTER);         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    //Turn off metal's use of bold fonts
		    UIManager.put("swing.boldMetal", Boolean.FALSE);
		    createAndShowGUI();
		}
	    });
    }
}
