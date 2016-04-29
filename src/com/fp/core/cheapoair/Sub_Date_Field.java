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
public class Sub_Date_Field extends Date_Field{
	Function_File RT = Function_File.getInstance();
	
	WebDriver dr = Function_File.WebDriver_Instance();
	
	//Read_Write_Excel WR = new Read_Write_Excel();

	

	/**
	 * @param args
	 */
	public void Date_Functionyryfr() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		System.out.println("i gdfgdfgdf am svvxvxub");
		dr.findElement(By.name("Check-in")).click();
	}
	
	
	
	public void Date_Function() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		Date_Function();
		System.out.println("i am sub");
		dr.findElement(By.name("Check-in")).click();
	}
	
	public void Date_Functionyryr() throws MalformedURLException, InterruptedException, BiffException, IOException, Exception {
		System.out.println("i am svvxvxub");
		dr.findElement(By.name("Check-in")).click();
	}
	
	
/*	public  static void main(String args[]) throws MalformedURLException, BiffException, InterruptedException, IOException, Exception
	{
		Sub_Date_Field gd = new Sub_Date_Field();
		gd.Date_Function();
		System.out.println("fsfsfsd");
	super.Date_Function();
		
	}*/
	
}
