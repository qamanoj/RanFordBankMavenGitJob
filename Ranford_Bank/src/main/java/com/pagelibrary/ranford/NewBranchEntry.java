package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class NewBranchEntry extends Testbase
{
	public static WebElement BranchName_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("branchname")));
	}
	public static WebElement Address1_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("address1")));
	}
	public static WebElement Address2_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("address2")));
	}
	public static WebElement Address3_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("address3")));
	}
	public static WebElement Area_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("area")));
	}
	public static WebElement ZipCode_edit(WebDriver driver)
	{
		return driver.findElement(By.xpath(configOR("zipcode")));
	}
	public static Select Countrynew(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("countrybranchname"))));
	}
	public static Select StateNew(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("statebranchname"))));
	}
	public static Select CityNew(WebDriver driver)
	{
		return new Select(driver.findElement(By.id(configOR("citybranchname"))));
	}
	public static WebElement SubmitBranchButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("submitbranch")));
	}
	public static WebElement ResetBranchButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("resetbranch")));
	}
	public static WebElement CancelBranchButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("cancelbranch")));
	}
}
