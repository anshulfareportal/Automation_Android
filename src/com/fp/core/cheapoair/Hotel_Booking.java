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
public class Hotel_Booking {
	
	Sub_Date_Field date_fun = new Sub_Date_Field();
	
    Date_Field super_date_fun = new Sub_Date_Field();
	
	Function_File RT = Function_File.getInstance();

	
	
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();

	/**
	 * @param args
	 */
	
	public void Car_Script() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Car_Booking");
		Sheet sh = WR. Read_Excel_File();
		
	

					
					
				String start = sh.getCell(0,1).getContents();
				System.out.println(start);

				
				
				//String First_Name = sh.getCell(24,1).getContents();
			//	String Last_Name = sh.getCell(25,1).getContents();
			//	String Email_ID = sh.getCell(23,1).getContents();
		
		
				
				excel_sheet[0].addCell(new Label(2, 0, "Car Estimate Price"));
				excel_sheet[0].addCell(new Label(3, 0, "Payable Now"));
				excel_sheet[0].addCell(new Label(4, 0, "Status"));
				
	
				date_fun.Date_Function();
				
				
				
RT.Car_Search(start);
RT.Car_Listing();

				
Car_Price_Variable Car_Price_Var = RT.Car_Pricing();
		
		  /* String l1 = var.getBase_Price();
			System.out.println(l1);
			 String l2 = var.getTaxes();
				System.out.println(l2);
				 String l3 = var.getSub_Total();
					System.out.println(l3);
					 String l4 = var.getInstant_Discount();
						System.out.println(l4);
					String l5 = var.getTotal_Price();
						System.out.println(l5); */
						
		
						
				excel_sheet[0].addCell(new Label(2, 1, Car_Price_Var.getEstimate_Price()));
				excel_sheet[0].addCell(new Label(3, 1, Car_Price_Var.getPayable_Now_Price()));
				excel_sheet[1].addCell(new Label(2, 4, Car_Price_Var.getEstimate_Price()));
				
	
		
					//	RT.Promo_Code();
					RT.Car_Travel();
					RT.Payment_Page();
					Post_Conf_Variables Post_Conf_Var = RT.Booking_Conf();
					excel_sheet[0].addCell(new Label(4, 1, Post_Conf_Var.getBooking_No()));
					excel_sheet[1].addCell(new Label(1, 4, Post_Conf_Var.getBooking_No()));
					
					Car_Post_Price_Variable Car_Post_Price_Var = RT.Car_Post_Price();
					excel_sheet[0].addCell(new Label(2, 2, Car_Post_Price_Var.getPost_Estimated_Price()));
					excel_sheet[0].addCell(new Label(3, 2, Car_Post_Price_Var.getPost_Paid_Price()));
		
					
if(Car_Post_Price_Var.getPost_Estimated_Price().equals(Car_Price_Var.getEstimate_Price()) && Car_Post_Price_Var.getPost_Paid_Price().equals(Car_Price_Var.getPayable_Now_Price()))
			
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(4, 1, "Pass"));
		excel_sheet[1].addCell(new Label(4, 4, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(4, 1, "Fail"));
			excel_sheet[1].addCell(new Label(4, 4, "Fail"));
		}
	

		
		System.out.println(Car_Price_Var.getEstimate_Price());
		System.out.println(Car_Price_Var.getPayable_Now_Price());
	
			
	
				
		RT.Back_Two_Navigation();	
		RT.Comman_Back_Function();
		
	}
	
	@AfterClass	
	public void Close_Instance () throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		System.out.println("instance close");
		try
		{
			System.out.println("instance close1");
		WR.Instance_Close();
		}catch(Exception e){}
		
	}
	
}
