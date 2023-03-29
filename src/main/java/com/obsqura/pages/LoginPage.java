package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.WaitUtilities;

public class LoginPage {
	WebDriver driver;
	WaitUtilities waitu=new WaitUtilities ();
	GenericUtilities genericu=new  GenericUtilities();
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath = "/html/body/div[2]/header/nav/div/ul/li[2]")
	WebElement profile;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/logout']")
	WebElement signout;
	@FindBy(xpath="//input[@name='remember']")
    WebElement rememberme;
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[3]/div/div/label/input")
	WebElement checkbox;
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[1]/div/span/strong") 
	WebElement invalidmessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginWithvalidLoginCredentials(String usrnme, String paswd) {
		username.sendKeys(usrnme);
		password.sendKeys(paswd);
		login.click();

	}

	public String islogOutworking(String usrname, String paswrd) {
		username.sendKeys(usrname);
		password.sendKeys(paswrd);
		genericu.clickOnElement(login);
		genericu.clickOnElement(endtour);
		waitu.waitforelementtobeClickable(driver, profile);
		genericu.clickOnElement(profile);
		genericu.clickOnElement(signout);
		String title = driver.getTitle();
		return title;

	}

	public void loginWithInvalidLoginCredentials(String usrnme, String paswd) {
		username.sendKeys(usrnme);
		password.sendKeys(paswd);
		genericu.clickOnElement(login);
	}

	public String invalidLoginMessageIsDisplaying() {

		invalidmessage.isDisplayed();
		invalidmessage.getText();
		System.out.println(invalidmessage.getText());
        return invalidmessage.getText();

	}

}
