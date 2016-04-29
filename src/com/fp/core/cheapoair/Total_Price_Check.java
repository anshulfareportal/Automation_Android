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
public class Total_Price_Check {
	
	Function_File RT = Function_File.getInstance();
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();

	/**
	 * @param args
	 */
	public void Total_Price_Script() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		WritableSheet excel_sheet[] = WR.Write_Excel_File("Total_Price_check");
		Sheet sh = WR. Read_Excel_File();
		
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
						
						
				excel_sheet[0].addCell(new Label(2, 1, var.getBase_Price()));
				excel_sheet[0].addCell(new Label(3, 1, var.getTaxes()));
				excel_sheet[0].addCell(new Label(4, 1, var.getSub_Total()));
				
				
				String k = var.getInstant_Discount();
				System.out.println(k);
				float Ins_Discount = 0;
				if (k != null)
				{
					excel_sheet[0].addCell(new Label(5, 1, var.getInstant_Discount()));
					
					System.out.println("enter in instant discout value");
					
					 int L_no3 = var.getInstant_Discount().length();
					   String Instant_Discount= var.getInstant_Discount().substring(2,L_no3);
					   var.setInstant_Discount(Instant_Discount);
					   System.out.println(var.getInstant_Discount());
					   Ins_Discount = Float.parseFloat(var.getInstant_Discount());
						System.out.println(Ins_Discount);
					   
				}		
				
							
				excel_sheet[0].addCell(new Label(6, 1, var.getTotal_Price()));
				
				
					int L_no = var.getBase_Price().length();
				   String Base_Price = var.getBase_Price().substring(1,L_no);
				   var.setBase_Price(Base_Price);
				   
					int L_no1 = var.getTaxes().length();
					   String Taxes = var.getTaxes().substring(1,L_no1);
					   var.setTaxes(Taxes);
					   
						int L_no2 = var.getSub_Total().length();
						   String Sub_Total = var.getSub_Total().substring(1,L_no2);
						   var.setSub_Total(Sub_Total);
						   
							
								int L_no4 = var.getTotal_Price().length();
								   String Total_Price = var.getTotal_Price().substring(1,L_no4);
								   var.setTotal_Price(Total_Price);
					   
				float BP = Float.parseFloat(var.getBase_Price());
				float Tax = Float.parseFloat(var.getTaxes());
				float Sub_Tot = Float.parseFloat(var.getSub_Total());
				float Total_Value = Float.parseFloat(var.getTotal_Price());
				
				System.out.println(BP);
				System.out.println(Tax);
				System.out.println(Sub_Tot);
				System.out.println(Total_Value);
				
			
				
				//float BP = tpa.floatRoundOff(Float.parseFloat(prc.getBase_Price()));
				
				/*if((BP + Tax == Sub_Tot) && (Sub_Tot - Ins_Discount) == (Total_Value))
					
				{
				System.out.println("Pass for base");
				excel_sheet[0].addCell(new Label(7, 1, "Pass"));
				excel_sheet[1].addCell(new Label(4, 9, "Pass"));
				}
				
				else
				{
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(7, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 9, "Fail"));
				}*/
				
			if((BP + Tax == Sub_Tot))
				
				{
				System.out.println("Pass for base");
				excel_sheet[0].addCell(new Label(7, 1, "Pass"));
				excel_sheet[1].addCell(new Label(4, 9, "Pass"));
				}
				
				else
				{
					System.out.println("Fail for base");
					excel_sheet[0].addCell(new Label(7, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 9, "Fail"));
				}
				
				if((Sub_Tot - Ins_Discount) == (Total_Value))
					
				{
				System.out.println("Pass for discounr");
				excel_sheet[0].addCell(new Label(7, 1, "Pass"));
				excel_sheet[1].addCell(new Label(4, 9, "Pass"));
				}
				
				else
				{
					System.out.println("Fail for discount");
					excel_sheet[0].addCell(new Label(7, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 9, "Fail"));
				}
	
				var = RT.Travel_Assist_Values();
				excel_sheet[0].addCell(new Label(8, 1, var.getTravel_Assist_Text()));
				excel_sheet[0].addCell(new Label(9, 1, var.getTravel_Assist_Value()));
				excel_sheet[0].addCell(new Label(10, 1, var.getTravel_Assist_Sub_Value()));
				
				
				if(var.getTravel_Assist_Text().equals("$14.95") && var.getTravel_Assist_Value().equals(var.getTravel_Assist_Sub_Value()) && var.getTravel_Assist_Value().equals("$14.95"))
					
				{
				System.out.println("Pass");
				excel_sheet[0].addCell(new Label(11, 1, "Pass"));
				excel_sheet[1].addCell(new Label(4, 10, "Pass"));
				}
				
				else
				{
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(11, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 10, "Fail"));
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
