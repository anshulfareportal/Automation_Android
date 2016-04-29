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
public class Sign_In_Variables{
	
	String Sign_In_Text;
	String Sign_Out_Text;
	String Add_Co_Traveler_Message;
	int Traveler_Count_Before_Creation;
	int Traveler_Count_After_Creation;
	
	public int getTraveler_Count_Before_Creation() {
		return Traveler_Count_Before_Creation;
	}

	public void setTraveler_Count_Before_Creation(int traveler_Count_Before_Creation) {
		Traveler_Count_Before_Creation = traveler_Count_Before_Creation;
	}

	public int getTraveler_Count_After_Creation() {
		return Traveler_Count_After_Creation;
	}

	public void setTraveler_Count_After_Creation(int traveler_Count_After_Creation) {
		Traveler_Count_After_Creation = traveler_Count_After_Creation;
	}

	public String getAdd_Co_Traveler_Message() {
		return Add_Co_Traveler_Message;
	}

	public void setAdd_Co_Traveler_Message(String add_Co_Traveler_Message) {
		Add_Co_Traveler_Message = add_Co_Traveler_Message;
	}

	public String getSign_In_Text() {
		return Sign_In_Text;
	}

	public void setSign_In_Text(String sign_In_Text) {
		Sign_In_Text = sign_In_Text;
	}



	public String getSign_Out_Text() {
		return Sign_Out_Text;
	}

	public void setSign_Out_Text(String sign_Out_Text) {
		Sign_Out_Text = sign_Out_Text;
	}
	
				   
}
