
import java.io.IOException;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Random;


import javax.xml.bind.DatatypeConverter;

public class enc {
	
	
	
	public static void main(String[] args){
	}
		public enc(String unfiltered) throws IOException {
		
		
			
			String fil1 = toHexadecimal(unfiltered);
	
		//	System.out.println(fil1);
			
			
			 
			int i1;
			
			int i;
			
			char[] arr0 = new char[fil1.length()];
			char[] arr1 = new char[fil1.length()];
			
			  
			  

			for(i=0; i<fil1.length()-1; ++i){
				
			    
				
		char t = fil1.charAt(i); 
			
			arr0[i/2] =t;
			
	//	ps.print(arr0[i]);
			
			++i;
			char t1 = fil1.charAt(i); 
			arr1[i/2] =t1;
			
			
			}
		
			
			RandomAccessFile raf = new RandomAccessFile("pass.cmpzdp", "rw");
		for(i1=0; i<27*999*fil1.length(); ++i) {
			
			
			Random rand = new Random();
			int rnd= rand.nextInt(999*fil1.length()-1)+1;
			raf.write(rnd);
		
		}
		
		int length = fil1.length();
		
		raf.seek(0x0);
		raf.writeInt(length);
	
//		System.out.println(length);
		
		
		raf.seek(0x4);
		raf.writeChar(arr0[0]);
	
		
		
		int f;
		
		
		int offset0 = arr0[0]*fil1.length();
		
	
		//System.out.println(Integer.toHexString(offset0));
		
		
		for(f =0; f<(fil1.length()/2); ++f) {
	
		
		int offset1 = offset0+f*27;
		
		raf.seek(offset1);
		raf.writeChar(arr0[f]);
	
		}
		int g;
		
	
		for(g =0; g<fil1.length()/2; ++g) {
			
			int offset1 = (offset0+g*27)+5;
			
			
			raf.seek(offset1);
			raf.writeChar(arr1[g]);
		
			
			
			
		}

			
		
			

			
		new EncMsg();
				
				
				
				
			}
			
			
		
	
		
	
		
		public static String toHexadecimal(String text) throws UnsupportedEncodingException
		{
		    byte[] myBytes = text.getBytes("UTF-8");

		    return DatatypeConverter.printHexBinary(myBytes);
	}
		
		
	
		
		
		
		}