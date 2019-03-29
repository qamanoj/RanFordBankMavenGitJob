package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewUserCreation 
{
	public static Select UserRole(WebDriver driver)
	{
		return new Select(driver.findElement(By.id("lst_branchS")));
	}
	public static Select UserBranch(WebDriver driver)
	{
		return new Select(driver.findElement(By.id("lst_branchS")));
	}
	public static Select UserCustomerID(WebDriver driver)
	{
		return new Select(driver.findElement(By.id("lst_branchS")));
	}
	public static WebElement CustomerName_edit(WebDriver driver)
	{
		return driver.findElement(By.id("Lbc_name"));	
	}
	public static WebElement UserName_edit(WebDriver driver)
	{
		return driver.findElement(By.id("txtUname"));	
	}
	public static WebElement LoginPassword_edit(WebDriver driver)
	{
		return driver.findElement(By.id("txtLpwd"));	
	}
	public static WebElement TransactionPassword_edit(WebDriver driver)
	{
		return driver.findElement(By.id("txtTpwd"));	
	}
	public static WebElement UserSubmitButton(WebDriver driver)
	{
		return driver.findElement(By.id("BtnSubmit"));	
	}
	public static WebElement UserResetButton(WebDriver driver)
	{
		return driver.findElement(By.id("btnreset"));	
	}
	public static WebElement UserCancelButton(WebDriver driver)
	{
		return driver.findElement(By.id("btnCancel"));	
	}
}
