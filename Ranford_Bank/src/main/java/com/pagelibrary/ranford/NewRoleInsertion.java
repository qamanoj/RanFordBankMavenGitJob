package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class NewRoleInsertion extends Testbase
{
	public static WebElement RoleName_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("rolename")));
	}
	public static WebElement Roledesc_edit(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("roledesc")));
	}
	public static Select RoleType(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("roletype"))));	
	}
	public static WebElement SubmitRoleButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("submitrole")));
	}
	public static WebElement CancelRoleButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("cancelrole")));
	}
}
