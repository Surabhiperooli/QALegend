package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ProductPage;
import com.obsqura.utiities.ExcelUtilities;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class ProductPageTest extends TestHelper {
	
	
	@Test(dataProvider = "newproductData")
	public void verifyWhethertheUserCaNAddNewProduct(String productname, String unit, String barcode,
			String alertquantity, String exctax, String inctax) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		ProductPage productpage = new ProductPage(driver);
		productpage.addnewProduct(productname, unit, barcode, alertquantity, exctax, inctax);
		Assert.assertTrue(productpage.success.isDisplayed()) ;
			
	}

	@DataProvider(name = "newproductData")
	public Object[][] getInValidUsername() throws Throwable {
		String path = Constants.EXCEL_FILE_PATH;
		ExcelUtilities  excelu = new ExcelUtilities (path);
		int totalrows = excelu.getRowCount("Newproductdata");
		int totalcols = excelu.getCellCount("Newproductdata", 1);
		String getnewproductdata[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				getnewproductdata[i - 1][j] = excelu.getCellData("Newproductdata", i, j);
			}

		}
		return getnewproductdata;
	}

}
