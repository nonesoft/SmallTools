package nonesoft.develop_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ConsoleDev {	
	
	public ConsoleDev() {
		//Testing area		
	}

	public static String convertStringArrayToString(String[] strArray, String delimiter) {
		
		StringBuilder sb = new StringBuilder();
		for (String str : strArray)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}
	
	
	public static void main(String[] args){
//		Properties allProp = System.getProperties();
//		for (String strVal : allProp.stringPropertyNames()) {
////			if(strVal.contains("os")) {
//				System.out.println(strVal);
////			}						
//		}
		
//		System.out.println(System.lineSeparator());
		
		FileOutputStream output = null;
		
		try {
			output = new FileOutputStream("config.properties");
		
			Properties servConf = new Properties();
			
			servConf.setProperty("FileName", "checkin.log");
			
			Path rootDir = FileSystems.getDefault().getPath("C:","Data","workspace");
			File allFiles = new File(rootDir.toString());
			File[] listFiles = allFiles.listFiles();
			File fullFilePath = null;
			try {
				for(File strVal : listFiles ) {
					if(strVal.isDirectory() && strVal.toString().contains("SmallTools")) {
						fullFilePath = new File(strVal.getAbsolutePath(),"checkin.log");
						if(fullFilePath.isFile()) {
							servConf.setProperty("WorkFile", fullFilePath.getAbsolutePath());
						}
						
					}
				}
				
				ArrayList<String[]> fileContent = new ArrayList<>();
				
				if(fullFilePath.exists()) {
					InputStream outFile = Files.newInputStream(fullFilePath.toPath());
					BufferedReader bufRdContent = new BufferedReader(new InputStreamReader(outFile));
					
					
					String aLine = null;

			        while ((aLine = bufRdContent.readLine()) != null)
			        {
			        	if(aLine.contains("e_mnadvo")) {
			        		String [] newT = aLine.split("\\s");			        		
				        	fileContent.add(newT);				        	
			        	}			        	
			        }

			        bufRdContent.close();
				}
				
			for(int idx = 0; idx < fileContent.size(); idx++) {
				String[] line = fileContent.get(idx);
				
				System.out.println(convertStringArrayToString(line, " "));
			}
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			servConf.store(output, null);
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		
	}

}



/*String [] t = new String[0];
for(int i=0;i<rs.size();i++) {
    String [] newT = rs.get(i).split("#");
    String [] result = new String[newT.length+t.length];
    System.arraycopy(t, 0, result, 0,  t.length);
    System.arraycopy(newT, 0, result, t.length, newT.length);
    t = result;
}

for(int i=0;i<t.length;i++) {
    System.out.println(t[i]);
}*/