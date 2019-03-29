package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Testbase;

public class EmployeeDatilesPage extends Testbase
{
	public static WebElement NewEmployeeButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("newemployee")));	
	}
}
