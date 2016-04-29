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
public class Car_Check_My_Booking {
	
	
	Function_File RT = Function_File.getInstance();
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();

	/**
	 * @param args
	 */
	
	public void Car_Check_Booking() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Car_Check_My_Booking");
		Sheet sh = WR. Read_Excel_File();
		
		
				String Last_Name = sh.getCell(25,10).getContents();
				String Email_ID = sh.getCell(23,10).getContents();
				
		//RT.testapp();
		 RT.Check_My_Booking(Last_Name,Email_ID);
		RT.Car_Check_My_Trip_Listing();
		RT.Car_Check_Conf_Page();
		Car_Check_Price_Variables Car_Check_Price_Var = RT.Car_Check_Price_Page();
		
		excel_sheet[0].addCell(new Label(2, 3, Car_Check_Price_Var.getCar_Check_Estimate_Price()));
		excel_sheet[0].addCell(new Label(3, 3, Car_Check_Price_Var.getCar_Check_Paid_Price()));
		excel_sheet[0].addCell(new Label(4, 3, Car_Check_Price_Var.getCar_Check_Pending_Price()));
		
		

					
		String Pre_Est_Price = sh.getCell(2,1).getContents();
		String Pre_Paid_Price = sh.getCell(3,1).getContents();
		
		

		
		if((Car_Check_Price_Var.getCar_Check_Estimate_Price().equals(Pre_Est_Price)) &&  (Car_Check_Price_Var.getCar_Check_Paid_Price().equals(Pre_Paid_Price)))
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(5, 3, "Pass"));
		excel_sheet[1].addCell(new Label(4, 16, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(5, 3, "Fail"));
			excel_sheet[1].addCell(new Label(4, 16, "Fail"));
		}
		
		
	RT.Back_Four_Navigation();
	

	}
	@AfterClass	
	public void Close_Instkance () throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		System.out.println("instance close");
		try
		{
			System.out.println("instance close1");
		WR.Instance_Close();
		}catch(Exception e){}
		
	}
	
	
}
