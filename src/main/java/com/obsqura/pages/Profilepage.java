package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class Profilepage extends com.obsqura.utiities.PageUtilities{
	WebDriver driver;
	PageUtilities pageu=new PageUtilities();
	WaitUtilities waitu=new WaitUtilities();
	@FindBy(xpath="/html/body/div[2]/header/nav/div/ul/li[2]/a/span")
	WebElement profiletitle;
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profile;
	@FindBy(xpath="//h1[text()='My Profile']")
	WebElement profilewelcomemessage;
	@FindBy(xpath="//input[@name='current_password']")
	WebElement currentpasswd;//
	@FindBy(xpath="//input[@name='new_password']")
	WebElement newpasswd;
	@FindBy(xpath="//input[@name='confirm_password']")
	WebElement confirmpasswd;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updatepasswd;
	@FindBy(xpath="//*[@id=\"edit_user_profile_form\"]/div[1]/div") 
	WebElement editprofilebox;
	@FindBy(xpath="//input[@name='surname']")
	WebElement surname;
	@FindBy(xpath="//input[@id=\"first_name\"]")
	WebElement firstname;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement languagefield;
	
	@FindBy(xpath="//*[@id=\"edit_user_profile_form\"]/div[1]/div/div/div[2]/div[5]/div/span[2]/span[1]/span/span[2]")
	WebElement languagedropdown;
	
	@FindBy(xpath="//*[@id=\"edit_user_profile_form\"]/div[2]/div/button")
	WebElement updateprofile ;
	@FindBy(xpath="/html/body/div[4]/div/div")
	public WebElement successmessage;
	

	public Profilepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean profilepageloading() {
		profiletitle.click();
		profile.click();
		return profilewelcomemessage.isDisplayed();
	}

	public boolean editprofile() {
		return editprofilebox.isDisplayed();

	}

	public void editprofilefn(String surnme, String fstnme, String lstnme, String emailid) {
		surname.click();
		surname.sendKeys(surnme);
		firstname.click();
		firstname.sendKeys(fstnme);
		lastname.click();
		lastname.sendKeys(lstnme);
		email.click();
		email.sendKeys(emailid);
		languagedropdown.click();
		pageu.sendKeystotextfieldMethod1(languagefield,Constants.language+Keys.ENTER );
		updateprofile.click();
		waitu.hardSleep(5000);
		successmessage.isDisplayed();
	}

	
}







