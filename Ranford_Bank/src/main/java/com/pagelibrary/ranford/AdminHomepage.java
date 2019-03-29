package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.Testbase;

public class AdminHomepage extends Testbase
{
	public static WebElement HomeButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("homebuttonid")));

	}
	public static WebElement ChangePasswordBotton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("changepasswordid")));

	}
	public static WebElement LogoutButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("logoutid")));

	}
	public static WebElement BranchesButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("branches")));

	}
	public static WebElement RolesButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("roles")));

	}
	public static WebElement Usersbutton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("users")));

	}
	public static WebElement Employeebutton(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("employee")));

	} 
}
