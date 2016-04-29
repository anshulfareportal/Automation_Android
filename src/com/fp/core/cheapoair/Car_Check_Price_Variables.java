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
import java.util.Iterator;
import java.util.List;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import static org.testng.Assert.assertEquals;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
@Test
public class Car_Check_Price_Variables {
	
		String Car_Check_Estimate_Price;
		String Car_Check_Paid_Price;
		String Car_Check_Pending_Price;
		
		public String getCar_Check_Estimate_Price() {
			return Car_Check_Estimate_Price;
		}
		public void setCar_Check_Estimate_Price(String car_Check_Estimate_Price) {
			Car_Check_Estimate_Price = car_Check_Estimate_Price;
		}
		public String getCar_Check_Paid_Price() {
			return Car_Check_Paid_Price;
		}
		public void setCar_Check_Paid_Price(String car_Check_Paid_Price) {
			Car_Check_Paid_Price = car_Check_Paid_Price;
		}
		public String getCar_Check_Pending_Price() {
			return Car_Check_Pending_Price;
		}
		public void setCar_Check_Pending_Price(String car_Check_Pending_Price) {
			Car_Check_Pending_Price = car_Check_Pending_Price;
		}
	
				   
}
