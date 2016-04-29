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
public class Sign_In{
	
	Function_File RT = Function_File.getInstance();
	//Function_File RT = new Function_File();
	//float Ins_Discount;
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();
	
	/**
	 * @param args
	 */
	public void Login() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Sign_In");
		Sheet sh = WR. Read_Excel_File();
		
		//RT.testapp();
		RT.Menu_Navigation();
		Sign_In_Variables Sign_In_Var =  RT.Sign_In_Page();
		 
		 		 
		 if(Sign_In_Var.getSign_Out_Text().equals("Sign Out"))
		 {
			 excel_sheet[0].addCell(new Label(2, 1, "Sign In Sucessfully")); 
		}
		 
		 else
		 {
			 excel_sheet[0].addCell(new Label(2, 1, "Sign In not Sucessfully")); 
		 }
		
				 
		 RT.Sign_Out();
		 RT.Menu_Navigation();
		 Sign_In_Var =  RT.Get_Text_After_Sign_Out();
		 
		 if(Sign_In_Var.getSign_In_Text().equals("Sign In"))
		 {
			 excel_sheet[0].addCell(new Label(3, 1, "Sign In Sucessfully")); 
			 excel_sheet[1].addCell(new Label(4, 8, "Pass")); 
		 }
		 
		 else
		 {
			 excel_sheet[0].addCell(new Label(3, 1, "Sign In not Sucessfully")); 
			 excel_sheet[1].addCell(new Label(4, 8, "Fail")); 
		 }
		 
		 
		 RT.Back_One_Navigation();
	
		  
		

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
