package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.StockAdjustmentPage;

public class StockAdjustmentPageTest extends TestHelper{
	@Test(groups={"Regression"})
	public void whetherUserCanAddNewStockAdjustment() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		StockAdjustmentPage stock=new StockAdjustmentPage(driver);
		Assert.assertEquals(stock.addStockAdjustment(),"Stock adjustment added successfully"); 
	}
}
