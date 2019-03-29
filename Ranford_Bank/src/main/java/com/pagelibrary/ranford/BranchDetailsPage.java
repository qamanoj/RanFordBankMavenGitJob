package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class BranchDetailsPage extends Testbase
{
	public static Select Country(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("country"))));
	}
	public static Select State(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("state"))));	
	}
	public static Select City(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("city"))));	
	}
	public static WebElement SearchButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("search")));
	}
	public static WebElement ClearButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("clear")));	
	}
	public static WebElement NewBranchButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("newbranch")));	
	}
}
