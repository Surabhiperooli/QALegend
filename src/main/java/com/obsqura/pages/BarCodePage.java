package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class BarCodePage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	@FindBy(xpath ="//a[@id='tour_step2_menu']")
	WebElement settings;
	@FindBy(xpath ="//span[text()='Barcode Settings']")
	WebElement barcodesettings;
	@FindBy(xpath ="//a[text()=' Add new setting']")
	WebElement addnewBarcode;
	@FindBy(xpath ="//input[@id='name']")
	WebElement stickersheetname;
	@FindBy(xpath ="//input[@name='top_margin']")
	WebElement topmargin;
	@FindBy(xpath ="//input[@name='left_margin']")
	WebElement leftmargin;
	@FindBy(xpath ="//input[@name='width']")
	WebElement widthofsticker;
	@FindBy(xpath ="//input[@name='height']")
	WebElement heightofsticker;
	@FindBy(xpath ="//input[@name='paper_width']")
	WebElement paperwidth;
	@FindBy(xpath ="//input[@name='paper_height']")
	WebElement paperheight;
	@FindBy(xpath ="//input[@name='stickers_in_one_row']")
	WebElement stickersinrow;
	@FindBy(xpath ="//input[@id='row_distance']")
	WebElement distancebtwnrows;
	@FindBy(xpath ="//input[@id='col_distance']")
	WebElement distancebtwncolumn;
	@FindBy(xpath ="//input[@id='stickers_in_one_sheet']")
	WebElement numberofstickers;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath ="//*[@id=\"toast-container\"]/div/div")
	public WebElement successmessage;
	@FindBy(xpath="//*[@id=\"barcode_table\"]/tbody/tr/td[3]/button[1]")
	WebElement deletbutton;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchfield;
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	WebElement deleteok;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement detetedtoastmessage;
	
	
	
	public BarCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String addNewBarcode() {
		settings.click();
		barcodesettings.click();
		addnewBarcode.click();
		pageu.clearAndEnterText(stickersheetname, Constants.STICKER_NAME);
		pageu.clearAndEnterText(topmargin, Constants.TOP_MARGIN);
		pageu.clearAndEnterText(leftmargin, Constants.LEFT_MARGIN);
		pageu.clearAndEnterText(widthofsticker, Constants.WIDTH);
		pageu.clearAndEnterText(heightofsticker, Constants.HEIGHT);
		pageu.clearAndEnterText(paperwidth, Constants.WIDTH);
		pageu.clearAndEnterText(paperheight, Constants.HEIGHT);
		pageu.clearAndEnterText(stickersinrow, Constants.STICKERS_IN_ROW);
		pageu.clearAndEnterText(distancebtwnrows, Constants.DISTANCE_BTWN_ROWS);
		pageu.clearAndEnterText(distancebtwncolumn, Constants.DISTANCE_BTWN_COLMNS);
		pageu.clearAndEnterText(numberofstickers, Constants.NO_OF_STICKERS);
		save.click();
		String actualmessage=genericu.getAttributeOfElement(successmessage);
		return actualmessage;
	}

	public String deleteBarCode() {
		settings.click();
		barcodesettings.click();
		pageu.clearAndEnterText(searchfield, Constants.STICKER_NAME);
		waitu.waitforelementtobeClickable(driver, deletbutton);
		deletbutton.click();
		deleteok.click();
		pageu.clearAndEnterText(searchfield, Constants.STICKER_NAME);
		String displaymessage=genericu.getAttributeOfElement(detetedtoastmessage);
		return displaymessage;
	}

}
