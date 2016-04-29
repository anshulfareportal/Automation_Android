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
public class Check_My_Booking {
	
	Function_File RT = Function_File.getInstance();
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();

	/**
	 * @param args
	 */
	
	public void Check_Booking() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Air_Check_My_Booking");
		Sheet sh = WR. Read_Excel_File();
		
		
				String Last_Name = sh.getCell(25,1).getContents();
				String Email_ID = sh.getCell(23,1).getContents();
				
		//RT.testapp();
		 RT.Check_My_Booking(Last_Name,Email_ID);
		RT.Check_My_Trip_Listing();
		RT.Check_Conf_Page();
		Check_Price_Variables Check_Price_Var = RT.Check_Price_Page();
		
		excel_sheet[0].addCell(new Label(2, 5, Check_Price_Var.getCheck_Base_Price()));
		excel_sheet[0].addCell(new Label(3, 5, Check_Price_Var.getCheck_Taxes()));
		excel_sheet[0].addCell(new Label(4, 5, Check_Price_Var.getCheck_Sub_Total()));
		excel_sheet[0].addCell(new Label(6, 5, Check_Price_Var.getCheck_Total_Price()));
		

		String k = Check_Price_Var.getCheck_Instant_Discount();
		System.out.println(k);
		if (k != null)
		{
			excel_sheet[0].addCell(new Label(5, 5, Check_Price_Var.getCheck_Instant_Discount()));
			System.out.println("enter in instant discout value");
			//Ins_Discount  = Float.parseFloat(Check_Price_Var.getCheck_Instant_Discount());
				
		}		

		
		
//float BP = Float.parseFloat(Check_Price_Var.getCheck_Base_Price());
//float Tax = Float.parseFloat(Check_Price_Var.getCheck_Taxes());
//float Sub_Tot = Float.parseFloat(Check_Price_Var.getCheck_Sub_Total());
//float Total_Value = Float.parseFloat(Check_Price_Var.getCheck_Total_Price());



/*System.out.println(BP);
System.out.println(Tax);
System.out.println(Sub_Tot);
System.out.println(Total_Value);


System.out.println(Ins_Discount);
System.out.println(BP + Tax);
System.out.println((Sub_Tot - Ins_Discount));*/
	
			
		String Pre_BP = sh.getCell(2,1).getContents();
		String Pre_Tax = sh.getCell(3,1).getContents();
		String Pre_Sub_Tot = sh.getCell(4,1).getContents();
		String Pre_Ins_Dis = sh.getCell(5,1).getContents();
		System.out.println(Pre_Ins_Dis);
		String Pre_Total = sh.getCell(6,1).getContents();


		if (k != null)
		{
		if((Check_Price_Var.getCheck_Base_Price().equals(Pre_BP) &&  (Check_Price_Var.getCheck_Taxes().equals(Pre_Tax)) && Check_Price_Var.getCheck_Sub_Total().equals(Pre_Sub_Tot) && Check_Price_Var.getCheck_Instant_Discount().equals(Pre_Ins_Dis) &&(Check_Price_Var.getCheck_Total_Price().equals(Pre_Total))))
			
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(7, 5, "Pass"));
		excel_sheet[1].addCell(new Label(4, 11, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(7, 5, "Fail"));
			excel_sheet[1].addCell(new Label(4, 11, "Fail"));
		}
		
		}
		
		else
		{
			if((Check_Price_Var.getCheck_Base_Price().equals(Pre_BP) &&  (Check_Price_Var.getCheck_Taxes().equals(Pre_Tax)) && Check_Price_Var.getCheck_Sub_Total().equals(Pre_Sub_Tot) && (Check_Price_Var.getCheck_Total_Price().equals(Pre_Total))))
				
			{
			System.out.println("Pass");
			excel_sheet[0].addCell(new Label(7, 5, "Pass"));
			excel_sheet[1].addCell(new Label(4, 11, "Pass"));
			}
			
			else
			{
				System.out.println("Fail");
				excel_sheet[0].addCell(new Label(7, 5, "Fail"));
				excel_sheet[1].addCell(new Label(4, 11, "Fail"));
			}
		}
			
	RT.Back_From_Check_Price();
	
	
		
		
		
		
		
	/*	if((BP + Tax == Sub_Tot) &&  (Sub_Tot - Ins_Discount) == (Total_Value))
				
				{
				System.out.println("Pass");
				excel_sheet[0].addCell(new Label(7, 5, "Pass"));
				excel_sheet[1].addCell(new Label(4, 11, "Pass"));
				}
				
				else
				{
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(7, 5, "Fail"));
					excel_sheet[1].addCell(new Label(4, 11, "Fail"));
				}
			RT.Back_From_Check_Price();*/

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
