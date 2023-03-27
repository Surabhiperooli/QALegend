package com.obsqura.utiities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class GenericUtilities {
	

	
	public static String getRandomNumber()
	{
		Random random= new Random();
		int number=random.nextInt(1000);
		return String.valueOf(number);
	}
	public String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, Math.min(uuid.length(), 10));
        System.err.println(uuid);
        return uuid;
    }  
 
	public static String getTimeStamp()
	{
		 String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0));
		 return timeStamp;
	}
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}
	public String getAttributeOfElement(WebElement element)
	{
		return element.getAttribute("innerText");
	}
	public boolean is_TextAsExpected(WebElement element, String expectedtext)
	{
		String text = element.getText();
		return text.equals(expectedtext);
	}
}