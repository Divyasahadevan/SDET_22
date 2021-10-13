package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * author @ divya
	 */
	/*
	 * this method is generates random number to avoid duplicates
	 * @return
	 */
	public static String getRandomData() {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
		}
	/**
	 * this method is used to generate the current date 
	 * @return currentdate
	 */
	public static String getCurrentDDate() {
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
	}
	
}
