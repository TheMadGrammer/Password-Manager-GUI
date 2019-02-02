
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class filefind {
	public static String name;
	public static String path;	

	
	public JFileChooser fc = new JFileChooser();
	JPanel pnl = new JPanel();
	public JFrame frame = new JFrame();
	public static File selectedfile;
	
	
	public filefind() throws IOException {
		frame.add(fc);
		fc.setDialogTitle("Select CoMPreZed Password");
		FileNameExtensionFilter	ff = new FileNameExtensionFilter(" CoMPreZed Password (.cmpzdp) file", "cmpzdp");
		fc.addChoosableFileFilter (ff);
		fc.setFileFilter(ff);
		
	
		Path currentRelativePath = Paths.get("");
		File workingDirectory = currentRelativePath.toAbsolutePath().toFile();

		
		fc.setCurrentDirectory(workingDirectory);
		
	
		int result = fc.showOpenDialog(frame);
		 frame.setFocusable(true);
		 frame.setFocusableWindowState(true);
		 
		    
		    switch (result) {
		    case JFileChooser.APPROVE_OPTION:
		    	fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    	
		    	
		    	
		    	
		    	selectedfile = fc.getSelectedFile().getAbsoluteFile();
		    	
		 

				 //System.out.println(selectedfile);
				 getFileName(selectedfile);
				 
				 new dec();
				 
				 
	
			    	
		      break;
		    case JFileChooser.CANCEL_OPTION:
		
		     
		      break;
		    case JFileChooser.ERROR_OPTION:
		      System.out.println("Error");
		      break;
		 
		  }
		    
	
		
		
		
		
       
		
}
	


	public String getFileName(File selectedfile) {
		
		// TODO Auto-generated method stub
		 name = selectedfile.getName();
		//System.out.println(name);
		
		
		
	return name;
	
	
	}





}