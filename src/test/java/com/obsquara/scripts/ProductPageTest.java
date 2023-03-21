package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProductPage;

import excelutiities.NewExcelLibrary;

public class ProductPageTest extends TestHelper {
	
	@Test

	public void verifyClickingonDeactiveselectiveButtonShowsWarningMessageAlert() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		ProductPage productpage = new ProductPage(driver);
		productpage.deactiveSelectedWarningMessage();
		if (productpage.deactivatedtoastmessage.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test(dataProvider = "newproductData")
	public void verifyWhethertheUserCaNAddNewProduct(String productname, String unit, String barcode,
			String alertquantity, String exctax, String inctax) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		ProductPage productpage = new ProductPage(driver);
		productpage.addnewProduct(productname, unit, barcode, alertquantity, exctax, inctax);
		if (productpage.success.isDisplayed()) {
			Assert.assertTrue(true, "Save message Displayed");
		} else {
			Assert.assertTrue(false, "Save message not displayed");
		}

	}

	@DataProvider(name = "newproductData")
	public Object[][] getInValidUsername() throws Throwable {
		String path = Constants.EXCEL_FILE_PATH+"\\NewProductData.xlsx";
		NewExcelLibrary lib = new NewExcelLibrary(path);
		int totalrows = lib.getRowCount("Sheet1");
		int totalcols = lib.getCellCount("Sheet1", 1);
		String getnewproductdata[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				getnewproductdata[i - 1][j] = lib.getCellData("Sheet1", i, j);
			}

		}
		return getnewproductdata;
	}

}
