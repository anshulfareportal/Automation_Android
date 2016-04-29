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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.android.AndroidDriver;
//import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.io.*;
import org.testng.annotations.AfterClass;
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
public class Read_Write_Excel{
	
	Function_File RT = Function_File.getInstance();

	Workbook wb;
	Workbook existingBook;
	Workbook existingBook1;
	WritableWorkbook book;
	WritableWorkbook book1;

	//common line for read and write in exisiting workbook
	File File_Path = new File("C:\\Excel_File\\Test_Data.xls");	
	
		public Sheet Read_Excel_File() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	
					
					//Code to read from existing workbook
							FileInputStream fs = new FileInputStream(File_Path);
							wb = Workbook.getWorkbook(fs);
							Sheet sh = wb.getSheet(0);
							
							return sh;
					
		}
		
		public WritableSheet[] Write_Excel_File(String name) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			
			WritableSheet excel_sheet[] = new WritableSheet[2];
			File New_File_Path;
			File File_Path1 = new File("C:\\Excel_File\\Daily_Sanity_Report_Android.xls");
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			New_File_Path = new File("C:\\Excel_File\\Results\\" + name + timeStamp + ".xls");	
			
			
			
			if(name.equals("Round_Trip"))
				
			{
			
				New_File_Path = new File("C:\\Excel_File\\" + name + ".xls");
				if (New_File_Path.exists()) 
					
				{
			        
			        New_File_Path.delete();
				}

				
			}
			
				
			
			if(name.equals("Car_Booking"))
				
			{
				File_Path = new File("C:\\Excel_File\\Car_Test_Data.xls");	
				New_File_Path = new File("C:\\Excel_File\\" + name + ".xls");
				if (New_File_Path.exists()) 
					
				{
			        
			        New_File_Path.delete();
				}

				
			}
			
			if(name.equals("Air_Check_My_Booking"))
				
			{
				File_Path = new File("C:\\Excel_File\\Round_Trip.xls");	
						
			}
			
			if(name.equals("Car_Check_My_Booking"))
				
			{
				File_Path = new File("C:\\Excel_File\\Car_Booking.xls");	
						
			}
				
					
			
						//Code to write in existing workbook
					
							existingBook = Workbook.getWorkbook(File_Path);
							book = Workbook.createWorkbook(New_File_Path, existingBook);
							excel_sheet[0] = book.getSheet("Sheet1");
							
							existingBook1 = Workbook.getWorkbook(File_Path1);
							book1 = Workbook.createWorkbook(File_Path1, existingBook1);
							excel_sheet[1] = book1.getSheet("Sheet1");
						
							
																
						return excel_sheet;
							
						
					}
		
		public void Instance_Close() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			
			if (book!=null)
				{
				System.out.println("out of sign in varibales");
				
				book.write();
				book.close();
				}


			if (book1!=null)
				{
				System.out.println("out of sign in varibales");
				
				
				book1.write();
				book1.close();
				
				}
				
				if (wb!=null)
				{
				
				wb.close();
				
				}
			
				if (existingBook!=null)
				{
				
					existingBook.close();
				
				}
				
				if (existingBook1!=null)
				{
				
					existingBook1.close();
				
				}
				
					
				
		}
			
	
	
}
