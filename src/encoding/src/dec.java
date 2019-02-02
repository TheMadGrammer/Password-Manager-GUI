import java.io.IOException;
import java.io.RandomAccessFile;

public class dec {
	public static String password;
	
	public dec() throws IOException {
		
		
		String unCmpPass;
		
		
		
		RandomAccessFile raf1 = new RandomAccessFile(filefind.selectedfile, "r");
		
		int h = 0;
		int j = 0;
		
		raf1.seek(0x0);
		int length =(raf1.readInt());
		
	
		
		raf1.seek(0x4);
		
		char arr00 = raf1.readChar();
	//	System.out.println(arr00);
		
		
		
		
	int offset0 = (length*arr00);
		
		
		
		char[] cs = new char[(length)];

		
		for(h = 0; h<length/2; ++h){
			
			//int offset1 = offset0+h*27;
			
			int offset = (offset0 + h * 27);
			raf1.seek(offset);
			char arrprnt0 =raf1.readChar();
	//		System.out.println(arrprnt0);
			
			
		
			cs[j] = arrprnt0;
			
			
				++j;
				++j;
			
			
	int offset2 = (offset0 + h * 27) + 5;
			raf1.seek(offset2);
			char arrprnt1 =raf1.readChar();
		
		
			cs[j-1] = arrprnt1;
			
		
			
		}
 unCmpPass =  String.valueOf(cs);
	
	//System.out.print(unCmpPass);
		raf1.close();
			
			
			
			StringBuilder output = new StringBuilder();
			for(int i2 = 0; i2 < unCmpPass.length(); i2+=2) {
			    String str = unCmpPass.substring(i2, i2+2);
			    output.append((char)Integer.parseInt(str, 16));
			
			}
			
			 password = (output.toString().trim());
                         System.out.println(password);
			 //new EndMsg();
	}
        
    public String getPassword() {
        return password;
    }

}
