package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel_class
{
	public static String folderpath="./ExcelFile/";

	static Workbook wb;
	static Sheet sh;
	static WritableWorkbook wwb;
	static WritableSheet wws;

	public static void excelconnection(String filename,String sheetname)
	{
		try
		{
			File file=new File(folderpath+filename);
			wb=Workbook.getWorkbook(file);
			sh=wb.getSheet(sheetname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int rcount()
	{
		int r=sh.getRows();
		return r;
	}
	public static int ccount()
	{
		int c=sh.getColumns();
		return c;
	}
	public static String readdata(int col,int row)
	{
		String x=sh.getCell(col, row).getContents();
		return x;
	}


	//write data into Excel

	public static void outputexcelconnection(String ifilename,String ofilename,String isheetname)
	{
		try 
		{
			FileInputStream fis=new FileInputStream(folderpath+ifilename);

			wb=Workbook.getWorkbook(fis);

			sh=wb.getSheet(isheetname);

			FileOutputStream fos=new FileOutputStream(folderpath+ofilename);

			wwb=Workbook.createWorkbook(fos,wb);

			wws=wwb.getSheet(isheetname);
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		} 
	}

	public static void writedata(int col,int row,String data)
	{
		try 
		{
			Label l=new Label(col, row, data);

			wws.addCell(l);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void savaworkbook()
	{
		try 
		{
			wwb.write();

			wwb.close();

			wb.close();
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
}
