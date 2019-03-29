package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UsersDetailsPage 
{
	public static Select Branch_edit(WebDriver driver)
	{
		return new Select(driver.findElement(By.id("lst_branchS")));
	}
	public static Select Roles_edit(WebDriver driver)
	{
		return new Select(driver.findElement(By.id("lst_rolesS")));
	}
	public static WebElement UsersSearchButton(WebDriver driver)
	{
		return driver.findElement(By.id("btn_search"));	
	}
	public static WebElement UsersClearButton(WebDriver driver)
	{
		return driver.findElement(By.id("btn_clear"));	
	}
	public static WebElement NewUserButton(WebDriver driver)
	{
		return driver.findElement(By.id("Btnuser"));	
	}
}
