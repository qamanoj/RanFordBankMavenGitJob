package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Validation 
{
	public static boolean b;
	
	public static TakesScreenshot driver;
	
	public static boolean isTitlePresent(WebDriver  driver,String ExpectedResult)
	{
		driver.getTitle().contains(ExpectedResult);
		return b;
	}
	public static boolean isTestPresent(WebDriver  driver,String ExpectedResult)
	{
		b=driver.findElement(By.tagName("tbody")).getText().contains(ExpectedResult);
		return b;
	}
	public static boolean isAlertPresent(WebDriver  driver,String ExpectedResult)
	{
		b=driver.switchTo().alert().getText().contains(ExpectedResult);
		return b;
	}	
}
