package com.obsqura.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class RolesPage {
	
	WebDriver driver;	
	PageUtilities pageu=new PageUtilities();
	public String originallist;
	public String newlist;
	WaitUtilities waitu=new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath ="//span[(text()='User Management')]")
	WebElement dropdownbutton;
	@FindBy(xpath="//i[@class='fa fa-briefcase']")
	WebElement roles;
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add;
	@FindBy(id="name")
	WebElement rolename;
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement save;
	@FindBy(xpath="//div[text()='Role added successfully']")
	WebElement successmessage;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchrole;
	@FindBy(xpath="//div[@class='dataTables_info']")
	public WebElement searchdata;
	@FindBy(xpath="//button[text()=' Delete']")
	WebElement delete;
	@FindBy(xpath="//button[text()='OK']")
	WebElement deleteok;
	@FindBy(xpath="//div[text()='Role deleted successfully']")
	public WebElement deletemsg;
	
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void endtour() {
		genericu.clickOnElement(endtour);
	}
	public String addNewRole() {
		genericu.clickOnElement(dropdownbutton);
		genericu.clickOnElement(roles);
		genericu.clickOnElement(add);
		genericu.clickOnElement(rolename);
		pageu.clearAndEnterText(rolename, Constants.NEWROLE);
		genericu.clickOnElement(save);
		pageu.clearAndEnterText(searchrole,Constants.NEWROLE);
		String addedmessage=genericu.getAttributeOfElement(successmessage);
		return addedmessage;
	}
	public String deleteRole() {
		genericu.clickOnElement(dropdownbutton);
		genericu.clickOnElement(roles);
		pageu.clearAndEnterText(searchrole, Constants.NEWROLE);
		genericu.clickOnElement(delete);
		waitu.waitforelementtobeClickable(driver, deleteok);
		genericu.clickOnElement(deleteok);
		String message=genericu.getTextOfElement(deletemsg);
		return message;
	}
			
        
}
	

        
	
	
