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
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class RolesPage {
	
	WebDriver driver;	
	PageUtilities pageu=new PageUtilities();
	public String originallist;
	public String newlist;
	WaitUtilities waitu=new WaitUtilities();
	
	
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
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchrole;
	@FindBy(xpath="//div[@class='dataTables_info']")
	public WebElement searchdata;
	@FindBy(xpath="//button[text()=' Delete']")
	WebElement delete;
	@FindBy(xpath="//button[text()='OK']")
	WebElement deleteok;
	@FindBy(xpath="//td[@class='dataTables_empty']")
	public WebElement searchdatadeletemsg;
	
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void endtour() {
		endtour.click();
	}
	public void addNewRole(String newrole) {
		dropdownbutton.click();
		roles.click();
		add.click();
		rolename.click();
		pageu.clearAndEnterText(rolename, Constants.NEWROLE);
		save.click();
		pageu.clearAndEnterText(searchrole,Constants.NEWROLE);
		boolean status=searchdata.isDisplayed();
		System.out.println(searchdata.isDisplayed());
		
	}
	public void deleteRole(String newrole) {
		dropdownbutton.click();
		roles.click();
		pageu.clearAndEnterText(searchrole, Constants.NEWROLE);
		delete.click();
		deleteok.click();
		pageu.clearAndEnterText(searchrole, Constants.NEWROLE);
		searchdatadeletemsg.isDisplayed();
		System.out.println(searchdatadeletemsg.isDisplayed());
	}
			
        
}
	

        
	
	
