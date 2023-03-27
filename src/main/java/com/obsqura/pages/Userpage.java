package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Userpage {
	WebDriver driver;
	WaitUtilities waitu = new WaitUtilities();
	PageUtilities pageu = new PageUtilities();
	GenericUtilities genericu=new GenericUtilities();
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath = "//span[(text()='User Management')]")
	WebElement usermanagement;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']")
	WebElement users;
	@FindBy(xpath = "//span[(text()='User Management')]")
	WebElement dropdownbutton;
	@FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
	WebElement useroption;
	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addoptiontext;
	@FindBy(xpath = "//input[@id='surname']")
	WebElement surnamefield;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstnamefield;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastnamefield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//*[@id=\"user_add_form\"]/div[1]/div/div/div/div[6]/div/span/span[1]/span")
	WebElement roles;
	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	WebElement roleselectionfield;
	@FindBy(xpath = "//*[@id=\"select2-role-result-liv9-688\"]")
	WebElement engineer;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//input[@name='confirm_password']")
	WebElement passwordconfirmfield;
	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement percentageselection;
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']/li[1]")WebElement userstet;
	@FindBy(xpath = "//*[@id=\"user_add_form\"]/div[1]/div/div/div/div[11]/div/div/label/div/ins")
	WebElement checkboxx;
	@FindBy(xpath = "//input[@id='status_span']")
	WebElement useraddedmessage;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement savebutton;
	@FindBy(xpath = "//*[@class='toast-message']")
	public WebElement successmessage;
	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deletebutton;
	@FindBy(xpath = "//div[@class='swal-modal']")
	WebElement dialogbox;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okbutton;
	@FindBy(xpath = "//*[@class='toast-message']")
	public WebElement delmsg;
	@FindBy(xpath = "//*[@id=\"users_table\"]/tbody/tr/td[5]/a[2]")
	public WebElement viewuser;
	@FindBy(xpath ="/html/body/div[2]/div[1]/section[2]") 
	public WebElement viewusercontent;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[1]/h1")
	WebElement manageuser;
	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addoption;
	@FindBy(xpath = "//h1[text()='Add user']")
	WebElement addusertext;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchbutton;
	@FindBy(xpath = "//*[@id=\"users_table\"]/tbody/tr/td")
	WebElement nomatchingmessage;

	public Userpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void endtour() {
		endtour.click();
	}

	public String addnewUserfunction(String surnme, String frstnme, String lstnme, String email, String paswd,
			String confrmpaswd) {

		usermanagement.click();
		useroption.click();
		addoptiontext.click();
		pageu.clearAndEnterText(surnamefield, surnme);
		pageu.clearAndEnterText(firstnamefield, frstnme);
		pageu.clearAndEnterText(lastnamefield, lstnme);
		pageu.clearAndEnterText(emailfield, email);
		roles.click();
		pageu.clearAndEnterText(roleselectionfield, Constants.ROLE + Keys.ENTER);
		pageu.clearAndEnterText(passwordfield, paswd);
		pageu.clearAndEnterText(passwordconfirmfield, confrmpaswd);
		savebutton.click();
		String actualmessage=genericu.getAttributeOfElement(successmessage);
		return actualmessage;
	}

	public void userDeleteFunctionWorking(String usrnmee) {
		usermanagement.click();
		useroption.click();
		pageu.clearAndEnterText(searchbutton, Constants.NEWUSER_NAME);
		deletebutton.click();
		waitu.waitforelementtobeClickable(driver,okbutton );
		okbutton.click();
		System.out.println(delmsg.isDisplayed());
	}

	public void viewUserOption() {
		usermanagement.click();
		useroption.click();
		viewuser.click();
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(viewusercontent.isDisplayed());

	}

}
