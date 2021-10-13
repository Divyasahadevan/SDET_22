package com.crm.vtiger.GenericUtils;



	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

	public class FileUtility {
		/**
		 * Generic Method
		 * @author divya
		 * @param key
		 * @return
		 * @throws Throwable
		 */
		
		public String getPropertyKeyValue(String key) throws Throwable {
			FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
			Properties p = new Properties();
			p.load(file);
			return p.getProperty(key);
		}
		
		public String readDataFromProperty(String key) throws Throwable {
			FileInputStream fis=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
			Properties pobj = new Properties();
			pobj.load(fis);
			String value = pobj.getProperty("username").toString();
			return value;
			
			
		}
		public String getDataFromJson(String jsonKey) throws Throwable {
			FileReader r=new FileReader(IPathConstant.JSONFILEPATH);
			JSONParser jp=new JSONParser();
			Object object = jp.parse(r);
			JSONObject jobj=(JSONObject)object;
			String value = jobj.get(jsonKey).toString();
			return value;
		}
		
		
		public String readDataFromJson(String jsonKey) throws Throwable {
			
			FileReader r=new FileReader(IPathConstant.JSONFILEPATH);
			JSONParser jp=new JSONParser();
			Object object = jp.parse(r);
			JSONObject jobj=(JSONObject)object;
			String value = jobj.get(jsonKey).toString();
			return value;
			
			
		}
	}
		


	

