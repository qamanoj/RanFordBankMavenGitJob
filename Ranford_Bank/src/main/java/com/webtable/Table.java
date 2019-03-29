package com.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table 
{
	static boolean flag = false;

	public static void webTable(WebDriver driver,By prop, String operation, String id)
	{
		boolean status=true;

		WebElement table = driver.findElement(prop);

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		String pagelinks[] = rows.get(rows.size() - 1).getText().split(" ");

		for (int i = 1; i < pagelinks.length; i++) 
		{
			table = driver.findElement(prop);
			rows = table.findElements(By.tagName("tr"));

			for (WebElement row : rows) 
			{
				List<WebElement> cols = row.findElements(By.tagName("td"));

				for (WebElement col : cols) 
				{
					if (col.getText().matches(id)) 
					{
						if (operation.equalsIgnoreCase("edit"))
						{
							cols.get(cols.size() -2).findElement(By.tagName("a")).click();
						}
						else if (operation.equalsIgnoreCase("delete")) 
						{
							cols.get(cols.size()-1) .findElement(By.tagName("a")).click();
						}
						else 
						{
							System.out.println("Wrong operation entered");
						}
						flag = true;
						break;
					} 
				}
				if (flag == true) 
				{
					break;
				}
			}
			if (flag == true) 
			{
				break;
			}
			try
			{
				if(pagelinks[i].contains("...") && status==true)
				{
					driver.findElement(By.xpath("//a[text()='...'][2]")).click();
				}
				else
				{
					table.findElement(By.linkText(pagelinks[i])).click();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(pagelinks[i].contains("..."))
			{
				status=true;
				webTable(driver, prop, operation, id);
			}
		}
	}
}

