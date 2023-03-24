package com.obsqura.utiities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities{
	WebDriver driver;
	public void clearAndEnterText(WebElement element,String text) {
		element.clear();
	element.sendKeys(text);
	}
	public void clearAndEnterText(WebElement element,CharSequence[] i) {
		element.click();
		element.clear();
	element.sendKeys(i);
	}
	public void selecttextfromDropdownList(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	public void acceptingAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void dismissingAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void mouseHoverInElements(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	public void refreshUtility(WebDriver driver) {
		driver.navigate().refresh();
		}
	
	}

