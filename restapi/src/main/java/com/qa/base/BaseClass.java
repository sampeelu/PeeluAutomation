package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {
	public Properties prop;
	public BaseClass(){

		try {
			prop = new Properties();
			FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(f);

		}catch(FileNotFoundException e) {
			e.printStackTrace();

		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
}
