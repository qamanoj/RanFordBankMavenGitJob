package com.pagelibrary.ranford;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Generics
{
	public static  Alert AlertHandel(WebDriver driver)
	{
		return driver.switchTo().alert();	
	}
}
