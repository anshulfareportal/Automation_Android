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
public class Promo_Code_Verification {
	
	Function_File RT = Function_File.getInstance();
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();
	

	/**
	 * @param args
	 */
	public void Promo_Code_Verify() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Promo_Code");
		Sheet sh = WR. Read_Excel_File();

								
					
				String start = sh.getCell(0,1).getContents();
				System.out.println(start);

				
				String destination = sh.getCell(1,1).getContents();
				System.out.println(destination);
		
		
		
				String First_Name = sh.getCell(24,2).getContents();
				String Last_Name = sh.getCell(25,2).getContents();
				String Email_ID = sh.getCell(23,2).getContents();		
				
		
		//RT.testapp();
		RT.Home_Page_Flight();
		RT.Round_Way_Selection();
		//RT.Search_Input(start,destination);
		//RT.Search_Date();
		RT.Search_Function();

		RT.Filter_Page();
		RT.Listing_Page();
		
		RT.Flight_Detail(First_Name,Last_Name,Email_ID);
		

		
		
	RT.Navigation_From_Detail_To_Price();
		Variable_File var = RT.Price_Page();
		
		  /* String l1 = var.getBase_Price();
			System.out.println(l1);
			 String l2 = var.getTaxes();
				System.out.println(l2);
				 String l3 = var.getSub_Total();
					System.out.println(l3);
					 Strin g l4 = var.getInstant_Discount();
						System.out.println(l4);
					String l5 = var.getTotal_Price();
						System.out.println(l5); */
						
						
				
				
				String k = var.getInstant_Discount();
				System.out.println(k);
				float Ins_Discount = 0;
				if (k != null)
				{
					excel_sheet[0].addCell(new Label(2, 1, var.getInstant_Discount()));
					
					System.out.println("enter in instant discout value");
					
					 int L_no3 = var.getInstant_Discount().length();
					   String Instant_Discount= var.getInstant_Discount().substring(2,L_no3);
					   var.setInstant_Discount(Instant_Discount);
					   System.out.println(var.getInstant_Discount());
					   Ins_Discount = Float.parseFloat(var.getInstant_Discount());
						System.out.println(Ins_Discount);
					   
				}		
				
							
				excel_sheet[0].addCell(new Label(3, 1, var.getTotal_Price()));
				
								
				 int L_no4 = var.getTotal_Price().length();
				 String Total_Price = var.getTotal_Price().substring(1,L_no4);
				 var.setTotal_Price(Total_Price);
				   
				float Total_Value = Float.parseFloat(var.getTotal_Price());
				
				
				System.out.println(Total_Value);
				
				
				var = RT.Promo_Code();
				//String Promo_Code_Value = var.getPromo_Code_Text();
				
				float Promo_Code_Value = Float.parseFloat(var.getPromo_Code_Text());
				System.out.println(Promo_Code_Value);
				var = RT.Price_Page();
				
				//String k = var.getInstant_Discount();
				
				float Ins_Discount1 = 0;
				if ((var.getInstant_Discount()) != null)
				{
					excel_sheet[0].addCell(new Label(4, 1, var.getInstant_Discount()));
					
					System.out.println("enter in instant discout value");
					
					 int L_no1 = var.getInstant_Discount().length();
					   String Instant_Discount2= var.getInstant_Discount().substring(2,L_no1);
					   var.setInstant_Discount(Instant_Discount2);
					   System.out.println(var.getInstant_Discount());
					   Ins_Discount1 = Float.parseFloat(var.getInstant_Discount());
						System.out.println(Ins_Discount1);
					   
				}		
				
							
				excel_sheet[0].addCell(new Label(5, 1, var.getTotal_Price()));
				
								
				 int L_no2 = var.getTotal_Price().length();
				 String Total_Price2 = var.getTotal_Price().substring(1,L_no2);
				 var.setTotal_Price(Total_Price2);
				   
				float Total_Value1 = Float.parseFloat(var.getTotal_Price());
				
				
				System.out.println(Total_Value1);
				
				
				
			
				//float BP = tpa.floatRoundOff(Float.parseFloat(prc.getBase_Price()));
				if((Total_Value1) == (Total_Value - Promo_Code_Value) && (Ins_Discount + Promo_Code_Value == Ins_Discount1 ))
				
				{
				System.out.println("Pass");
				excel_sheet[0].addCell(new Label(6, 1, "Pass"));
				excel_sheet[1].addCell(new Label(4, 12, "Pass"));
				}
				
				else
				{
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(6, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 12, "Fail"));
					
					
				}
	
				
				RT.Back_Four_Navigation();
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
