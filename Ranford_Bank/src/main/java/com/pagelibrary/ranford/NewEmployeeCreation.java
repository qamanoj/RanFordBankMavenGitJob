package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class NewEmployeeCreation extends Testbase
{
	public static WebElement EmployeeName_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("employeename")));	
	}
	public static WebElement Loginpassword_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("loginpassword")));	
	}
	public static Select EmployeeRole(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("roleemployee"))));	
	}
	public static Select EmployeeBranch(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("branchemployee"))));	
	}
	public static WebElement SubmitEmployeeButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("submitemployee")));	
	}
	public static WebElement ResetEmployeeButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("resetemployee")));	
	}
	public static WebElement CancelEmployeeButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("cancelemployee")));	
	}
}
