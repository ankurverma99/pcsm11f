package org.qsp.test;

import org.qsp.genric.BaseTest;
import org.qsp.genric.ReadData;
import org.qsp.pom.EnterTimeTracker;
import org.qsp.pom.LogIn;
import org.testng.annotations.Test;

public class TestEnterTimeTrack extends BaseTest {
	@Test
	public void testCaseETT() throws Exception {
		String user = ReadData.readCell(excel_path, sheetName, 1, 0);
		String pass = ReadData.readCell(excel_path, sheetName, 1, 1);
		LogIn l = new LogIn(driver);
		l.sendUsername(user);
		l.sendPassword(pass);
		l.loginClick();
		EnterTimeTracker ett = new EnterTimeTracker(driver);
		ett.verfiyHPisDisplayed(driver, ETO);
		ett.newClick();
		ett.comboClick();
		ett.newCustomerClick();
		ett.customerName("ankur");
		ett.projectName("qspiders");
		Thread.sleep(2000);
	}
}
