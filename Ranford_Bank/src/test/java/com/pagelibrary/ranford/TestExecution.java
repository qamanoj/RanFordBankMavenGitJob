package com.pagelibrary.ranford;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.tools.ant.taskdefs.Sync.MyCopy;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.excel.Excel_class;
import com.thoughtworks.selenium.webdriven.commands.GetText;

public class TestExecution extends Repository
{
	@Parameters("MyBrowser")
	@BeforeTest
	public void Lunch_Verify(String MyBrowser)
	{
		Lunch(MyBrowser);
	}
	@Test(priority=0)
	public void Login_Verify()
	{
		Login();
	}
	@Test(priority=1)
	public void Branches_Verify()
	{
		Branches();
	}
	/*@Test(priority=2,dataProvider="BranchData")
	public void NewBranch_Verify(String branchname,String add1,String add2,String add3,String area,String zipcode,String country,String state,String city) throws AWTException, IOException
	{
		NewBranch(branchname,add1,add2,add3,area,zipcode,country,state,city);
	}*/
	/*@Test(priority=3,dataProvider="BranchSearchData")
	public void BranchSearch_Verify(String countryname,String statename,String cityname)
	{
		BranchSearch(countryname,statename,cityname);
	}*/
	@Test(priority=4)
	public void Roles_Verify()
	{
		Roles();
	}
	/*@Test(priority=5,dataProvider="RoleData")
	public void NewRole_Verify(String rolename,String roledesc,String roletype) throws AWTException, IOException
	{
		NewRole(rolename,roledesc,roletype);
	}*/
	@Test(priority=6)
	public void Employee_Verify()
	{
		Employee();
	}
	/*@Test(priority=7,dataProvider="EmployeeData")
	public void NewEmployeeCreation_Verify(String employeename,String loginpassword,String role,String branch) throws AWTException, IOException
	{
		NewEmployeeCreation(employeename,loginpassword,role,branch);
	}*/

	//for webtable verify
	@Test(priority=8)
	public void WebTableBranch_verify() throws InterruptedException
	{
		WebTableBranch();
	}
	@Test(priority=9)
	public void WebTableRole_verify() throws InterruptedException
	{
		WebTableRoles();
	}

	//with using dataprovider

	/*@DataProvider(name="BranchData")
	public Object[][] verify_Branch_Excel()
	{
		return Excelcontent("data.xls", "Sheet1");
	}*/

	/*@DataProvider(name="RoleData")
	public Object[][] verify_Role_Excel()
	{
		return Excelcontent("data.xls", "Sheet2");
	}*/

	/*@DataProvider(name="EmployeeData")
	public Object[][] verify_Employee_Excel()
	{
		return Excelcontent("data.xls", "Sheet3");
	}*/

	/*@DataProvider(name="BranchSearchData")
	public Object[][] verify_BranchSearch_Excel()
	{
		return Excelcontent("data.xls", "Sheet4");
	}*/

	//without using data provider
	@Test(priority=2)
	public void verifybranchwrite() throws Throwable
	{
		Excel_class.excelconnection("data.xls", "Sheet1");
		Excel_class.outputexcelconnection("data.xls", "outputdata1.xls", "Sheet1");

		for(int i=1;i<Excel_class.rcount();i++)
		{
			NewBranch(Excel_class.readdata(0, i), Excel_class.readdata(1, i), Excel_class.readdata(2, i), Excel_class.readdata(3, i), Excel_class.readdata(4, i), Excel_class.readdata(5, i), Excel_class.readdata(6, i), Excel_class.readdata(7, i), Excel_class.readdata(8, i));

			String text=driver.switchTo().alert().getText();

			Generics.AlertHandel(driver).accept();

			int j=Excel_class.ccount();

			if(text.contains("created Sucessfully"))
			{
				Excel_class.writedata(j++, i, "Test Passed");

			}
			else if(text.contains("already Exist"))
			{
				Excel_class.writedata(j++, i, "Test failed");

			}
			else
			{
				Excel_class.writedata(j++, i, "not aplicable");

			}
		}
		Excel_class.savaworkbook();
	}

	@Test(priority=5)
	public void verifyroleswrite() throws AWTException, IOException
	{
		Excel_class.excelconnection("data.xls", "Sheet2");
		Excel_class.outputexcelconnection("data.xls", "outputdata2.xls", "Sheet2");

		for(int i=1;i<Excel_class.rcount();i++)
		{
			NewRole(Excel_class.readdata(0, i),Excel_class.readdata(1, i),Excel_class.readdata(2, i));

			String text=driver.switchTo().alert().getText();

			Generics.AlertHandel(driver).accept();

			int j=Excel_class.ccount();

			if(text.contains("New Role with id"))
			{
				Excel_class.writedata(j++, i, "Test Passed");

			}
			else if(text.contains("Role Already"))
			{
				Excel_class.writedata(j++, i, "Test failed");

			}
			else
			{
				Excel_class.writedata(j++, i, "not aplicable");

			}
		}	
		Excel_class.savaworkbook();
	}


	@Test(priority=7)
	public void verifyemployeewrite() throws AWTException, IOException
	{
		Excel_class.excelconnection("data.xls", "Sheet3");
		Excel_class.outputexcelconnection("data.xls", "outputdata3.xls", "Sheet3");

		for(int i=1;i<Excel_class.rcount();i++)
		{
			NewEmployeeCreation(Excel_class.readdata(0, i),Excel_class.readdata(1, i),Excel_class.readdata(2, i),Excel_class.readdata(3, i));

			String text=driver.switchTo().alert().getText();

			Generics.AlertHandel(driver).accept();

			int j=Excel_class.ccount();

			if(text.contains("New Employer Created"))
			{
				Excel_class.writedata(j++, i, "Test Passed");
			}
			else if(text.contains("Already Existed"))
			{
				Excel_class.writedata(j++, i, "Test failed");
			}
			else
			{
				Excel_class.writedata(j++, i, "not aplicable");
			}
		}	
		Excel_class.savaworkbook();
	}
}
