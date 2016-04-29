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
public class Round_Trip {
	Function_File RT = Function_File.getInstance();
	
	//Function_File RT = new Function_File();
	WebDriver dr = Function_File.WebDriver_Instance();
	//WebDriver dr = RT.WebDriver_Instance();
	Read_Write_Excel WR = new Read_Write_Excel();
	
	
	/**
	 * @param args
	 */
	
	public void Round_Trip_Script() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {

		WritableSheet excel_sheet[] = WR.Write_Excel_File("Round_Trip");
		Sheet sh = WR. Read_Excel_File();
		
		
		
	//	dr.findElement(By.name("From")).click();
		
					
		int random_num = RT.Random_Number();
		
				String start = sh.getCell(0,random_num).getContents();
				System.out.println(start);

				
				String destination = sh.getCell(1,random_num).getContents();
				System.out.println(destination);
				
				String First_Name = sh.getCell(24,1).getContents();
				String Last_Name = sh.getCell(25,1).getContents();
				String Email_ID = sh.getCell(23,1).getContents();
		
				
				excel_sheet[0].addCell(new Label(2, 0, "Base Price"));
				excel_sheet[0].addCell(new Label(3, 0, "Taxes"));
				excel_sheet[0].addCell(new Label(4, 0, "Sub_Total"));
				excel_sheet[0].addCell(new Label(5, 0, "Instant Discount"));
				excel_sheet[0].addCell(new Label(6, 0, "Total_Price"));
				excel_sheet[0].addCell(new Label(7, 0, "Booking No"));
				
							
				excel_sheet[0].addCell(new Label(2, 3, "Traveler Name At Post Booking"));
				excel_sheet[0].addCell(new Label(3, 3, "Seat Type"));
				excel_sheet[0].addCell(new Label(4, 3, "Meal Type"));
				excel_sheet[0].addCell(new Label(5, 3, "Additional Services"));
				
				excel_sheet[0].addCell(new Label(10, 0, "Booking With Middle Name"));
				excel_sheet[0].addCell(new Label(11, 0, "Additional Travelers Details"));
				excel_sheet[0].addCell(new Label(12, 0, "Third Party Check"));
				excel_sheet[0].addCell(new Label(13, 0, "Post Booking Price Match"));
			
		System.out.println("calling test app");
		//RT.testapp();
		System.out.println("starting RP");
		RT.Home_Page_Flight();
RT.Search_Input(start,destination);

Date_Field date_var = new Date_Field();
	date_var.Date_Function();
//RT.Search_Date();
RT.Search_Function();
//RT.Search_Input("nyc","phl");

		RT.Filter_Page();
		RT.Listing_Page();
		
		RT.Flight_Detail(First_Name,Last_Name,Email_ID);
		RT.Middle_Name();
		RT.Additional_Traveler_Details();
		RT.Navigation_From_Detail_To_Price();
				
		Variable_File Price_Var = RT.Price_Page();
		
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
						
		
						
				excel_sheet[0].addCell(new Label(2, 1, Price_Var.getBase_Price()));
				excel_sheet[0].addCell(new Label(3, 1, Price_Var.getTaxes()));
				excel_sheet[0].addCell(new Label(4, 1, Price_Var.getSub_Total()));
				
				
				
				String k = Price_Var.getInstant_Discount();
				System.out.println(k);
				if (k != null)
				{
					excel_sheet[0].addCell(new Label(5, 1, Price_Var.getInstant_Discount()));
					System.out.println("enter in instant discout value");
				}		
				
							
				excel_sheet[0].addCell(new Label(6, 1, Price_Var.getTotal_Price()));
				excel_sheet[1].addCell(new Label(2, 2, Price_Var.getTotal_Price()));
				
				System.out.println(Price_Var.getTotal_Price());

	
		
					//	RT.Promo_Code();
					RT.Navigation_From_Price_To_Payment();
					RT.Payment_Page();
					Post_Conf_Variables Post_Conf_Var = RT.Booking_Conf();
					excel_sheet[0].addCell(new Label(7, 1, Post_Conf_Var.getBooking_No()));
					excel_sheet[1].addCell(new Label(1, 2, Post_Conf_Var.getBooking_No()));
					RT.Navigation_From_Book_Conf_To_Traveler();
					Post_Traveler_Variables Post_Traveler_Var = RT.Additional_Traveler_Details_Post_Booking();
					excel_sheet[0].addCell(new Label(2, 4, Post_Traveler_Var.getTraveler_Name_Post_Booking()));
					excel_sheet[0].addCell(new Label(3, 4, Post_Traveler_Var.getSeat_Post_Booking()));
					excel_sheet[0].addCell(new Label(4, 4, Post_Traveler_Var.getMeal_Post_Booking()));
					excel_sheet[0].addCell(new Label(5, 4, Post_Traveler_Var.getAdditonal_Traveler_Post_Booking()));
					System.out.println("Adding");
					
		System.out.println(Post_Traveler_Var.getTraveler_Name_Post_Booking());
		System.out.println(Post_Traveler_Var.getSeat_Post_Booking());
		System.out.println(Post_Traveler_Var.getMeal_Post_Booking());
		System.out.println(Post_Traveler_Var.getAdditonal_Traveler_Post_Booking());
		System.out.println(Price_Var.getTotal_Price());
		
if((Post_Traveler_Var.getTraveler_Name_Post_Booking()).equals(First_Name + " " + "M" + " " + Last_Name))
			
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(10, 1, "Pass"));
		excel_sheet[1].addCell(new Label(4, 5, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(10, 1, "Fail"));
			excel_sheet[1].addCell(new Label(4, 5, "Fail"));
		}
	
		if((Post_Traveler_Var.getTraveler_Name_Post_Booking()).equals(First_Name + " " + "M" + " " + Last_Name) && (Post_Traveler_Var.getSeat_Post_Booking()).equals("Aisle Seat") && (Post_Traveler_Var.getMeal_Post_Booking()).equals("Plain") && (Post_Traveler_Var.getAdditonal_Traveler_Post_Booking()).equals("Blind Passenger"))
			
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(11, 1, "Pass"));
		excel_sheet[1].addCell(new Label(4, 15, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(11, 1, "Fail"));
			excel_sheet[1].addCell(new Label(4, 15, "Fail"));
		}
		
			
		if(!(Post_Traveler_Var.getTraveler_Name_Post_Booking()).equals("Eric West"))
			
		{
		System.out.println("Pass");
		excel_sheet[0].addCell(new Label(12, 1, "Pass"));
		excel_sheet[1].addCell(new Label(4, 6, "Pass"));
		}
		
		else
		{
			System.out.println("Fail");
			excel_sheet[0].addCell(new Label(12, 1, "Fail"));
			excel_sheet[1].addCell(new Label(4, 6, "Fail"));
		}
	
			
		RT.Back_From_Conf_Travler();
		RT.Navigation_From_Book_Conf_To_Price();
		Post_Price_Variables Post_Price_Var = RT.Post_Price_Page();
		
		excel_sheet[0].addCell(new Label(2, 2, Post_Price_Var.getPost_Base_Price()));
		excel_sheet[0].addCell(new Label(3, 2, Post_Price_Var.getPost_Taxes()));
		excel_sheet[0].addCell(new Label(4, 2, Post_Price_Var.getPost_Sub_Total()));
		excel_sheet[0].addCell(new Label(5, 2, Post_Price_Var.getPost_Instant_Discount()));
		excel_sheet[0].addCell(new Label(6, 2, Post_Price_Var.getPost_Total_Price()));
		
		System.out.println(Post_Price_Var.getPost_Base_Price());
		System.out.println(Post_Price_Var.getPost_Taxes());
		System.out.println(Post_Price_Var.getPost_Sub_Total());
		System.out.println(Post_Price_Var.getPost_Instant_Discount());
		System.out.println(Post_Price_Var.getPost_Total_Price());
		
			
		if((Price_Var.getInstant_Discount()) != null)
		{
			System.out.println("enter in first if");
				if(Price_Var.getBase_Price().equals(Post_Price_Var.getPost_Base_Price()) && Price_Var.getTaxes().equals(Post_Price_Var.getPost_Taxes()) && Price_Var.getSub_Total().equals(Post_Price_Var.getPost_Sub_Total()) && Price_Var.getInstant_Discount().equals(Post_Price_Var.getPost_Instant_Discount()) && Price_Var.getTotal_Price().equals(Post_Price_Var.getPost_Total_Price()))
				{System.out.println("enter in 2nd if");
					System.out.println("Pass");
					excel_sheet[0].addCell(new Label(13, 1, "Pass"));
					excel_sheet[1].addCell(new Label(4, 2, "Pass"));
				}
				
				else
				{System.out.println("enter in 2nd else");
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(13, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 2, "Fail"));
				}
				
		}	
			
			else
			{
				System.out.println("enter in first else");
				if(Price_Var.getBase_Price().equals(Post_Price_Var.getPost_Base_Price()) && Price_Var.getTaxes().equals(Post_Price_Var.getPost_Taxes()) && Price_Var.getSub_Total().equals(Post_Price_Var.getPost_Sub_Total()) && Price_Var.getTotal_Price().equals(Post_Price_Var.getPost_Total_Price()))
				{System.out.println("enter in 3rd if");
					System.out.println("Pass");
					excel_sheet[0].addCell(new Label(13, 1, "Pass"));
					excel_sheet[1].addCell(new Label(4, 2, "Pass"));
				}
				
				else
					
				{System.out.println("enter in 3rd else");
					System.out.println("Fail");
					excel_sheet[0].addCell(new Label(13, 1, "Fail"));
					excel_sheet[1].addCell(new Label(4, 2, "Fail"));
				}
				
			}	
				
		RT.Back_Three_Navigation();	
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
