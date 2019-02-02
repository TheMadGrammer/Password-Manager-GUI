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



public class GUI extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame();	
    JPanel panel = new JPanel();
    public JFormattedTextField f = new JFormattedTextField();
    public Label lbl = new Label("Insert Password");
    public JButton Thiccness = new JButton("Encrypt Password");
    
    public static String unfiltered;
    
	public static void main(String[] args) {
		
	}
	
	public GUI(){
		
		Thiccness.addActionListener(this);
		
		
		
		JButton dec = new JButton(new AbstractAction("Decrypt Password") {
	        
        
			private static final long serialVersionUID = 1L;

			public void actionPerformed( ActionEvent e ) {	//button2's effect. trying to make a direct import button
       	try {
			new filefind();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       	
            }
        });
		
		 panel.add(lbl);
		 panel.add(f);
		 panel.add(Thiccness);
		 panel.add(dec);
	        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	        panel.setLayout(new GridLayout(1, 1, 0, 0));
	      
		  frame.add(panel, BorderLayout.CENTER);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("Insert Password"); //name of window
	        frame.pack();
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null); 
	        

	        
	}


	public void actionPerformed(ActionEvent arg0) {
		
	unfiltered  = f.getText(); //get password
	System.out.println(unfiltered);
	
	
	try {
		new enc(unfiltered);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

		
	
}
