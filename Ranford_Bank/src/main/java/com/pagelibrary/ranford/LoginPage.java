package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Testbase;

public class LoginPage extends Testbase
{	
	public static WebElement Username_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("usernameid")));
	}
	public static WebElement password_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("passwordid")));
	}
	public static WebElement login_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("loginid")));
	}
}
