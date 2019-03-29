package com.pagelibrary.ranford;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Testbase;

public class RolesDetailsPage extends Testbase
{
	public static WebElement NewRoleButton(WebDriver driver)
	{
		return driver.findElement(By.id(configOR("newrole")));
	}
}
