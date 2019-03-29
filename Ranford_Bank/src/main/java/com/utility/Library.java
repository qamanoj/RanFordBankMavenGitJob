package com.utility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Library 
{
	public static void onTestFailure(String screenshortname)
	{
		File scrFile = ((TakesScreenshot)Validation.driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(scrFile, new File("./target/Screenshot"+screenshortname+".png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		public static void Alertscreenshot(String screenshotname) throws AWTException, IOException
		{
			Robot r=new Robot();
			
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle re=new Rectangle(d);
			BufferedImage bi=r.createScreenCapture(re);
			
			ImageIO.write(bi, "jpg", new File("./target/Screenshot"+screenshotname+".png"));	
		}
	}


