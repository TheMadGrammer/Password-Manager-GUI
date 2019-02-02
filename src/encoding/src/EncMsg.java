import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.DatatypeConverter;



public class EncMsg extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame();	
    JPanel panel = new JPanel();
  
    public Label lbl = new Label("Encryption Complete.");
    public JButton butt = new JButton("OK");
   
    
    public static String unfiltered;
    
	public static void main(String[] args) {
		
	}
	
	public EncMsg(){
		
	
		
     butt.addActionListener(this);
      
		 panel.add(lbl);
		 panel.add(butt);
	
		
	        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	        panel.setLayout(new GridLayout(0, 1, 0, 0));
	      
		  frame.add(panel, BorderLayout.CENTER);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("Password"); //name of window
	        frame.pack();
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null); 
	        

	        
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
	
		
	}

}
