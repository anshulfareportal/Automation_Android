package com.fp.core.cheapoair;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//import java.util.NoSuchElementException;
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
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.io.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//import com.fp.core.cheapoair.Varible_File;
import com.thoughtworks.selenium.Wait;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


@Test
public class Function_File {

 //private static final String[] scrollObject = null;
	static WebDriver dr; 
	DesiredCapabilities capabilities;
	
	
	private Function_File()
	
	{
		dr = null;
		capabilities = null;
		
	}
	

	//@BeforeTest
	@Test(priority = 0)
	public void testapp() throws MalformedURLException, InterruptedException {
		
		String contact = "1jyot";
				
		//File classpathRoot = new File(System.getProperty("use.dir"));
		//File appDir = new File(classpathRoot, "/app");
		//File app = new File(appDir, "CheapoAir_AirHotel_3.0.15.apk");
		File app = new File("D:\\Appium_Automation\\application-cheapoair-3.1.10.apk");
		capabilities= new DesiredCapabilities();
		capabilities.setCapability("browserName", "");
	//	capabilities.setCapability("deviceName","lge-nexus_5-067004340ac6415c");
		//capabilities.setCapability("deviceName","motorola-nexus_6-ZX1G428LBP");
		capabilities.setCapability("deviceName","samsung-sm_n910g-641dd802");
		
		//capabilities.setCapability("deviceName","641dd802");	
		//	capabilities.setCapability("platformVersion","4.4.4");
		capabilities.setCapability("platformVersion","5.0.1");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app",app.getAbsolutePath());
		capabilities.setCapability("apppackage","com.fp.cheapoair");
		
	
		//capabilities.setCapability("appActivity","com.fp.cheapoair.Air.View.FlightSearch.TravelersDetailsScreen");
		//capabilities.setCapability("appActivity","com.fp.cheapoair.CheapOair");
		capabilities.setCapability("appActivity","com.fp.cheapoair.CheapOair");
		//capabilities.setCapability("lastOpenedActivity","com.fareportal.application.air.controller.AirListingScreenController");
		//capabilities.setCapability("appActivity","com.fareportal.application.air.controller.AirListingScreenController");
		
		//capabilities.setCapability("appWaitActivity",".Cheapoair");
	dr = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//	dr = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
		System.out.println("fsghhhghjghjghjgf");
		
			try
			{
			dr.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout[@index='0']")).click();
			
			}catch(Exception e)
			{
				
			}
		}	
	
	
private static Function_File test = null;
	
	public static Function_File  getInstance()
	{
		if (test == null)
		{
			try
			{
				test = new Function_File();
				test.testapp();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			return test;
		}
		
		return test;
	}
	
	
	public static WebDriver WebDriver_Instance()
	{
		if (dr== null)
		{
			
			try
			{
				test = new Function_File();
				test.testapp();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else
		{
			return dr;
		}
		
		return dr;
			
		
	}
	@Test(priority = 1)
	
	public void Hide_Keyboard() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	try
	{
		((AppiumDriver) dr).hideKeyboard();
	} catch(Exception e){
		
		System.out.println("Enter in exception part");
						}
	
	}
	
	
	public void Home_Page_Flight() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
		dr.findElement(By.name("Flights")).click();
					
				}
	public int Random_Number() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	Random rndnum = new Random();
	int Low = 1;
	int High = 50;
	int random_num = rndnum.nextInt(High-Low) + Low;
	System.out.println(random_num);
	
	return random_num;
	
	}
	public void Search_Input(String start,String destination) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
				
		dr.findElement(By.name("From")).click();
		 dr.findElement(By.xpath("//android.widget.EditText[@text='Enter Airport']")).sendKeys(start);
		 dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
		 dr.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout[1]")).click();
		  dr.findElement(By.xpath("//android.widget.EditText[@text='Enter Airport']")).sendKeys(destination);
		  dr.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout[1]")).click();
		 		  
		}
	
	public void Search_Date() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
			dr.findElement(By.id("com.fp.cheapoair:id/next_month")).click();
		  dr.findElement(By.id("com.fp.cheapoair:id/next_month")).click();
		  dr.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
		  dr.findElement(By.xpath("//android.widget.TextView[@text='18']")).click();
	 
		}
	
public void Search_Date(String One_Way) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	dr.findElement(By.id("com.fp.cheapoair:id/air_search_segment_depart_date_layout")).click();
		dr.findElement(By.id("com.fp.cheapoair:id/next_month")).click();
	  dr.findElement(By.id("com.fp.cheapoair:id/next_month")).click();
	  dr.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
	  
	  
	}
	
	public void Search_Function() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	
	  dr.findElement(By.name("Search Flights")).click();
	  
	}

	
	public void Round_Way_Selection() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		  dr.findElement(By.name("Round Trip")).click();
		  
		}
		
	
	public void One_Way_Selection() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	  dr.findElement(By.name("One Way")).click();
	  
	}
	
		
	public void Filter_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
	
		
		dr.findElement(By.name("FILTERS")).click();
		   dr.findElement(By.name("AIRLINE")).click();
		 
	 
	 
	  List<WebElement> items=dr.findElements(By.xpath("//android.support.v7.widget.RecyclerView"));
	  System.out.println(items.size());
	 	  
	  for(int x = 0;x<=items.size();x++)
		   
	  {
		 System.out.println(x);
		   String a =   dr.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + x + "]/android.widget.TextView")).getText();
		   System.out.println(a);
		   if(a.equals("American Airlines"))
		{
		
			   dr.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + x + "]/android.widget.CheckBox")).click();
				  
		
			
			  break;

		}
		 
		
	  }
	  
	  dr.findElement(By.name("Apply Filters")).click();
	      


	}

	
	
	public void Listing_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		 
		dr.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		dr.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='1']/*")).click();

	
		}
	
	public void Flight_Detail(String First_Name,String Last_Name, String Email_ID) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
		
		//Wait.until(ExpectedConditions.dr.findElement(By.name("Travelers")));
		 
		dr.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		dr.findElement(By.name("Flight Details"));
		
		
		((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		
		dr.findElement(By.id("com.fp.cheapoair:id/firstNameTextView")).sendKeys(First_Name);
		dr.findElement(By.id("com.fp.cheapoair:id/lastNameTextView")).sendKeys(Last_Name);
		Hide_Keyboard();
		
		String Previous_Travlers = dr.findElement(By.xpath("//android.widget.RelativeLayout[@index=1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
		
	if(Previous_Travlers.equals("Previous Travelers"))
	
	{
		
		dr.findElement(By.xpath("//android.widget.LinearLayout[@index='4']/android.widget.RelativeLayout[@index='0']")).click();
		//dr.findElement(By.id("com.fp.cheapoair:id/base_custom_picker_button_drawable")).click();
		
		
		dr.findElement(By.name("OK")).click();
		dr.findElement(By.xpath("//android.widget.LinearLayout[@index='4']/android.widget.RelativeLayout[@index='1']")).click();
		//dr.findElement(By.id("com.fp.cheapoair:id/base_custom_picker_button_dropdown")).click();
		
		
		dr.findElement(By.name("Male")).click();
	
		Dimension screenSize = dr.manage().window().getSize();
	    Double screenWidth = Double.valueOf(String.valueOf(screenSize.getWidth())) / 2;
	    Double screenHeight = Double.valueOf(String.valueOf(screenSize.getHeight())) / 2;
	    
	    System.out.println(screenWidth);
	    System.out.println(screenHeight);
	 	
	}
	else
	{
		dr.findElement(By.xpath("//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']")).click();
		//dr.findElement(By.id("com.fp.cheapoair:id/base_custom_picker_button_drawable")).click();
		
		
		dr.findElement(By.name("OK")).click();
		dr.findElement(By.xpath("//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='1']")).click();
		//dr.findElement(By.id("com.fp.cheapoair:id/base_custom_picker_button_dropdown")).click();
		
		
		dr.findElement(By.name("Male")).click();
	}
}
	

	public void Additional_Traveler_Details() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		dr.findElement(By.id("com.fp.cheapoair:id/additionalrequestcustomtextview")).click();
		dr.findElement(By.name("Seat Pref.")).click();
		dr.findElement(By.name("Aisle Seat")).click();
		dr.findElement(By.name("Meal Pref.")).click();
		dr.findElement(By.name("Plain")).click();
		dr.findElement(By.name("Special Services")).click();
		dr.findElement(By.name("Blind Passenger")).click();
		}
	
	public void Middle_Name() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		dr.findElement(By.id("com.fp.cheapoair:id/middleNameTextView")).sendKeys("M");
		Hide_Keyboard();
		
		}
	
	public void Navigation_From_Detail_To_Price() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		dr.findElement(By.name("Continue to Next Step")).click();
		}
	
	
	public Variable_File Price_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		 
		dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
		 Variable_File Price_Var = new Variable_File();
		 dr.findElement(By.name("Review"));
		 ((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		 ((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		 ((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			//((AppiumDriver) dr).swipe(400, 100, 400, 600,1000);
	     System.out.println("gjggjjinsurance");	 
	     Price_Var.setBase_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_two")).getText());
	     Price_Var.setTaxes(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_three")).getText());
	     Price_Var.setSub_Total(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_four")).getText());
	    
	    try
		
		{
			dr.findElement(By.name("Total Discount"));
			Price_Var.setInstant_Discount(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_discount_value_text_view_light")).getText());
																	//present = true;
			
		} catch (NoSuchElementException e) {
			//present = false;
		}
	     
	       
	    Price_Var.setTotal_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_total_charge_value_text_view_light")).getText());
		  
	 
		
	    
	    // int L_no = var.getBase_Price().length();
		 //  String Base_Price = var.getBase_Price().substring(1,L_no);
		//   var.setBase_Price(Base_Price);
		   
		//   int L_no1 = var.getTaxes().length();
		//   String Taxes = var.getTaxes().substring(1,L_no1);
		//   var.setTaxes(Taxes);
		   
		//   int L_no2 = var.getProtection().length();
		//   String Protection = var.getProtection().substring(1,L_no2);
		//   var.setProtection(Protection);
		   
		  // int L_no3 = var.getInstant_Discount().length();
		 //  String Instant_Discount = var.getInstant_Discount().substring(1,L_no3);
		 //  var.setInstant_Discount(Instant_Discount);
		   
	//	   String l1 = var.getBase_Price();
	//System.out.println(l1);
	// String l2 = var.getTaxes();
	//	System.out.println(l2);
	//	 String l3 = var.getProtection();
	//		System.out.println(l3);
		//	 String l4 = var.getInstant_Discount();
			//	System.out.println(l4);
	    
	    return Price_Var;
		}
	
	
public Variable_File Travel_Assist_Values() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		
		((AppiumDriver) dr).swipe(400, 600, 400, 1200, 1000);
		((AppiumDriver) dr).swipe(400, 600, 400, 1200, 1000);
		Variable_File var = new Variable_File();
		 var.setTravel_Assist_Text(dr.findElement(By.id("com.fp.cheapoair:id/air_price_review_travel_safe_add_travel_assist_price_textview")).getText());
		dr.findElement(By.id("com.fp.cheapoair:id/air_price_review_travel_safe_add_travel_assist_checkbox")).click();
		((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		var.setTravel_Assist_Value(dr.findElement(By.xpath("//android.widget.TableRow[@index='3']/android.widget.TextView[@index='1']")).getText());
		var.setTravel_Assist_Sub_Value(dr.findElement(By.xpath("//android.widget.TableRow[@index='3']/android.widget.TextView[@index='3']")).getText());
		
	return var;
		
		}
	
	public Variable_File Promo_Code() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
		//((AppiumDriver) dr).swipe(435, 396, 112, 496, 900);
		//((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
		Variable_File var = new Variable_File();
	
		String Promo_Code_Presnt_Text = dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_info_link_promo_code_text_view")).getText();
		
		if(Promo_Code_Presnt_Text.equals("Enter Promo Code"))
		{
			dr.findElement(By.name("Enter Promo Code")).click();
		}
		
		else
		{
			dr.findElement(By.name("Got a Promo Code?")).click();
		}
		
		
		
		// dr.findElement(By.className("android.widget.EditText")).sendKeys("ny15");
		 dr.findElement(By.xpath("//android.widget.EditText")).sendKeys("ny15"); 
		 dr.findElement(By.name("Submit")).click();
		 var.setPromo_Code_Text(dr.findElement(By.id("android:id/message")).getText());
		 System.out.println(var.getPromo_Code_Text());
		 String [] Promo_Code_Text = var.getPromo_Code_Text().split("\\$");
		System.out.println(Promo_Code_Text[0]);
		System.out.println(Promo_Code_Text[1]);
		 var.setPromo_Code_Text(Promo_Code_Text[1]);
		 dr.findElement(By.name("OK")).click();
		return var;
		
		}
	
		public Variable_File Navigation_From_Price_To_Payment() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		
			Variable_File var = new Variable_File();
			var.setNavigation_Button_Name(dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).getText());
			String i = var.getNavigation_Button_Name();
			
			
			if (var.getNavigation_Button_Name().equals("Continue to Next Step"))
			{
		    System.out.println("enter in if");
				dr.findElement(By.name("Continue to Next Step")).click();
			}
			
			else
			{
				System.out.println("enter in else");
				dr.findElement(By.name("Continue to Final Step")).click();
				
			}
			
			System.out.println("End of navigation");
			return var;
		
			}
		
		public void Payment_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			System.out.println("start of payment");
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_card_number")).sendKeys("4222222222222");
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_card_holders_name")).sendKeys("eric west");
			Hide_Keyboard();
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_card_cvv")).sendKeys("123");
			//dr.findElement(By.name("Card Type*")).click();
			//dr.findElement(By.name("VISA")).click();
			
			dr.findElement(By.id("com.fp.cheapoair:id/base_custom_picker_button_label")).click();
			dr.findElement(By.name("OK")).click();
					

			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_address_line_one")).sendKeys("123 main street");
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_city")).sendKeys("new york");
			Hide_Keyboard();
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_zip")).sendKeys("10001");
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_country")).click();
			
			dr.findElement(By.name("United States")).click();
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_state")).click();
			//dr.findElement(By.xpath("//android.widget.ListView/android.widget.TextView[@index='26']")).click();
			 
			//System.out.println("Before Scroll");	
			//((AppiumDriver) dr).swipe(400, 600, 700, 800, 1000);
			
			System.out.println("scroll1");
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			System.out.println("scroll2");
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			//((AppiumDriver) dr).swipe(400, 600, 700, 400, 1000);
			//System.out.println("scroll1");
			//((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			//System.out.println("scroll2");
			//((AppiumDriver) dr).swipe(400, 600, 800, 100, 1000);
			//((AppiumDriver) dr).swipe(400, 1000, 1500, 100, 1000);
		//	((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);
			//((AppiumDriver) dr).swipe(400, 600, 400, 100, 1000);		
			dr.findElement(By.name("NY - NEW YORK, US")).click();
			 
			
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_billing_phone_number")).sendKeys("2124780325");
			Hide_Keyboard();
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_email_edit_text")).sendKeys("anshuljain@fareportal.com");
			Hide_Keyboard();
			dr.findElement(By.id("com.fp.cheapoair:id/air_flight_payment_details_email_confirm_edit_text")).sendKeys("anshuljain@fareportal.com");
			Hide_Keyboard();
			dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
			//dr.findElement(By.name("Book Now")).click();
			
				}
		
		public Post_Conf_Variables Booking_Conf() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			
			dr.manage().timeouts().implicitlyWait(12000,TimeUnit.SECONDS);
			Post_Conf_Variables Post_Conf_Var = new Post_Conf_Variables();
			Post_Conf_Var.setBooking_No(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_custom_confirmation_header_description_text_view")).getText());
			String [] Booking_No = Post_Conf_Var.getBooking_No().split(" ");
			String Actual_Booking_No = Booking_No[3].trim(); 
			Post_Conf_Var.setBooking_No(Actual_Booking_No);
			return Post_Conf_Var;
		
			}
		
		public void Navigation_From_Book_Conf_To_Traveler() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			System.out.println("Enter in conf listing.");
			dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_trip_summary_air_flight_details_cell_expanding_view")).click();
			dr.findElement(By.name("Traveler Details")).click();
			dr.manage().timeouts().implicitlyWait(1200,TimeUnit.SECONDS);
			
				
			}
		
		public void Navigation_From_Book_Conf_To_Price() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
			System.out.println("Enter in conf listing.");
			dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_trip_summary_air_flight_details_cell_expanding_view")).click();
			dr.findElement(By.name("Price Details")).click();
			dr.manage().timeouts().implicitlyWait(1200,TimeUnit.SECONDS);
			
				
			}
		
public Post_Traveler_Variables Additional_Traveler_Details_Post_Booking() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Post_Traveler_Variables Post_Traveler_Var = new Post_Traveler_Variables();
	
	Post_Traveler_Var.setTraveler_Name_Post_Booking(dr.findElement(By.xpath("//android.widget.TableLayout[@index=1]/android.widget.TableRow[@index=0]/android.widget.TextView[@index=1]")).getText());
	System.out.println(Post_Traveler_Var.getTraveler_Name_Post_Booking());
		
	Post_Traveler_Var.setSeat_Post_Booking(dr.findElement(By.xpath("//android.widget.TableLayout[@index=4]/android.widget.TableRow[@index=0]/android.widget.TextView[@index='1']")).getText());
	System.out.println(Post_Traveler_Var.getSeat_Post_Booking());
	
	Post_Traveler_Var.setMeal_Post_Booking(dr.findElement(By.xpath("//android.widget.TableLayout[@index=4]/android.widget.TableRow[@index=1]/android.widget.TextView[@index='1']")).getText());
	System.out.println(Post_Traveler_Var.getMeal_Post_Booking());
	
	Post_Traveler_Var.setAdditonal_Traveler_Post_Booking(dr.findElement(By.xpath("//android.widget.TableLayout[@index=4]/android.widget.TableRow[@index=2]/android.widget.TextView[@index='1']")).getText());
	System.out.println(Post_Traveler_Var.getAdditonal_Traveler_Post_Booking());
	
	return Post_Traveler_Var;

	}

public Post_Price_Variables Post_Price_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Post_Price_Variables Post_Price_Var = new Post_Price_Variables();
	
	dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	 
	Post_Price_Var.setPost_Base_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_two")).getText());
	Post_Price_Var.setPost_Taxes(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_three")).getText());
	Post_Price_Var.setPost_Sub_Total(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_four")).getText());
    
    try
	
	{
		dr.findElement(By.name("Total Discount"));
		Post_Price_Var.setPost_Instant_Discount(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_discount_value_text_view_light")).getText());
		//present = true;
		
	} catch (NoSuchElementException e) {
		//present = false;
	}
     
       
    Post_Price_Var.setPost_Total_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_total_charge_value_text_view_light")).getText());
	  
 
    return Post_Price_Var;
	
	

	}
		


public void Back_From_Conf_Travler() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();


	}
		

public void Check_My_Booking(String Last_Name,String Email_ID) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	dr.findElement(By.name("My Trips")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_login_screen_email_edit_text")).sendKeys(Email_ID);
	dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_login_screen_last_name_edit_text")).sendKeys(Last_Name);
	dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_login_screen_phone_zip_edit_text")).sendKeys("0325");
	((AppiumDriver) dr).hideKeyboard();
	dr.findElement(By.name("Submit")).click();

	
	}

public void Check_My_Trip_Listing() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_flight_cell_view")).click();

	}

public void Car_Check_My_Trip_Listing() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	dr.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout")).click();

	}

public void Check_Conf_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_trip_summary_air_flight_details_cell_expanding_view")).click();
	dr.findElement(By.name("Price Details")).click();
	

	}
		
public void Car_Check_Conf_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.findElement(By.name("Price Details")).click();
	

	}
	

public Check_Price_Variables Check_Price_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Check_Price_Variables Check_Price_Var = new Check_Price_Variables();
	
	dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	 
	Check_Price_Var.setCheck_Base_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_two")).getText());
	Check_Price_Var.setCheck_Taxes(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_three")).getText());
	Check_Price_Var.setCheck_Sub_Total(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_table_row_column_four")).getText());
    
    try
	
	{
		dr.findElement(By.name("Total Discount"));
		Check_Price_Var.setCheck_Instant_Discount(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_discount_value_text_view_light")).getText());
		/*int L_no3 = Check_Price_Var.getCheck_Instant_Discount().length();
		   String Check_Instant_Discount= Check_Price_Var.getCheck_Instant_Discount().substring(2,L_no3);
		   Check_Price_Var.setCheck_Instant_Discount(Check_Instant_Discount);*/
		//present = true;
		
	} catch (NoSuchElementException e) {
		//present = false;
	}
     
       
    Check_Price_Var.setCheck_Total_Price(dr.findElement(By.id("com.fp.cheapoair:id/bookingdetails_price_details_total_charge_value_text_view_light")).getText());
	  
 /*	int L_no = Check_Price_Var.getCheck_Base_Price().length();
	String Check_Base_Price = Check_Price_Var.getCheck_Base_Price().substring(1,L_no);
	Check_Price_Var.setCheck_Base_Price(Check_Base_Price);


	int L_no1 = Check_Price_Var.getCheck_Taxes().length();
   String Check_Taxes = Check_Price_Var.getCheck_Taxes().substring(1,L_no1);
   Check_Price_Var.setCheck_Taxes(Check_Taxes);


	int L_no2 = Check_Price_Var.getCheck_Sub_Total().length();
	   String Check_Sub_Total = Check_Price_Var.getCheck_Sub_Total().substring(1,L_no2);
	   Check_Price_Var.setCheck_Sub_Total(Check_Sub_Total);
	
		
		   
		   int L_no4 = Check_Price_Var.getCheck_Total_Price().length();
			   String Check_Total_Price = Check_Price_Var.getCheck_Total_Price().substring(1,L_no4);
			   Check_Price_Var.setCheck_Total_Price(Check_Total_Price);*/
		
       return Check_Price_Var;
	
	

	}


public Car_Check_Price_Variables Car_Check_Price_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Car_Check_Price_Variables Car_Check_Price_Var = new Car_Check_Price_Variables();
	
	dr.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	 
	Car_Check_Price_Var.setCar_Check_Estimate_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_sub_total_amount")).getText());
	Car_Check_Price_Var.setCar_Check_Paid_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_payable_amount")).getText());
	Car_Check_Price_Var.setCar_Check_Pending_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_payable_amount_at_rental")).getText());
    
    return Car_Check_Price_Var;
	
	

	}


public void Back_From_Check_Price() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	dr.findElement(By.xpath("//android.widget.ImageButton")).click();
	

	}

public void Back_One_Navigation() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.navigate().back();
	

	}

public void Back_Two_Navigation() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.navigate().back();
	dr.navigate().back();

	}
public void Back_Three_Navigation() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.navigate().back();
	dr.navigate().back();
	dr.navigate().back();
	

	}

public void Back_Four_Navigation() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	dr.navigate().back();
	dr.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS);
	dr.navigate().back();
	dr.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS);
	dr.navigate().back();
	dr.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS);
	dr.navigate().back();
	
	dr.navigate().back();
	
	//dr.navigate().back();
	}

public void Comman_Back_Function() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {

	try
	{
		dr.findElement(By.id("com.fp.cheapoair:id/home_screen_options_panel")).isDisplayed();
	 
	
	}catch(NoSuchElementException e)
	
	{
		 dr.navigate().back();
		 Comman_Back_Function();
	}
	
}


public void Menu_Navigation() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	
	
  dr.findElement(By.xpath("//android.view.ViewGroup/android.widget.ImageButton")).click();

  File ScrFile= ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(ScrFile,new File("C:\\Excel_File\\abc.jpg"));
}


public Sign_In_Variables Sign_In_Page() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Sign_In_Variables Sign_In_Var = new Sign_In_Variables();
	System.out.println("where i am");
  
	
	//if(dr.findElement(By.id("com.fp.cheapoair:id/menu_screen_signed_in_profile_name")).equals("Hello, Test Tester!"))
		//if(dr.findElement(By.name("Sign In")).getText().equals("Sign In")

	//boolean bool = dr.findElement(By.name("Sign In")).getText().equals("Sign In");
	
	//if(dr.findElement(By.name("Sign In")).getText().equals("Sign In"))

		//if(dr.findElement(By.name("Sign In")).isDisplayed())
try
	{
  
	dr.findElement(By.name("Sign In")).click();
  //dr.findElement(By.id("com.fp.cheapoair:id/editText_login_email_id")).sendKeys("anshul20@fareportal.com");
 // dr.findElement(By.id("com.fp.cheapoair:id/editText_login_password")).sendKeys("test1234");
  dr.findElement(By.id("com.fp.cheapoair:id/editText_login_email_id")).sendKeys("anshuljain@fareportal.com");
  dr.findElement(By.id("com.fp.cheapoair:id/editText_login_password")).sendKeys("test1234");

  Hide_Keyboard();
  dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
   dr.findElement(By.id("com.fp.cheapoair:id/menu_screen_signed_in_arrow_down_icon")).click();
   Sign_In_Var.setSign_Out_Text(dr.findElement(By.id("com.fp.cheapoair:id/signed_menu_fragment_signout_textview")).getText());
	System.out.println("where i am too");
   
  }catch(Exception e)
  {
	  dr.findElement(By.id("com.fp.cheapoair:id/menu_screen_signed_in_arrow_down_icon")).click();
  }
	System.out.println("where i am toooo");

  return Sign_In_Var;
}

public Sign_In_Variables Add_Co_Travler() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Sign_In_Variables Sign_In_Var = new Sign_In_Variables();
	dr.findElement(By.name("My Account")).click();
   dr.findElement(By.name("Co-Travelers")).click();
 
  List<WebElement> items=dr.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
  System.out.println(items.size());
  Sign_In_Var.setTraveler_Count_Before_Creation(items.size());
  
  dr.findElement(By.id("com.fp.cheapoair:id/ll_co_traveler_add")).click();
  dr.findElement(By.name("Title*")).click();
  dr.findElement(By.name("Mr.")).click();
  
  dr.findElement(By.id("com.fp.cheapoair:id/user_prsnlInfo_fName")).sendKeys("Eric");
  dr.findElement(By.id("com.fp.cheapoair:id/user_prsnlInfo_lName")).sendKeys("Robinson");
  dr.findElement(By.id("com.fp.cheapoair:id/user_prsnlInfo_dob")).click();
  dr.findElement(By.name("OK")).click();
  dr.findElement(By.id("com.fp.cheapoair:id/user_prsnlInfo_gender")).click();
  dr.findElement(By.name("Male")).click();
  dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
  Sign_In_Var.setAdd_Co_Traveler_Message(dr.findElement(By.id("android:id/message")).getText());
  dr.findElement(By.name("OK")).click();

  List<WebElement> item=dr.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
  System.out.println(item.size());
  Sign_In_Var.setTraveler_Count_After_Creation(item.size());
   
  System.out.println(item.size());
 for(int x = 0;x<=items.size();x++)
	   
   {
	 System.out.println(x);
	   String a =   dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[@index=" + x + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
		//
	  //String a =   dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[@index=" + x + "]/android.widget.TextView")).getText();
	// String a =   dr.findElement(By.id("com.fp.cheapoair:id/tv_coTravelersListName")).getText();
	   System.out.println(a);
	System.out.println(x);
   }

  
 return Sign_In_Var;

}


public Sign_In_Variables Del_Co_Travler() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Sign_In_Variables Sign_In_Var = new Sign_In_Variables();
	
	dr.findElement(By.name("My Account")).click();
	   dr.findElement(By.name("Co-Travelers")).click();
	 
 
 
  List<WebElement> items=dr.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
  System.out.println(items.size());
  Sign_In_Var.setTraveler_Count_Before_Creation(items.size());
  dr.findElement(By.id("com.fp.cheapoair:id/ll_co_traveler_remove")).click();
  
  for(int x = 0;x<=items.size();x++)
	   
  {
	 System.out.println(x);
	   String a =   dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[@index=" + x + "]/android.widget.LinearLayout/android.widget.LinearLayout[@index='1']/android.widget.TextView")).getText();
	   
	  if(a.equals("Eric Robinson"))
	{
	
		dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[@index=" + x + "]/android.widget.LinearLayout/android.widget.LinearLayout[@index='0']")).click();
		
	
		dr.findElement(By.name("DELETE")).click();

							
		Sign_In_Var.setAdd_Co_Traveler_Message(dr.findElement(By.id("android:id/message")).getText());
		System.out.println(Sign_In_Var.getAdd_Co_Traveler_Message());  
		dr.findElement(By.name("OK")).click();
		dr.findElement(By.id("com.fp.cheapoair:id/ll_co_traveler_remove")).click(); 
		List<WebElement> item=dr.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
		  System.out.println("Total Size" +item.size());
		  Sign_In_Var.setTraveler_Count_After_Creation(item.size());
		  break;

}
	 
	
  }
      
 return Sign_In_Var;

}





public Sign_In_Variables Get_Text_After_Sign_Out() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Sign_In_Variables Sign_In_Var = new Sign_In_Variables();
 
   Sign_In_Var.setSign_In_Text(dr.findElement(By.id("com.fp.cheapoair:id/base_menu_panel_text")).getText());
   
   return Sign_In_Var;

}
public void Sign_Out() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	    dr.findElement(By.name("Sign Out")).click();
	  	dr.findElement(By.name("OK")).click();
	  	
	 
	}

public Feedback_Variables Feedback() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Feedback_Variables Feedback_Var = new Feedback_Variables();
 
  dr.findElement(By.name("Feedback")).click();
  dr.findElement(By.id("com.fp.cheapoair:id/feedback_screen_email_edit_text")).sendKeys("anshuljain@fareportal.com");
  dr.findElement(By.id("com.fp.cheapoair:id/feedback_screen_full_name_edit_text")).sendKeys("test tester");
 
  dr.findElement(By.id("com.fp.cheapoair:id/feedback_message_edit_text")).sendKeys("This is test feedback. Please Ignore");
   Hide_Keyboard(); 
  dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
  Feedback_Var.setFeedback_Message(dr.findElement(By.id("android:id/message")).getText());
  System.out.println(Feedback_Var.getFeedback_Message());
  dr.findElement(By.name("OK")).click();

  return Feedback_Var;

}

public void Car_Search(String start) throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	dr.findElement(By.name("Cars")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/car_srch_pickup_icon")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/car_location_selection_screen_autoCompleteTextView")).sendKeys("phl");
	dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[1]")).click();
	 
	dr.findElement(By.id("com.fp.cheapoair:id/car_tvl_date_calendar_icon_pickup")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/nextMonth")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/nextMonth")).click();
	dr.findElement(By.xpath("//android.widget.GridView/android.widget.RelativeLayout[6]")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/return_label")).click();
	dr.findElement(By.xpath("//android.widget.GridView/android.widget.RelativeLayout[7]")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
	
	dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
	
  
	}

public void Car_Listing() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	dr.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[1]")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
 
	}

public Car_Price_Variable Car_Pricing() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Car_Price_Variable Car_Price_Var = new Car_Price_Variable();
	
	Car_Price_Var.setEstimate_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_sub_total_amount")).getText());
	Car_Price_Var.setPayable_Now_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_payable_amount")).getText());
	dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();

	return Car_Price_Var;	

}


public void Car_Travel() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	dr.findElement(By.id("com.fp.cheapoair:id/car_trvl_det_detail_first_name")).sendKeys("maria");
	dr.findElement(By.id("com.fp.cheapoair:id/car_trvl_det_detail_last_name")).sendKeys("cano");
	Hide_Keyboard();
	dr.findElement(By.id("com.fp.cheapoair:id/base_call_to_action_label")).click();
	
}

public Car_Post_Price_Variable Car_Post_Price() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	Car_Post_Price_Variable Car_Post_Price_Var = new Car_Post_Price_Variable();
	
	dr.findElement(By.name("Price Details")).click();
	Car_Post_Price_Var.setPost_Estimated_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_sub_total_amount")).getText());
	Car_Post_Price_Var.setPost_Paid_Price(dr.findElement(By.id("com.fp.cheapoair:id/car_prc_tv_payable_amount")).getText());
	
	return Car_Post_Price_Var;

}


public void Flight_Status_Home() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
	
	//Car_Post_Price_Variable Car_Post_Price_Var = new Car_Post_Price_Variable();
	
	dr.findElement(By.name("Flight Status")).click();
	dr.findElement(By.name("By Flight #")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/autocompletetextview_air_flight_status_airline")).sendKeys("aeromexico");
	dr.findElement(By.id("com.fp.cheapoair:id/flight_status_screen_flight_number_edit_text")).click();
	dr.findElement(By.id("com.fp.cheapoair:id/flight_status_screen_flight_number_edit_text")).sendKeys("491");
	Hide_Keyboard();
	dr.findElement(By.name("Check Now")).click();
	


}
	

		public void Driver_Close() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
				System.out.println("quit dri");
			if(dr!=null)
			{
				dr.quit();
			}
		}

	
		
		
		
		
	
}




