package cambiapractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDatFromPropertFile {


	@Test
	public void readDataFromPropertFileNew() throws IOException {
		//read the data from property file
		//step1: get the java representation object of the physical file

		FileInputStream fis=new FileInputStream("./Data/CommoData.prperties");
		//step2: create object of the properties class annd load all the key value pair
		Properties p=new Properties();
		p.load(fis);
		//step3:read the value using getproperty("key")
		String URL=p.getProperty("url");
		String BROWSER=p.getProperty("browser");
		String US=p.getProperty("username");
		String PW=p.getProperty("password");
		System.out.println( URL);
		System.out.println(BROWSER);
		System.out.println(US);
		System.out.println(PW);
	}

}
