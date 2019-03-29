package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Testbase 
{
	public static Properties property;

	public static void loadproperty()
	{
		try 
		{
			File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\confglibrary\\confg.properties");

			FileReader fr=new FileReader(f);

			property=new Properties();

			property.load(fr);	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	public String config(String key)
	{
		loadproperty();
		String x=property.getProperty(key);
		return x;

	}
	
	public static void loadpropertyOR() 
	{
		try 
		{
			File fil=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\confglibrary\\OR.properties");
			
			FileReader fl=new FileReader(fil);
			
			property=new Properties();
			
			property.load(fl);
		}
		catch (Exception e)
		{
		
			e.printStackTrace();
		} 
	}
	public static  String configOR(String str) 
	{
		loadpropertyOR();
		String y=property.getProperty(str);
		return y;
	}
}
