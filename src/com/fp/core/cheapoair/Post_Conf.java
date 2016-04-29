package com.fp.core.cheapoair;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.android.AndroidDriver;
//import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.io.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.fp.example.Price_Check;
import com.thoughtworks.selenium.Wait;

import static org.testng.Assert.assertEquals;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
@Test
public class Post_Conf {
	WritableWorkbook book;
	WritableWorkbook book1;
	Function_File RT = new Function_File();
	

	/**
	 * @param args
	 */
	public void Round_Trip_Script() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	//common line for read and write in exisiting workbook
		File File_Path = new File("C:\\Excel_File\\Test_Data.xls");	
		File File_Path1 = new File("C:\\Excel_File\\Daily_Sanity_Report_Android.xls");	
						//Code to write in existing workbook
		
				Workbook existingBook = Workbook.getWorkbook(File_Path);
				book = Workbook.createWorkbook(File_Path, existingBook);
				WritableSheet sheet = book.getSheet("Sheet1");
				
				Workbook existingBook1 = Workbook.getWorkbook(File_Path1);
				book1 = Workbook.createWorkbook(File_Path1, existingBook1);
				WritableSheet sheet1 = book1.getSheet("Sheet1");
		
					
				
		
	}
	
	@AfterTest
	public void Instance_Close() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	if (book!=null)
		{
		System.out.println("fdfd");
		
		book.write();
		book.close();
		

		book1.write();
		book1.close();
			
		}
	
	
	}	
	
}
