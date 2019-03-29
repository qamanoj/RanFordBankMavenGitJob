package com.pagelibrary.ranford;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import com.base.Testbase;
import com.excel.Excel_class;
import com.utility.Library;
import com.utility.Validation;
import com.webtable.Table;

public class Repository extends Testbase
{	
	public WebDriver driver;
	
	public void Lunch(String MyBrowser)
	{
		if(MyBrowser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();	
		}
		else
		{
			if(MyBrowser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", config("ChromePath"));
				driver=new ChromeDriver();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(config("Build1"));
		
		/*driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(config("Build1"));*/
	}
	public void Login()
	{
		LoginPage.Username_edit(driver).sendKeys(config("username"));
		LoginPage.password_edit(driver).sendKeys(config("password"));
		LoginPage.login_edit(driver).click();
	}
	public void Branches()
	{
		AdminHomepage.BranchesButton(driver).click();
	}
	public void NewBranch(String branchname,String add1,String add2,String add3,String area,String zipcode,String country,String state,String city) throws AWTException, IOException
	{
		BranchDetailsPage.NewBranchButton(driver).click();
		NewBranchEntry.BranchName_edit(driver).sendKeys(branchname);
		NewBranchEntry.Address1_edit(driver).sendKeys(add1);
		NewBranchEntry.Address2_edit(driver).sendKeys(add2);
		NewBranchEntry.Address3_edit(driver).sendKeys(add3);
		NewBranchEntry.Area_edit(driver).sendKeys(area);
		NewBranchEntry.ZipCode_edit(driver).sendKeys(zipcode);
		NewBranchEntry.Countrynew(driver).selectByVisibleText(country);
		NewBranchEntry.StateNew(driver).selectByVisibleText(state);
		NewBranchEntry.CityNew(driver).selectByVisibleText(city);
		NewBranchEntry.SubmitBranchButton(driver).click();

		if(Validation.isAlertPresent(driver, "created Sucessfully"))
		{
			Reporter.log("Test is passed for the branch creation");
		}
		else
		{
			Reporter.log("Test is failed for the branch creation");
			Library.Alertscreenshot("newBranch");
		}
		//Generics.AlertHandel(driver).accept();
	}
	public void BranchSearch(String countryname,String statename,String cityname)
	{
		AdminHomepage.BranchesButton(driver).click();
		BranchDetailsPage.Country(driver).selectByVisibleText(countryname);
		BranchDetailsPage.State(driver).selectByVisibleText(statename);
		BranchDetailsPage.City(driver).selectByVisibleText(cityname);
		BranchDetailsPage.SearchButton(driver).click();
	}
	public void Roles()
	{
		AdminHomepage.RolesButton(driver).click();
	}
	public void NewRole(String rolename,String roledesc,String roletype) throws AWTException, IOException
	{
		RolesDetailsPage.NewRoleButton(driver).click();
		NewRoleInsertion.RoleName_edit(driver).sendKeys(rolename);
		NewRoleInsertion.Roledesc_edit(driver).sendKeys(roledesc);
		NewRoleInsertion.RoleType(driver).selectByVisibleText(roletype);
		NewRoleInsertion.SubmitRoleButton(driver).click();
		if(Validation.isAlertPresent(driver, "New Role with id 203 Created Sucessfully"))
		{
			Reporter.log("Test is passed for the role creation");
		}
		else
		{
			Reporter.log("Test is failed for the role creation");
			Library.Alertscreenshot("NewRole");
		}
		//Generics.AlertHandel(driver).accept();
	}
	public void Employee()
	{
		AdminHomepage.Employeebutton(driver).click();
	}
	public void NewEmployeeCreation(String employeename,String loginpassword,String role,String branch) throws AWTException, IOException
	{
		EmployeeDatilesPage.NewEmployeeButton(driver).click();
		NewEmployeeCreation.EmployeeName_edit(driver).sendKeys(employeename);
		NewEmployeeCreation.Loginpassword_edit(driver).sendKeys(loginpassword);
		NewEmployeeCreation.EmployeeRole(driver).selectByVisibleText(role);
		NewEmployeeCreation.EmployeeBranch(driver).selectByVisibleText(branch);
		NewEmployeeCreation.SubmitEmployeeButton(driver).click();
		if(Validation.isAlertPresent(driver, "New Employer Created1544 Successfully"))
		{
			Reporter.log("Test is passed for the employee creation");
		}
		else
		{
			Reporter.log("Test is failed for the employee creation");
			Library.Alertscreenshot("NewEmployeeCreation");
		}
		//Generics.AlertHandel(driver).accept();
	}
	public void WebTableBranch() throws InterruptedException
	{
		AdminHomepage.BranchesButton(driver).click();
		Thread.sleep(5000);
		Table.webTable(driver, By.id("DG_bankdetails"), "edit", "30");
	}
	public void WebTableRoles() throws InterruptedException
	{
		AdminHomepage.RolesButton(driver).click();
		Table.webTable(driver, By.id("DGRoles"), "edit", "44");
	}
	/*public void WebTableEmployee() throws InterruptedException
	{
		AdminHomepage.Employeebutton(driver).click();
		Thread.sleep(6000);
		Table.webTable(driver, By.id("DGBanker"), "edit", "1788");
	}*/

	public Object[][] Excelcontent(String filename,String sheetname)
	{
		Excel_class.excelconnection(filename, sheetname);

		int rc=Excel_class.rcount();

		int cc=Excel_class.ccount();

		String data[][]=new String[rc-1][cc];

		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{
				data[r-1][c]=Excel_class.readdata(c, r);
			}
		}
		return data;
	}
}
