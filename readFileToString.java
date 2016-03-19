import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class readFileToStringClass {
	
	public static String readFileToString() throws IOException {
		File dirs = new File(".");
		String filePath = dirs.getCanonicalPath() + File.separator+"src"+File.separator+"TestRead.java";
 
		//Constructs a string buffer with no characters in it and the specified initial capacity
		StringBuilder fileData = new StringBuilder(1000);
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		String returnStr = fileData.toString();
		System.out.println(returnStr);
		return returnStr;
	}
}
